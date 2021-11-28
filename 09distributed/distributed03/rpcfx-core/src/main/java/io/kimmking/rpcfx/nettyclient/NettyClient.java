package io.kimmking.rpcfx.nettyclient;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

@Slf4j
public class NettyClient extends AbstractClient {

    private Bootstrap bootstrap;

    private volatile Channel channel;

    private static final NioEventLoopGroup NIO_GROUP = new NioEventLoopGroup();

    public NettyClient(@NonNull String hostName, @NonNull int port, @NonNull int connectionTimeout) {
        super(hostName, port, connectionTimeout);
    }

    private class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
            try {
                respMsg = msg.toString(StandardCharsets.UTF_8);
            } finally {
                countDownLatch.countDown();
                ctx.close();
            }
        }
    }

    @Override
    protected void doOpen() throws Throwable {
        bootstrap = new Bootstrap();
        bootstrap.group(NIO_GROUP)
                .remoteAddress(getRemoteAddress())
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, getConnectionTimeout())
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ClientHandler());
                    }
                });
    }

    @Override
    protected void doConnect() throws Throwable {
        ChannelFuture f = bootstrap.connect().syncUninterruptibly();
        if (!f.isSuccess() && null != f.cause()) {
            log.error("The client failed to connect the server:" + getRemoteAddress() + ",error message is:" +
                    f.cause().getMessage());
        }
    }

    @Override
    protected Channel getChannel() {
        return channel;
    }
}

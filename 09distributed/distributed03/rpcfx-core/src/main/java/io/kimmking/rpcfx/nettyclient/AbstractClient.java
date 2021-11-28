package io.kimmking.rpcfx.nettyclient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.NotImplementedException;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
abstract class AbstractClient implements EndPoint {

    @NonNull
    private String hostName;

    @NonNull
    private int port;

    @NonNull
    @Getter(value = AccessLevel.PROTECTED)
    private int connectionTimeout;

    protected final CountDownLatch countDownLatch = new CountDownLatch(1);
    protected String respMsg;

    @SneakyThrows
    public void send(Object message) {
        doOpen();
        doConnect();
        write(message);
    }

    @SneakyThrows
    public String receive() {
        boolean b = countDownLatch.await(getConnectionTimeout(), TimeUnit.MILLISECONDS);
        if (!b) {
            log.error("Timeout(" + getConnectionTimeout() + "ms) when receiving response message");
        }
        return respMsg;
    }

    private void write(Object message) {
        Channel channel = getChannel();
        if (null != channel) {
            ChannelFuture f = channel.writeAndFlush(byteBufferFrom(message)).syncUninterruptibly();
            if (!f.isSuccess()) {
                log.error("Failed to send message to " + getRemoteAddress() + f.cause().getMessage());
            }
        }
    }

    private ByteBuf byteBufferFrom(Object message) {
        return message instanceof String ? Unpooled.copiedBuffer((String) message, StandardCharsets.UTF_8) :
                Unpooled.copiedBuffer((byte[]) message);
    }

    public InetSocketAddress getRemoteAddress() {
        return new InetSocketAddress(hostName, port);
    }

    public InetSocketAddress getLocalAddress() {
        throw new NotImplementedException("This method is not need to be implemented");
    }

    protected abstract void doOpen() throws Throwable;

    protected abstract void doConnect() throws Throwable;

    protected abstract Channel getChannel();
}

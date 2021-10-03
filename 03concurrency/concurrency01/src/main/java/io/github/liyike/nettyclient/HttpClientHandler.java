package io.github.liyike.nettyclient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

public class HttpClientHandler extends SimpleChannelInboundHandler<FullHttpResponse> {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        URI uri = new URI("http://127.0.0.1:8888");
        String msg = "Are you ok?";
        FullHttpRequest request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET,
                uri.toASCIIString(), Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
        request.headers().set(HttpHeaderNames.CONTENT_LENGTH, request.content().readableBytes());
        ctx.channel().writeAndFlush(request);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpResponse msg) throws Exception {
        FullHttpResponse response = msg;
        response.headers().get(HttpHeaderNames.CONTENT_TYPE);
        ByteBuf buf = response.content();
        System.out.println(buf.toString(CharsetUtil.UTF_8));
    }
}

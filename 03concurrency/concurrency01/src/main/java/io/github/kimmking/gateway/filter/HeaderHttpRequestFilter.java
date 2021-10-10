package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

public class HeaderHttpRequestFilter implements HttpRequestFilter {

    /**
     * 实现过滤器
     */
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println("filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx)接受到的请求，url：" + uri);
        if (uri.startsWith("/hello")) {
            // 放过
        } else {
            throw new RuntimeException("不支持的uri:" + uri);
        }
        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.set("xjava", "liyike");

    }
}

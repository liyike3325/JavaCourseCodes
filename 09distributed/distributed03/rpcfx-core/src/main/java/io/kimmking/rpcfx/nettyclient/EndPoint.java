package io.kimmking.rpcfx.nettyclient;

import java.net.InetSocketAddress;

public interface EndPoint {

    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();
}

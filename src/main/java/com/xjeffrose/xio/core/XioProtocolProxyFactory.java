package com.xjeffrose.xio.core;

import io.netty.channel.ChannelInboundHandler;


public interface XioProtocolProxyFactory {
    ChannelInboundHandler getProtocolProxy();
}

package com.xjeffrose.xio.server;

import com.xjeffrose.xio.core.*;
import com.xjeffrose.xio.processor.XioProcessorFactory;
import io.airlift.units.Duration;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;

public class XioServerDef {
  private final int serverPort;
  private final int maxFrameSize;
  private final int maxConnections;
  private final int queuedResponseLimit;
  private final XioProcessorFactory processorFactory;
  private final Duration clientIdleTimeout;
  private final Duration taskTimeout;
  private final Executor executor;
  private final String name;
  private final XioSecurityFactory securityFactory;
  private final XioCodecFactory codecFactory;
  private final XioAggregatorFactory aggregatorFactory;
  private final InetSocketAddress hostAddress;
  private final XioRoutingFilterFactory routingFilterFactory;
  private final XioProtocolProxyFactory protocolProxyFactory;

  public XioServerDef(
      String name,
      int serverPort,
      InetSocketAddress hostAddress,
      int maxFrameSize,
      int queuedResponseLimit,
      int maxConnections,
      XioProcessorFactory processorFactory,
      Duration clientIdleTimeout,
      Duration taskTimeout,
      Executor executor,
      XioSecurityFactory securityFactory,
      XioCodecFactory codecFactory,
      XioAggregatorFactory aggregatorFactory,
      XioRoutingFilterFactory routingFilterFactory,
      XioProtocolProxyFactory protocolProxyFactory) {

    this.name = name;
    this.serverPort = serverPort;
    this.hostAddress = hostAddress;
    this.maxFrameSize = maxFrameSize;
    this.maxConnections = maxConnections;
    this.queuedResponseLimit = queuedResponseLimit;
    this.processorFactory = processorFactory;
    this.clientIdleTimeout = clientIdleTimeout;
    this.taskTimeout = taskTimeout;
    this.executor = executor;
    this.securityFactory = securityFactory;
    this.codecFactory = codecFactory;
    this.aggregatorFactory = aggregatorFactory;
    this.routingFilterFactory = routingFilterFactory;
    this.protocolProxyFactory = protocolProxyFactory;
  }

  public static XioServerDefBuilder newBuilder() {
    return new XioServerDefBuilder();
  }

  public int getServerPort() {
    return serverPort;
  }

  public InetSocketAddress getHostAddress() {
    return hostAddress;
  }

  public int getMaxFrameSize() {
    return maxFrameSize;
  }

  public int getMaxConnections() {
    return maxConnections;
  }

  public int getQueuedResponseLimit() {
    return queuedResponseLimit;
  }

  public XioProcessorFactory getProcessorFactory() {
    return processorFactory;
  }

  public Duration getClientIdleTimeout() {
    return clientIdleTimeout;
  }

  public Duration getTaskTimeout() {
    return taskTimeout;
  }

  public Executor getExecutor() {
    return executor;
  }

  public String getName() {
    return name;
  }

  public XioSecurityFactory getSecurityFactory() {
    return securityFactory;
  }

  public XioCodecFactory getCodecFactory() {
    return codecFactory;
  }

  public XioAggregatorFactory getAggregatorFactory() {
    return aggregatorFactory;
  }

  public XioRoutingFilterFactory getRoutingFilterFactory() {
    return routingFilterFactory;
  }

  public XioProtocolProxyFactory getProtocolProxyFactory() {
    return protocolProxyFactory;
  }
}
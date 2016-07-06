package com.xjeffrose.xio.client.asyncretry;

import io.netty.channel.EventLoopGroup;
import io.netty.channel.ConnectTimeoutException;
import java.net.ConnectException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.log4j.Logger;

public class AsyncRetryLoop implements AsyncRetryLoopFactory {
  private final int attemptLimit;
  private final EventLoopGroup eventLoopGroup;
  private final long delay;
  private final TimeUnit unit;
  private int attemptCount = 0;

  public AsyncRetryLoop(int attemptLimit, EventLoopGroup eventLoopGroup, long delay, TimeUnit unit) {
    this.attemptLimit = attemptLimit;
    this.eventLoopGroup = eventLoopGroup;
    this.delay = delay;
    this.unit = unit;
  }

  public void attempt(Runnable action) {
    attemptCount++;
    if (attemptCount == 0) {
      action.run();
    } else {
      eventLoopGroup.schedule(action, delay, unit);
    }
  }

  public boolean canRetry() {
    return attemptCount < attemptLimit;
  }

  @Override public AsyncRetryLoop buildLoop(EventLoopGroup eventLoopGroup) {
    return new AsyncRetryLoop(4,eventLoopGroup, 100,TimeUnit.MILLISECONDS);
  }
}
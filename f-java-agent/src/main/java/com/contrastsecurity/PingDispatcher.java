package com.contrastsecurity;

import java.util.concurrent.atomic.AtomicInteger;

public class PingDispatcher {
  final static AtomicInteger pingCount = new AtomicInteger();

  public static void dispatch(){
    System.out.println(pingCount.incrementAndGet());
  }
}

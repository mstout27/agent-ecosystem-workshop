package com.contrastsecurity;

import java.lang.instrument.Instrumentation;

public class TestAgent {

  public static void premain(final String agentArgs, final Instrumentation instr){
    instr.addTransformer(new TestTransformer());
  }

}

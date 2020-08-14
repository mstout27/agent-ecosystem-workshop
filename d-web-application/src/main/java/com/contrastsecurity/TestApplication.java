package com.contrastsecurity;

import java.util.Set;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("/api")
public class TestApplication extends javax.ws.rs.core.Application {

  @Override
  public Set<Class<?>> getClasses() {
    return Set.of(JerseyEndpoint.class);
  }
}

package com.contrastsecurity;


import javax.ws.rs.core.UriBuilder;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class HelloWorld{
  public static void main(String[] args){
    System.out.println("Hello World");
    final ResourceConfig resourceConfig = ResourceConfig.forApplication(new TestApplication());
    final HttpServer httpServer = GrizzlyHttpServerFactory.createHttpServer(UriBuilder.fromUri("http://localhost/").port(8080).build(), resourceConfig);
  }
}
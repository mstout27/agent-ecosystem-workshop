package com.contrastsecurity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletEndpoint", urlPatterns = {"/ping"}, loadOnStartup = 1)
public class ServletEndpoint extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.getWriter().print("Hello world");
  }
}

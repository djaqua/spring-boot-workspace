package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
      throws IOException, ServletException {
    try {
      Authentication auth = AuthenticationService.getAuthentication((HttpServletRequest) req);
      SecurityContextHolder.getContext().setAuthentication(auth);
    } catch (Exception exc) {
      HttpServletResponse httpRes = (HttpServletResponse) res;
      httpRes.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      httpRes.setContentType(MediaType.APPLICATION_JSON_VALUE);
      PrintWriter writer = httpRes.getWriter();
      writer.print(exc.getMessage());
      writer.flush();
      writer.close();
    }
    chain.doFilter(req, res);
  }
}

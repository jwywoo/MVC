package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet implements Servlet {
    private static final Logger log = LoggerFactory.getLogger(CalculatorServlet.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
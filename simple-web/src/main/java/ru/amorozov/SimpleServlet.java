package ru.amorozov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class SimpleServlet implements javax.servlet.Servlet {

    private static final Logger logger = LoggerFactory.getLogger(SimpleServlet.class);

    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        logger.info("FirstServlet is initialized");
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return this.config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request to FirstServlet");
        res.getWriter().println("<h1>Hello from Servlet</h1>");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

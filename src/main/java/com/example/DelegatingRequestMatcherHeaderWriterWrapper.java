package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.header.writers.DelegatingRequestMatcherHeaderWriter;

public class DelegatingRequestMatcherHeaderWriterWrapper implements HeaderWriter {

    private final DelegatingRequestMatcherHeaderWriter headerWriter;
    
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public DelegatingRequestMatcherHeaderWriterWrapper(DelegatingRequestMatcherHeaderWriter headerWriter) {
        this.headerWriter = headerWriter;
    }
    
    @Override
    public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
        logger.info("Request URI :{}", request.getRequestURI());
        logger.info("Servlet Path:{}", request.getServletPath());
        logger.info("Path Info   :{}", request.getPathInfo());
        headerWriter.writeHeaders(request, response);
    }

}

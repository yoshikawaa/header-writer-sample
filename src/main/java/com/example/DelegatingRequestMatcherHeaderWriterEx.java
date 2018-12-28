package com.example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.header.HeaderWriter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.Assert;

public class DelegatingRequestMatcherHeaderWriterEx implements HeaderWriter {
    private final RequestMatcher requestMatcher;

    private final HeaderWriter delegateHeaderWriter;

    private final String attributeNameRequestMatched = super.toString() + "." + "REQUEST_MATCHED";
    
    /**
     * Creates a new instance
     *
     * @param requestMatcher the {@link RequestMatcher} to use. If returns true, the
     * delegateHeaderWriter will be invoked.
     * @param delegateHeaderWriter the {@link HeaderWriter} to invoke if the
     * {@link RequestMatcher} returns true.
     */
    public DelegatingRequestMatcherHeaderWriterEx(RequestMatcher requestMatcher,
            HeaderWriter delegateHeaderWriter) {
        Assert.notNull(requestMatcher, "requestMatcher cannot be null");
        Assert.notNull(delegateHeaderWriter, "delegateHeaderWriter cannot be null");
        this.requestMatcher = requestMatcher;
        this.delegateHeaderWriter = delegateHeaderWriter;
    }

    public void determineRequestMatches(HttpServletRequest request) {
        request.setAttribute(this.attributeNameRequestMatched, this.requestMatcher.matches(request));
    }
    
    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.web.headers.HeaderWriter#writeHeaders(javax.servlet
     * .http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public void writeHeaders(HttpServletRequest request, HttpServletResponse response) {
        Object requestMatched = request.getAttribute(this.attributeNameRequestMatched);
        if (requestMatched != null && requestMatched instanceof Boolean && (Boolean) requestMatched) {
            this.delegateHeaderWriter.writeHeaders(request, response);
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + " [requestMatcher=" + this.requestMatcher
                + ", delegateHeaderWriter=" + this.delegateHeaderWriter + "]";
    }
}

package ru.goryacheva.springbootstarterhw.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

/**
 * фильтр для логгирования запросов и ответов
 */
//https://stackoverflow.com/questions/39935190/contentcachingresponsewrapper-produces-empty-response
//https://www.baeldung.com/spring-reading-httpservletrequest-multiple-times
@Slf4j
public class LogFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        long startTime = System.currentTimeMillis();

        log.info("Request content method: {}, url: {}, headers: {}", requestWrapper.getMethod(),
                requestWrapper.getRequestURL().toString(), new ServletServerHttpRequest(requestWrapper).getHeaders());

        filterChain.doFilter(requestWrapper, responseWrapper);

        log.info("Response content status: {}, headers: {}", responseWrapper.getStatus(),
                new ServletServerHttpResponse(responseWrapper).getHeaders());

        long endTime = System.currentTimeMillis();

        log.info("Method completed for: {}", endTime - startTime);

        responseWrapper.copyBodyToResponse();
    }
}

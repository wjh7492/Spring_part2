package com.gudi.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CORSFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletRresponse, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
//	    System.out.println("Request request.getMethod()");

	    HttpServletResponse resp = (HttpServletResponse) servletRresponse;
	    resp.addHeader("Access-Control-Allow-Origin","*");
	    resp.addHeader("Access-Control-Allow-Methods","GET,POST");
	    resp.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

	    if ( request.getMethod().equals("OPTIONS") ) {
	        resp.setStatus(HttpServletResponse.SC_OK);
	        return;
	    }
	    chain.doFilter(request, servletRresponse);
	}

	@Override
	public void destroy() {}

}

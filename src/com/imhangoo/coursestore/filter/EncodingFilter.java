package com.imhangoo.coursestore.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private String encoding;

	@Override
	public void destroy() {
		System.out.println("end do the encoding filter!");
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("before encoding " + encoding + " filter！");
		req.setCharacterEncoding(encoding);
		chain.doFilter(req, resp);
		System.out.println("after encoding " + encoding + " filter！");
		System.err.println("----------------------------------------");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("begin do the encoding filter!");
		encoding = config.getInitParameter("encoding");
	}

}

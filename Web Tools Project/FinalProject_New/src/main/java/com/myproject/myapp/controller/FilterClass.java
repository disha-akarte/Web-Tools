package com.myproject.myapp.controller;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;


public class FilterClass implements Filter {

	 
	  
    @Override
    public void init(FilterConfig fc) throws ServletException {
       
    }

    @Override
   public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws IOException, ServletException
   {
    	HttpServletResponse hsr = (HttpServletResponse) res;
    	hsr.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    	hsr.setHeader("Pragma", "no-cache");
    	hsr.setDateHeader("Expires", 0); 
    	chain.doFilter(req, res);
        
   
   }
    @Override
    public void destroy() {    
    }
}

package com.fdl.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;

import com.fdl.dao.FdlDao;
import com.fdl.entity.Graph;

/**
 * Servlet implementation class doExtraction
 */

@Component("doExtraction")
public class doExtraction implements HttpRequestHandler {
	
	@Autowired
	private FdlDao fdlDao;

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		fdlDao.addGraph();		
	}


	
}

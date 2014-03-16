package com.fdl.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.fdl.dao.FdlDao;
import com.fdl.entity.Graph;

public class Execute {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext appContext = new FileSystemXmlApplicationContext("WebContent/applicationContext.xml");
	  	ApplicationContext context = new FileSystemXmlApplicationContext(appContext);
		FdlDao fdlDao=(FdlDao) context.getBean("fdlDao");
		System.out.println(fdlDao.toString());
		
		//Graph graph = fdlDao.addAuthor("ZZZZZ");


	}

}

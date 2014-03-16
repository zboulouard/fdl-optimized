package com.fdl.xml.read;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {


	public static void main(String[] args) {
//		ReadXMLFile xmlFile = new ReadXMLFile();
//		xmlFile.read();
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"config.xml"});
		ReadXMLFile reader = (ReadXMLFile) context.getBean("read");
		reader.read();

	}

}

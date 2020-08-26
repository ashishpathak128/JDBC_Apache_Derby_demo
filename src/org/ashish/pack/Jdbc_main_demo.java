package org.ashish.pack;

import org.ashish.pack.dao.HibernatedaoImpl;
import org.ashish.pack.dao.JavaDaoImpl;
import org.ashish.pack.dao.SimpleJdbcDaosupportImpl;
import org.ashish.pack.model.Circle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Jdbc_main_demo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring.xml");
		//JavaDaoImpl dao = ctx.getBean("javaDaoImpl", JavaDaoImpl.class);
		/*
		 * Circle circle = dao.getCircle(1); System.out.println(circle.getName());
		 */
		/*
		 * System.out.println(dao.getCircleCount());
		 * System.out.println(dao.getCircleName(1));
		 * System.out.println(dao.getCircleForId(1).getName());
		 */
		/*
		 * dao.insertCircle(new Circle(8,"Eight Circle"));
		 * System.out.println(dao.allCircle().size());
		 */
		/*
		 * SimpleJdbcDaosupportImpl dao = ctx.getBean("simplejdbcdaosupportImpl",
		 * SimpleJdbcDaosupportImpl.class);
		 */
		HibernatedaoImpl dao = ctx.getBean("hibernatedaoImpl", HibernatedaoImpl.class);
		 System.out.println(dao.getCircleCount());
		//dao.createTable();

	}

}

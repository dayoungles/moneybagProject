package webserver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class CustomContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		sc.setAttribute("realPath", sc.getRealPath("/"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!custom contextListener worked");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}

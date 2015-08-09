package webserver;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import service.UploadService;

@WebListener
public class CustomContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		UploadService.path = sc.getRealPath("/");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}

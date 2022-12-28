package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * count変数（訪問回数）を初期化するリスナー
 */
@WebListener
public class ListenerSample implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	Integer count = 0;
    	context.setAttribute("count", count);
    	System.out.println("リスナーが動きました");
    }
	
}

package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ImageSetListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	String img_pencil = "<img src='/chap13/img/pencil.png' alt='編集' class='img-pencil'>";
    	String img_trash = "<img src='/chap13/img/trash.png' alt='削除' class='img-trash'>";
    	String img_find = "<img src=\"/chap13/img/find.png\" alt=\"検索\" class=\"img-find\">";
    	context.setAttribute("img_pencil", img_pencil);
    	context.setAttribute("img_trash", img_trash);
    	context.setAttribute("img_find", img_find);
    }
	
}

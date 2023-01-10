package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Dept;
import model.logic.GetDeptListLogic;

@WebListener
public class ScopeSetListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { }

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	String img_pencil = "<img src='" + context.getContextPath() + "/img/pencil.png' alt='編集' class='img-pencil'>";
    	String img_trash = "<img src='" + context.getContextPath() + "/img/trash.png' alt='削除' class='img-trash'>";
    	context.setAttribute("img_pencil", img_pencil);
    	context.setAttribute("img_trash", img_trash);
    
    	// List<Dept> をスコープに保存
    	GetDeptListLogic logic = new GetDeptListLogic();
    	List<Dept> deptList = logic.execute();
    	context.setAttribute("deptList", deptList);
    }
	
}

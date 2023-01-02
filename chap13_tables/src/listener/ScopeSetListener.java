package listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.Dept;
import model.logic.GetDeptListLogic;
import model.logic.GetLastIdLogic;

@WebListener
public class ScopeSetListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {}

    public void contextInitialized(ServletContextEvent sce)  { 
    	ServletContext context = sce.getServletContext();
    	String img_pencil = "<img src='" + context.getContextPath() 
    	                  + "/img/pencil.png' alt='編集' class='img-pencil'>";
    	String img_trash = "<img src='" + context.getContextPath()
    	                  + "/img/trash.png' alt='削除' class='img-trash'>";
    	String img_find = "<img src=\"" + context.getContextPath()
		                  + "/img/find.png\" alt=\"検索\" class=\"img-find\">";
    	context.setAttribute("img_pencil", img_pencil);
    	context.setAttribute("img_trash", img_trash);
    	context.setAttribute("img_find", img_find);

    	// jspでの表示のための deptList
    	GetDeptListLogic logic = new GetDeptListLogic();
    	List<Dept> deptList = logic.execute();
    	context.setAttribute("deptList", deptList);
    	
    	// 現在の id の値を取得する
    	GetLastIdLogic logic2 = new GetLastIdLogic();
    	Integer lastId = logic2.execute();
    	context.setAttribute("lastId", lastId);
    }
	
}

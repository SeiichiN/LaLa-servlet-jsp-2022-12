package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * アプリケーションスコープにインスタンスを
 * 保存しようとすると警告が出る。
 */
@WebListener
public class NoAppScopeListener implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
    	System.out.println
    	  ("警告：格納は禁止されています");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  {}

    public void attributeReplaced(ServletContextAttributeEvent scae)  {}
	
}

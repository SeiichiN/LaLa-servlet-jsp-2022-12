<%@ page language="java" pageEncoding="UTF-8"%>
<aside>
  <h1>メニュー</h1>
  <ul>
	  <li><a href="${pageContext.request.contextPath}/create">新規社員登録</a></li>
	  <li>
	  	<form action="${pageContext.request.contextPath}/findName" method="post" class="search-form">
	  	  <input type="text" name="name" placeholder="社員名検索" class="search-box">
	  	  <button type="submit" 
	  	          class="search-img no-border no-background">
	  	          ${img_find}
	  	  </button>
	  	</form>
	  </li>
  </ul>
</aside>	

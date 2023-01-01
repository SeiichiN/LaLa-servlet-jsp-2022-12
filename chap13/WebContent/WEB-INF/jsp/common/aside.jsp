<%@ page language="java" pageEncoding="UTF-8"%>
<% 
String img_find = "<img src=\"/chap13/img/find.png\" alt=\"検索\" class=\"img-find\">";
%>
<aside>
  <h1>メニュー</h1>
  <ul>
	  <li><a href="/chap13/create">新規社員登録</a></li>
	  <li>
	  	<form action="/chap13/findName" method="post" class="search-form">
	  	  <input type="text" name="name" placeholder="社員名検索" class="search-box">
	  	  <button type="submit" 
	  	          class="search-img no-border no-background">
	  	          <%= img_find %>
	  	  </button>
	  	</form>
	  </li>
  </ul>
</aside>	

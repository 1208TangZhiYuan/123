<%@include file="header.jsp"%>
 <h2>Welcome to My Online Shop Home Page.</h2><br>
 <form method=" get" target='_blank' action="search">
 <!--<url-pattern>/search</url-pattern>-->|
  <input type="text"name="txt"size=30/>
  <select name="search">
    <option value="baidu">Baidu</option>
    <option value="bing">Bing</option>
    <option value="google">Google</option>
  </select>
  <input type="submit"value="Search"/>
  </form>
  <a href="search.jsp">点击这里进行搜索</a>
<%@include file="footer.jsp"%>

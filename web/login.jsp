<%@ include file="header.jsp" %>


<body>
<h1>Login</h1>
<form method="POST" action="LoginServlet">
  <label for="username">Username:</label>
  <input type="text" id="username" name="username"><br><br>
  <label for="password">Password:</label>
  <input type="password" id="password" name="password"><br><br>
  <input type="submit" value="Login">
</form>
<h1>${message}</h1>
</body>

<%@ include file="footer.jsp" %>

<%@ page language="java" %>
<%@ page contentType="text/html; charset=utf-8" %>
<div class="container">
<center>
<div style="padding: 20px 10px 10px 10px;max-width:640px;">
  <div class="tb">Вход в систему</div>
  <hr style="margin: 5px 0 10px 0"/>
  <form class="login-pane" action='j_security_check' method='post' id="form">
      <input type="text" id="inputEmail" name="j_username" placeholder="Логин"/>
      <input type="password" name="j_password" id="inputPassword" placeholder="Пароль" autocomplete="off"/>
     <button type="submit" class="btn btn-warning">Войти</button>
  </form>

  <div style="margin: 20px 0; text-align:right">
    <a href="#">Забыли пароль?</a>
  </div>
  <div id="footer">
      &copy; МОН РК
  </div>
</div>
</center>
</div>
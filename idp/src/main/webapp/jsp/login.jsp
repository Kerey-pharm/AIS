<%@ page language="java" %>
<%@ page contentType="text/html; charset=utf-8" %>

<%
    boolean mob  = false;
	String ua=request.getHeader("User-Agent").toLowerCase();
	if(ua.matches("(?i).*((android|bb\\d+|meego).+mobile|avantgo|bada\\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od|ad)|iris|kindle|lge |maemo|midp|mmp|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\\.(browser|link)|vodafone|wap|windows (ce|phone)|xda|xiino).*")||ua.substring(0,4).matches("(?i)1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s\\-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|\\-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw\\-(n|u)|c55\\/|capi|ccwa|cdm\\-|cell|chtm|cldc|cmd\\-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc\\-s|devi|dica|dmob|do(c|p)o|ds(12|\\-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(\\-|_)|g1 u|g560|gene|gf\\-5|g\\-mo|go(\\.w|od)|gr(ad|un)|haie|hcit|hd\\-(m|p|t)|hei\\-|hi(pt|ta)|hp( i|ip)|hs\\-c|ht(c(\\-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i\\-(20|go|ma)|i230|iac( |\\-|\\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\\/)|klon|kpt |kwc\\-|kyo(c|k)|le(no|xi)|lg( g|\\/(k|l|u)|50|54|\\-[a-w])|libw|lynx|m1\\-w|m3ga|m50\\/|ma(te|ui|xo)|mc(01|21|ca)|m\\-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(\\-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)\\-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|\\-([1-8]|c))|phil|pire|pl(ay|uc)|pn\\-2|po(ck|rt|se)|prox|psio|pt\\-g|qa\\-a|qc(07|12|21|32|60|\\-[2-7]|i\\-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h\\-|oo|p\\-)|sdk\\/|se(c(\\-|0|1)|47|mc|nd|ri)|sgh\\-|shar|sie(\\-|m)|sk\\-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h\\-|v\\-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl\\-|tdg\\-|tel(i|m)|tim\\-|t\\-mo|to(pl|sh)|ts(70|m\\-|m3|m5)|tx\\-9|up(\\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|\\-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(\\-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas\\-|your|zeto|zte\\-")) 
	{ mob = true;}
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,,chrome=1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name='viewport' content='initial-scale=1, maximum-scale=1, user-scalable=no'/>  
<meta name='apple-mobile-web-app-capable' content='yes'/>  
<meta name='apple-mobile-web-app-status-bar-style' content='black'/>  
<link href="stylesheet/bootstrap2.1/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="stylesheet/glyphicons/glyphicons.min.css" rel="stylesheet" type="text/css"/>
<!--[if IE 6]><link href="msie6.css" rel="stylesheet" type="text/css"/><![endif]-->
<!--[if IE 7]><link href="msie7.css" rel="stylesheet" type="text/css"/><![endif]-->
<!--[if IE 8]><link href="msie.css" rel="stylesheet" type="text/css"/><![endif]-->
<!--link rel="shortcut icon" href="images/favicon.ico"/-->
<script language="JavaScript" src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script language="JavaScript" src="js/bootstrap2.1/bootstrap.min.js" type="text/javascript"></script>
<script language="JavaScript" src="js/script.js" type="text/javascript"></script>
<%if(mob) {%>
<link href='stylesheet/glts/styles.m.css' rel='stylesheet' type='text/css'/>
<%}else{ %>
<link href="stylesheet/glts/styles.css" rel="stylesheet" type="text/css"/>
<%} %>

<script language="JavaScript" src="js/jquery-ui.custom.min.js" type="text/javascript"></script>
<script language="JavaScript" src="js/jquery.cookie.js" type="text/javascript"></script>
<script language="JavaScript" src="js/jquery.dynatree.min.js" type="text/javascript"></script>

<script type="text/javascript">
	jQuery(function(){
		jQuery("#tree").dynatree({
			// using default options
		});
	});
	
	function changeLocale(locale) {
		eraseCookie('org.jboss.seam.core.Locale');
		createCookie('org.jboss.seam.core.Locale',locale,1);
		location.reload();
	} 

	function createCookie(name,value,days) {
		if (days) {
			var date = new Date();
			date.setTime(date.getTime()+(days*24*60*60*1000));
			var expires = "; expires="+date.toGMTString();
		}
		else var expires = "";
		document.cookie = name+"="+value+expires+"; path=/";
	}

	function readCookie(name) {
		var nameEQ = name + "=";
		var ca = document.cookie.split(';');
		for(var i=0;i < ca.length;i++) {
			var c = ca[i];
			while (c.charAt(0)==' ') c = c.substring(1,c.length);
			if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
		}
		return null;
	}

	function eraseCookie(name) {
		createCookie(name,"",-1);
	}
</script>

<title></title>
</head>
<body>
	<%
	Cookie cookies[] = request.getCookies();
	String locale = "ru";
	
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("org.jboss.seam.core.Locale")) {
				locale = cookies[i].getValue();
				break;
			}
		}
	}
	%>

<%if(mob) {%>
	<div id='header'>
		<div><center>
			<img src='img/logo.png' style='height:15px; margin-top:15px;'/>
		</center></div>
	</div>
	
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
<%}else{ %>
	<div class="container" style="min-width:882px;">
		<div class="line-top">
			<ul class="lang pull-right">
				<%if(locale.equals("en")) {%>
				<li><a href="javascript:changeLocale('kk')">ҚАЗ</a> <span>|</span></li>
				<li><a href="javascript:changeLocale('ru')">РУС</a> <span>|</span></li>
				<li>ENGLISH</li>
				<%}
				else if(locale.equals("ru")) {
				%>
				<li><a href="javascript:changeLocale('kk')">ҚАЗ</a> <span>|</span></li>
				<li>РУС <span>|</span></li>
				<li><a href="javascript:changeLocale('en')">ENGLISH</a></li>
				<%}
				else {%>
				<li>ҚАЗ<span>|</span></li>
				<li><a href="javascript:changeLocale('ru')">РУС</a> <span>|</span></li>
				<li><a href="javascript:changeLocale('en')">ENGLISH</a></li>
				<%} %>
			</ul>
		</div>

		<div class="profile-bar">
			<div class="logo">
				<a href="/"><img src="img/glts/logo.png" width="204" height="65"/></a>
			</div>
			<div class="name">
			<%if(locale.equals("en")) {%>
				E-learning
			<%}
			else if(locale.equals("ru")) {
			%>
				Система электронного обучения
			<%}
			else {%>
				Электронды оқу жүйесі
			<%} %>
			</div>
			<div class="buttons">
			</div>
		</div>

		<div class="menu-bar" style="height:4px;">
		</div>

		<div class="bg_main">


			<div style="width:400px; margin: 5% auto 0 auto;">
				<form action='j_security_check' method='post'>
					<div class="alert alert-error" style="width: 390px; display: none;">
						<%if(locale.equals("en")) {%>
							<b>Attention!</b> <br/>Invalid username or password.
						<%}
						else if(locale.equals("ru")) {
						%>
							<b>Внимание!</b> <br />Введенный вами логин или пароль неверны.
						<%}
						else {%>
							<b>Назар аударыңыз!</b> <br/>Введенный вами логин или пароль неверны.
						<%} %>
					</div>
					<%if(locale.equals("en")) {%>
						<div class="tb">Login</div>					
					<%}
					else if(locale.equals("ru")) {
					%>
						<div class="tb">Вход в систему</div>
					<%}
					else {%>
						<div class="tb">Жүйеге кіру</div>
					<%} %>
					<div class="well" style="margin-top: 10px; width: 100%">

						<div class="control-group">
							<%if(locale.equals("en")) {%>
								<label class="control-label" for="input01">Username</label>
							<%}
							else if(locale.equals("ru")) {
							%>
								<label class="control-label" for="input01">Логин</label>
							<%}
							else {%>
								<label class="control-label" for="input01">Логин</label>						
							<%} %>
							<div class="controls">
								<input type="text" class="input-xlarge" id="input01" style="width: 390px; height: 35px;" name="j_username" />
							</div>
						</div>

						<div class="control-group">
							<%if(locale.equals("en")) {%>
								<label class="control-label" for="input02">Password</label>
							<%}
							else if(locale.equals("ru")) {
							%>
								<label class="control-label" for="input02">Пароль</label>
							<%}
							else {%>
								<label class="control-label" for="input02">Құпия сөз</label>						
							<%} %>
							<div class="controls">
								<input type="password" class="input-xlarge" id="input02" style="width: 390px; height: 35px;" name="j_password" autocomplete="off"/>
							</div>
						</div>

						<div class="control-group">
							<div class="controls">
								<%if(locale.equals("en")) {%>
									<button type="submit" class="btn btn-primary">Sign in</button>
								<%}
								else if(locale.equals("ru")) {
								%>
									<button type="submit" class="btn btn-primary">Вход</button>
								<%}
								else {%>
									<button type="submit" class="btn btn-primary">Кіру</button>
								<%} %>
								<label style="display: inline-block; margin-left: 10px;">
									<!-- <input type="checkbox" id="optionsCheckbox2" value="option1" disabled="disabled" /> --> 
									<%if(locale.equals("en")) {%>
										<!-- <span style="position: relative; top: 3px;">Save my profile</span>  -->
									<%}
									else if(locale.equals("ru")) {
									%>
										<!-- <span style="position: relative; top: 3px;">Сохранить мою учетную запись</span>	-->								
									<%}
									else {%>
										<!-- <span style="position: relative; top: 3px;">Сохранить мою учетную запись</span> -->
									<%} %>
								</label>
							</div>
						</div>
					</div>
				</form>
			</div>


		</div>

		<div class="footer">
			<div class="footer_line"></div>
			<ul class="pull-right">
				<li><a href="http://www.nitec.kz">АО "НИТ"</a>, <a href="http://kerey-pharm.kz">ТОО "Kerey-pharm"</a>, 2014 г.</li>
			</ul>
		</div>

	</div>
<%} %>
   
    
</body>
</html>
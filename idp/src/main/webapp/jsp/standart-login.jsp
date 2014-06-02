<%@ page language="java" %>
<%@ page contentType="text/html; charset=utf-8" %>

 <%
	
	Cookie cookies[] = request.getCookies();
	String locale = "kk";
	
	if (cookies != null) {
		for (int i = 0; i < cookies.length; i++) {
			if (cookies[i].getName().equals("org.jboss.seam.core.Locale")) {
				locale = cookies[i].getValue();
				break;
			}
		}
	}
	%>

<div class="container" style="min-width:882px;">
		<div class="line-top">
			<ul class="options pull-right">
				<%if(locale.equals("en")) {%>
					<li><i class="icon-info-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Support</a></li>
					<li><i class="icon-question-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Help</a></a></li>
				<%}
				else if(locale.equals("ru")) {
				%>
					<li><i class="icon-info-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Служба поддержки</a></li>
					<li><i class="icon-question-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Помощь</a></a></li>
				<%}
				else {%>
					<li><i class="icon-info-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Қолдау</a></li>
					<li><i class="icon-question-sign icon-blue" style="position:relative;top:-1px;"></i> <a href="#">Көмек</a></a></li>
				<%} %>
			</ul>
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
			<ul style="margin-left:20px;">
				<%if(locale.equals("en")) {%>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">Support</a></li>
				<%}
				else if(locale.equals("ru")) {
				%>
					<li><a href="#">Вопросы и ответы</a></li>
					<li><a href="#">Поддержка</a></li>
				<%}
				else {%>
					<li><a href="#">Сұрақ-жауартар</a></li>
					<li><a href="#">Қолдау</a></li>
				<%} %>
			</ul>
			<ul class="pull-right">
				<li><a href="http://www.nitec.kz">АО "НИТ"</a>, <a href="http://www.bee.kz">ТОО "Bee Software"</a>, 2012 г.</li>
			</ul>
		</div>

	</div>
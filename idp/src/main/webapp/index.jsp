<%@ page language="java"%>
<%@ page contentType="text/html; charset=utf-8"%>
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,,chrome=1" />
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="" />
		<meta name="description" content="" />
		<meta name='viewport' content='initial-scale=1, maximum-scale=1, user-scalable=no' />
		<meta name='apple-mobile-web-app-capable' content='yes' />
		<meta name='apple-mobile-web-app-status-bar-style' content='black' />
	</head>
	<body>
		<style>
		#circularG{
		position:relative;
		width:256px;
		height:256px}
		
		.circularG{
		position:absolute;
		background-color:#20ADE0;
		width:58px;
		height:58px;
		-moz-border-radius:39px;
		-moz-animation-name:bounce_circularG;
		-moz-animation-duration:1.28s;
		-moz-animation-iteration-count:infinite;
		-moz-animation-direction:linear;
		-webkit-border-radius:39px;
		-webkit-animation-name:bounce_circularG;
		-webkit-animation-duration:1.28s;
		-webkit-animation-iteration-count:infinite;
		-webkit-animation-direction:linear;
		-ms-border-radius:39px;
		-ms-animation-name:bounce_circularG;
		-ms-animation-duration:1.28s;
		-ms-animation-iteration-count:infinite;
		-ms-animation-direction:linear;
		-o-border-radius:39px;
		-o-animation-name:bounce_circularG;
		-o-animation-duration:1.28s;
		-o-animation-iteration-count:infinite;
		-o-animation-direction:linear;
		border-radius:39px;
		animation-name:bounce_circularG;
		animation-duration:1.28s;
		animation-iteration-count:infinite;
		animation-direction:linear;
		}
		
		#circularG_1{
		left:0;
		top:101px;
		-moz-animation-delay:0.48s;
		-webkit-animation-delay:0.48s;
		-ms-animation-delay:0.48s;
		-o-animation-delay:0.48s;
		animation-delay:0.48s;
		}
		
		#circularG_2{
		left:27px;
		top:27px;
		-moz-animation-delay:0.64s;
		-webkit-animation-delay:0.64s;
		-ms-animation-delay:0.64s;
		-o-animation-delay:0.64s;
		animation-delay:0.64s;
		}
		
		#circularG_3{
		top:0;
		left:101px;
		-moz-animation-delay:0.8s;
		-webkit-animation-delay:0.8s;
		-ms-animation-delay:0.8s;
		-o-animation-delay:0.8s;
		animation-delay:0.8s;
		}
		
		#circularG_4{
		right:27px;
		top:27px;
		-moz-animation-delay:0.96s;
		-webkit-animation-delay:0.96s;
		-ms-animation-delay:0.96s;
		-o-animation-delay:0.96s;
		animation-delay:0.96s;
		}
		
		#circularG_5{
		right:0;
		top:101px;
		-moz-animation-delay:1.12s;
		-webkit-animation-delay:1.12s;
		-ms-animation-delay:1.12s;
		-o-animation-delay:1.12s;
		animation-delay:1.12s;
		}
		
		#circularG_6{
		right:27px;
		bottom:27px;
		-moz-animation-delay:1.28s;
		-webkit-animation-delay:1.28s;
		-ms-animation-delay:1.28s;
		-o-animation-delay:1.28s;
		animation-delay:1.28s;
		}
		
		#circularG_7{
		left:101px;
		bottom:0;
		-moz-animation-delay:1.44s;
		-webkit-animation-delay:1.44s;
		-ms-animation-delay:1.44s;
		-o-animation-delay:1.44s;
		animation-delay:1.44s;
		}
		
		#circularG_8{
		left:27px;
		bottom:27px;
		-moz-animation-delay:1.6s;
		-webkit-animation-delay:1.6s;
		-ms-animation-delay:1.6s;
		-o-animation-delay:1.6s;
		animation-delay:1.6s;
		}
		
		@-moz-keyframes bounce_circularG{
		0%{
		-moz-transform:scale(1)}
		
		100%{
		-moz-transform:scale(.3)}
		
		}
		
		@-webkit-keyframes bounce_circularG{
		0%{
		-webkit-transform:scale(1)}
		
		100%{
		-webkit-transform:scale(.3)}
		
		}
		
		@-ms-keyframes bounce_circularG{
		0%{
		-ms-transform:scale(1)}
		
		100%{
		-ms-transform:scale(.3)}
		
		}
		
		@-o-keyframes bounce_circularG{
		0%{
		-o-transform:scale(1)}
		
		100%{
		-o-transform:scale(.3)}
		
		}
		
		@keyframes bounce_circularG{
		0%{
		transform:scale(1)}
		
		100%{
		transform:scale(.3)}
		
		}
	</style>
		<table style="width: 100%; height: 85%;">
		<tr>
			<td style="vertical-align: middle;">
				<div id="circularG" style="margin: auto;">
					<div id="circularG_1" class="circularG"></div>
					<div id="circularG_2" class="circularG"></div>
					<div id="circularG_3" class="circularG"></div>
					<div id="circularG_4" class="circularG"></div>
					<div id="circularG_5" class="circularG"></div>
					<div id="circularG_6" class="circularG"></div>
					<div id="circularG_7" class="circularG"></div>
					<div id="circularG_8" class="circularG"></div>
					<div
						style="color: #1182AB; margin: auto; text-align: center; bottom: -70px; left: -150%; position: absolute; font-size: 30; font-family: arial; width: 1000px;">Күте тұрыңыз / Пожалуйста, подождите / Please wait</div>
				</div>
			</td>
		</tr>
	</table>
	</body>
</html>

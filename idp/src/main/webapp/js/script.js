$(document).ready(function() {
	var search = $("#searchInput").val();
	$("#searchInput").focus(function(){
        $(this).css("color", "black");
        if ($(this).val() == search) {
            $(this).val("");
        }
    }).blur(function(){
        if ($(this).val() == "") {
            $(this).css("color", "#969696");
            $(this).val(search);
        }
    });
	
	$(".jobs li h3 span").click(function() {
		li = $(this).parent().parent("li");
		$(li).find(".fl100").toggle("slow");
	});
	
	$(".vkl div").click(function() {
		$(".vkl div").attr("class", "");
		$(this).attr("class", "activ");
		$(".rev").hide();
		$("#"+$(this).attr("id")+"_text").show();
	});
	
	$(".right_phone img").click(function(){
		display_feedback(1);
	});
	
	$("#win_feedback .ico_close").click(function() {
		$("#win_feedback").hide();
	});
	
	$(".name_str").click(function(){
		next_photo();
	});
});

$(window).resize(function() {

});

function next_photo() {
	count = $(".photo_big img").attr("class");
	imgs = $(".array_photo").find("img");
	k = null;
	for (i=1;i<=imgs.length;i++) {
		if (i == imgs.length) {
			k = 0;
		} else if (i == count) {
			k = i;
		}
		if (k != null) {
			src = $(imgs[k]).attr("src");
			title = $(imgs[k]).attr("title");
			alt = $(imgs[k]).attr("alt");
			nclass = $(imgs[k]).attr("class");
			break;
		}
	}
	
	$(".photo_big").animate({opacity: 0}, 300);
	setTimeout("change_par_img('"+src+"', '"+nclass+"', '"+title+"', '"+alt+"')", 300);
	setTimeout("$('.photo_big').animate({opacity: 1})", 300);
	
}

function change_par_img(src, nclass, title, alt) {
	$(".photo_big img").attr("src", src);
	$(".photo_big img").attr("class", nclass);
	$(".photo_big img").attr("title", title);
	$(".photo_big img").attr("alt", alt);
	$(".img_title .name").html('<p>'+title+'</p>'+alt);
	
	
}

function display_feedback(type) {
	$("#win_feedback").hide();
	if (type!=1) {
		$("#win_feedback").css({'position':'relative', 'top':'0', 'left':0, 'margin':'-400px 30% 0 -300px'});
	} else {
		$("#win_feedback").css({'position':'absolute', 'top':'150px', 'left':'40%', 'margin':0});
	}
	$("#win_feedback").show();
}
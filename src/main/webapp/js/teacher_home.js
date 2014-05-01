$("#exam li").click(function() {
	$("li").removeClass("active");
	$("#exam").addClass("active");
});
$("#student li").click(function() {
	$("li").removeClass("active");
	$("#student").addClass("active");
});
window.setInterval(function() {
	AutoIframe();
}, 25);
function AutoIframe() {
	if (document.readyState != 'complete') {
		setTimeout(function() {
			AutoIframe();
		}, 25);
		return;
	} else {
		var ifobj = document.getElementById("win");
		if(ifobj.height<ifobj.contentWindow.document.body.scrollHeight)
		ifobj.height = ifobj.contentWindow.document.body.scrollHeight;
	}
}

function change() {
	$("#code").attr("src", base_path+"login/imageCode?time=" + new Date().getTime());
};
$(function(){
	if (window != top) 
		top.location.href = location.href; 
	$("input[name='j_code']").blur(function() {
		$.ajax({
			url : base_path+"login/codeCheck",
			data : {
				"j_code" : $(this).val()
			},
			success:function(data){
				if(data=="success"){
					$("#j_code").removeClass("error");
					$("#j_code").addClass("success");
				}else{
					$("#j_code").removeClass("success");
					$("#j_code").addClass("error");
				}
			}
		});
	});
});
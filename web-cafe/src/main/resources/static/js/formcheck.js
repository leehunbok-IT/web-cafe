$(function() {
	$("#writeForm").on("submit",function(){
		if($("#writer").val().length <= 0){
			alert("작성자가 입력되지 않았습니다.\n작성자를 입력해주세요");
			$("#writer").focus();
			return false;
		}
		if($("#title").val().length <= 0){
			alert("제목이 입력되지 않았습니다.\n제목을 입력해주세요");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다.\n 비밀번호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0){
			alert("내용이 입력되지 않았습니다.\n내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
	});
	
	$("#detailUpdate").on("click", function(){
		let pass = $("#pass").val();
		if(pass.length <= 0){
			alert("게시글을 수정하려면 비밀번호를 입력해주세요.");
			return false;
		}
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "updateForm");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	});
	
	$("#updateForm").on("submit", function(){
		if($("#writer").val().length <= 0){
			alert("작성자가 입력되지 않았습니다.\n 작성자를 입력해주세요.");
			$("#writer").focus();
			return false;
		}
		if($("#title").val().length <= 0){
			alert("제목이 입력되지 않았습니다. \n 제목을 입력해주세요.");
			$("#title").focus();
			return false;
		}
		if($("#pass").val().length <= 0){
			alert("비밀번호가 입력되지 않았습니다.\n 비밀번호를 입력해주세요.");
			$("#pass").focus();
			return false;
		}
		if($("#content").val().length <= 0){
			alert("내용이 입력되지 않았습니다.\n 내용을 입력해주세요.");
			$("#content").focus();
			return false;
		}
	});
	
	$("#detailDelete").on("click", function(){
		
		let pass = $("#pass").val();
		if(pass.length <= 0){
			alert("게시글을 삭제하려면 비밀번호를 입력해주세요.");
			return false;
		}
		$("#rPass").val(pass);
		$("#checkForm").attr("action", "delete");
		$("#checkForm").attr("method", "post");
		$("#checkForm").submit();
	});
	
});








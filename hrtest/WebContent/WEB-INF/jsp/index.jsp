<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/static/layui/css/layui.css"/>
</head>
<body>
<button type="button" class="layui-btn" id="uploadExcel"><i class="layui-icon"></i>上传文件</button> 
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/layui/layui.js"></script>
<script type="text/javascript">
	console.log('${pageContext.request.contextPath}');
	layui.use(['upload'],function(){
		var upload = layui.upload;
		
		//指定允许上传的文件类型
		upload.render({
		  elem: '#uploadExcel',
		  url: '${pageContext.request.contextPath}/uploadExcel',
		  accept: 'file', 	//普通文件
		  exts: 'xls|xlsx', //允许上传的文件后缀
		  multiple: true,
		  done: function(res){
		      console.log(res);
		   }
		});
	})
</script>
</html>
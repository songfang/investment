<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vrc-scheduler</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>  
<script src="${basePath}/script/easyui/jquery.min.js" type="text/javascript"></script>
<script src="${basePath}/script/easyui/jquery.easyui.min.js" type="text/javascript"></script>
<link href="${basePath}/script/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
<link href="${basePath}/script/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
<script src="${basePath}/script/easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<link href="${basePath}/script/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${basePath}/script/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="${basePath}/script/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		$('#dg').datagrid({  
		url:'jobList.do',
		pagination:true,
        pageSize:5,  
        pageList:[4,8,12], 
        rownumbers:true,
        pageNumber:1,
		columns:[[
			{field:'jobId',title:'序号'},
			{field:'jobName',title:'调度名称'},
			{field:'jobGroup',title:'组'},
			{field:'jobStatus',title:'调度状态'},
			{field:'cronExpression',title:'调度参数'},
			{field:'description',title:'描述'},
			{field:'beanClass',title:'调度类名'},
			{field:'isConcurrent',title:'是否并发'},
			{field:'springId',title:'spring_id'},
			{field:'methodName',title:'方法名'}
				]]
		});		
		
	 $('#dd').dialog('close')
	})

	function qq(value, name) {
			alert(value + ":" + name)
	}
	
	function showAdd(){
		 $('#dd').dialog('open')
	}
</script>
</head> 
<body class="easyui-layout">
	<div data-options="region:'west',title:'调度管理',split:true"
		style="width: 230px;">
		<div style="width: 200px; height: auto; ">
			<ul id="tt" class="easyui-tree" url="treedata.do"></ul>
		</div>
	</div>
	<div data-options="region:'center',title:'调度任务列表'" style="padding:0px;background:#eee;">
		<!-- 数据表格 -->
		<div class="container">
			<input id="ss" class="easyui-searchbox" style="width: 300px"
				data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input>
			<div id="mm" style="width: 120px">
				<div data-options="name:'all'">调度搜索</div>
			</div>
			<button type="button" class="btn btn-success" onclick="showAdd()">新增调度</button>
		</div>
		<table id="dg"></table>

		<div id="pp" class="easyui-pagination"
			style="background: #efefef; border: 1px solid #ccc;"
			data-options="total:2000,pageSize:10"></div>

		<div id="dd" class="easyui-dialog" title="增加调度"
			style="width: 60%; height: 50%;"
			data-options="iconCls:'icon-save',resizable:true,modal:true">
		</div>

	</div>
</body>
</html>
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
<script src="${basePath}/script/bootstrap/js/bootstrap.min.js"></script>
</head>   
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
    <div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;">
		<form id="addForm" method="post">
			<table class="easyui-datagrid" data-options="url:'schedulerList.do',fitColumns:true,singleSelect:true">
				<thead>
					<tr>
						<th data-options="field:'job_id'">job_id&nbsp;&nbsp;&nbsp;</td>
						<th data-options="field:'job_name'">job_name</th>
						<th data-options="field:'job_group'">job_group</th>
						<th data-options="field:'job_status'">job_status</th>
						<th data-options="field:'cron_expression'">cron_expression</th>
						<th data-options="field:'description'">description</th>
						<th data-options="field:'bean_class'">bean_class</th>
						<th data-options="field:'is_concurrent'">is_concurrent</th>
						<th data-options="field:'spring_id'">spring_id</th>
						<th data-options="field:'method_name'">method_name</th>
					</tr>
				</thead>
					<tbody>
					<c:forEach var="job" items="${schedulerList}">
						<tr>
							<td></td>
							<td>${job.jobName}</td>
							<td>${job.jobGroup}</td>
							<td>${job.jobStatus}</td>
							<td>${job.cronExpression}</td>
							<td>${job.description}</td>
							<td>${job.beanClass}</td>
							<td>${job.isConcurrent}</td>
							<td>${job.springId}</td>
							<td>${job.methodName}</td>
							<td>启动|停止</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>
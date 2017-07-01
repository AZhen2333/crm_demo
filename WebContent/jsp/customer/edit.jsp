<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加客户</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
		$(function(){
			$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action", 
					{"dict_type_code":"002"},
					  function(data){
						$(data).each(function(){
							var action=$("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
							$("#cust_source").append(action);
						});						
					  });
			//客户所属行业
			$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action", 
					{"dict_type_code":"006"},
					  function(data){
						$(data).each(function(){
							var action=$("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
							$("#cust_industry").append(action);
						});
					 });
			//客户级别
			$.post("${pageContext.request.contextPath}/baseDict_findByTypeCode.action", 
					{"dict_type_code":"001"},
					  function(data){
						$(data).each(function(){
							var action=$("<option value='"+this.dict_id+"'>"+this.dict_item_name+"</option>");
							$("#cust_level").append(action);
						});
					 });
		})	

</script>
</HEAD>
<BODY>
<s:actionerror/>
<s:fielderror/>
	<FORM id=form1 name=form1
		action="${pageContext.request.contextPath }/customer_edit.action"
		enctype="multipart/from-data" method=post>
		<!-- 隐藏域 -->
		<input type="hidden" name="cust_id" value="${cust_id}"/>

		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background=${pageContext.request.contextPath }/images/new_020.jpg
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：客户管理 &gt; 修改客户</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=5  border=0>
							<TR>
								<td>客户名称：</td>
								<td>
								<INPUT class=textbox id=sChannel2
											style="WIDTH: 180px" maxLength=50 name="custName" value="${cust_name }">
								</td>
								<td>客户级别 ：</td>
								<td>
									<select id=cust_level name="baseDictLevel.dict_id">
										<option value="">---请选择---</option>
									</select>
								</td>
							</TR>
							
							<TR>
								<td>信息来源：</td>
								<td>
									<select id=cust_source name="baseDictSource.dict_id">
										<option value="">---请选择---</option>
									</select>
								</td>
								<td>联系人：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custLinkman" value="${customer.custLinkman }">
								</td>
							</TR>
							<TR>
								
								
								<td>固定电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custPhone" value="${cust_phone }">
								</td>
								<td>移动电话 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custMobile" value="${cust_mobile}">
								</td>
							</TR>
							
							<TR>
								<td>联系地址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custAddress" value="${customerDetail.custAddress }">
								</td>
								<td>邮政编码 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custZip" value="${customerDetail.custZip }">
								</td>
							</TR>
							<TR>
								<td>客户传真 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custFax" value="${customerDetail.custFax }">
								</td>
								<td>客户网址 ：</td>
								<td>
								<INPUT class=textbox id=sChannel2
														style="WIDTH: 180px" maxLength=50 name="custWebsite" value="${customerDetail.custWebsite }">
								</td>
							</TR>
								<TR>
								<td>资质上传 ：</td>
								<td colspan="3">
									<!-- <input type="file" name="upload"/> -->
									<%-- <s:file name="upload"/> --%>
									原资质：
									<input type="text" name="upload" value="${cust_filename}"/>
									<%-- <s:property value="cust_filename"/>
									<s:hidden name="cust_path"/> --%>
									<input type="hidden" name="cust_path" value="${cust_path}"/>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
								<INPUT class=button id=sButton2 type=submit
														value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
</BODY>
</HTML>

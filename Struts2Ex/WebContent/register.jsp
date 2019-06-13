<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
</head>
<body>
<s:form action="saveOrUpdateUser">
	<s:push value="user">
		<s:hidden name="id" />
		<s:textfield name="name" label="User Name" />
		<s:textfield name="age" label="Age"  />
		<s:submit value="Submit"/>
	</s:push>
</s:form>

<s:if test="userList.size() > 0">
	<table class="userTable" cellpadding="5px">
		<tr class="even">
			<th>Name</th>
			<th>Age</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>
		<s:iterator value="userList" status="userStatus">
			<tr>
				<td><s:property value="name" /></td>
				<td><s:property value="age" /></td>
				<td><s:url id="editURL" action="editUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Edit</s:a></td>
				<td><s:url id="deleteURL" action="deleteUser">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Delete</s:a></td>
			</tr>
		</s:iterator>
	</table>
</s:if>
</body>
</html>
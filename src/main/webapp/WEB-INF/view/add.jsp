<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Being Java Guys | Registration Form</title>
</head>
<body>
 <center>

  <div style="color: teal; font-size: 30px">Being Java Guys |
   Registration Form</div>



 <!--  <c:url var="userRegistration" value="saveUser.html" />-->
  <form:form id="registerForm" modelAttribute="p" method="post"
   action="register">
   <table width="400px" height="150px">
    <tr>
     <td><form:label path="id">id</form:label>
     </td>
     <td><form:input path="id" />
     </td>
    </tr>
    <tr>
     <td><form:label path="productname">Productname</form:label>
     </td>
     <td><form:input path="productname" />
     </td>
    </tr>
    <tr>
     <td><form:label path="description">Description</form:label>
     </td>
     <td><form:input path="description" />
     </td>
    </tr>
    <tr>
     <td><form:label path="price">Price</form:label>
     </td>
     <td><form:input path="price" />
     </td>
    </tr>
    <tr>
     <td></td>
     <td><input type="submit" value="Register" /></td>
    </tr>
    <tr>
    <td>
    <div class="control-group">
							  <label class="control-label">Upload Picture</label>
								<div class="controls docs-input-sizes">
								 <form:input id="itemimage" path="itemImage" type="file" class="form:input-large" />
								</div>
						</div>
    </td>
    </tr>
   </table>
  </form:form>


  <a href="productlist">Click Here to see User List</a>
 </center>
</body>
</html>
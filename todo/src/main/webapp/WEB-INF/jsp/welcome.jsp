<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <body>
    <div style="float:left"/><a href="/logout">logout</a>
    <center>
    <h1>Task View Example</h1>
    <c:url var="add_task" value="/add"/>
    <c:url var="remove_task" value="/remove"/>
       <form:form action="${add_task}" method="post" modelAttribute="taskVO">
           <form:checkbox path="status"/>
           <form:label path="description">task description: </form:label> <form:input type="text" path="description"/>
           <form:input path="userid" value="1" type="hidden"/>
           <input type="submit" value="add"/>
        </form:form>
               <P>Added Task list</p>

           <c:forEach items="${todos}" var="todo">
           <p>

           ${todo.description} ${todo.updatedDate}
           <c:if test = "${todo.status == true}">
           <input type="checkbox" checked />
            </c:if>
             <c:if test = "${todo.status == false}">
                 <input type="checkbox"  />
              </c:if>
               <a href="/update/${todo.id}/${todo.userid}">update</a>
                         <a href="/remove/${todo.id}">Remove</a>
            </p>
           </c:forEach>



    </center>
    </body>
</html>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="reserve" method="post">
    <input type="hidden"  name="command" value="reserve">
    <fieldset>

        <!-- Select Multiple -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="selectmultipleTours">Tours</label>
            <div class="col-md-4">
                <select id="selectmultipleTours" name="selectmultipleTours" class="form-control" multiple="multiple">
                    <option value="1">Option one</option>
                    <option value="2">Option two</option>
                </select>
                <c:forEach  var="Tour" items="${tourList}">
                    <option value="${Tour.id}">${Tour}</option>
                </c:forEach>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="singlebuttonReserv"></label>
            <div class="col-md-4">
                <button id="singlebuttonReserv" name="singlebuttonReserv" class="btn btn-success">Reserve</button>
            </div>
        </div>

    </fieldset>
</form>

<%@ include file="bottom.jsp" %>
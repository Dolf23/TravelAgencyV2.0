<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="top.jsp" %>

<form class="form-horizontal" action="/controller" method="post">
  <input type="hidden"  name="command" value="cancel_reservation">
  <fieldset>

    <!-- Select Multiple -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="reservingTour">Tours</label>
      <div class="col-md-4">
        <select id="reservingTour" name="reservingTour" class="form-control" multiple="multiple" style="width: auto;">
          <c:forEach  var="Tour" items="${toursMap}">
            <option value="${Tour.key}">${Tour.value}</option>
          </c:forEach>
        </select>
      </div>
    </div>

    <!-- Button -->
    <div class="form-group">
      <label class="col-md-4 control-label" for="singlebuttonCancelReserv"></label>
      <div class="col-md-4">
        <button id="singlebuttonCancelReserv" name="singlebuttonCancelReserv" class="btn btn-success">Cancel reserving</button>
      </div>
    </div>

  </fieldset>
</form>

<%@ include file="bottom.jsp" %>
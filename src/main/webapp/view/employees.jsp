<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body ng-controller="employeeCtrl">
<h3>List of Employees:</h3>


<ul>
    <li ng-repeat="employee in employeeList">
        <input id="{{employee.employeeId}}" type="checkbox" value="employee.selected"
               ng-checked="employee.selected" ng-click="toggleSelection(employee.employeeId)"/> {{employee.firstName}}
        {{employee.lastName}}
    </li>
</ul>


<button type="button" class="btn btn-info" style="margin-left: 40%;" ng-click="update()">Update</button>

</body>
</html>

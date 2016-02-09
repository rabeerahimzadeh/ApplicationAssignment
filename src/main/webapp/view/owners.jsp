<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body ng-controller="ownerCtrl">
<h3>List of Owners:</h3>


<ul>
    <li ng-repeat="owner in ownerList">
        <input id="{{owner.ownerId}}" type="checkbox" value="{{owner.firstName}}"
               ng-checked="owner.selected" ng-click="toggleSelection(owner.ownerId)"/> {{owner.firstName}}
        {{owner.lastName}}
    </li>
</ul>


<button type="button" class="btn btn-info" style="margin-left: 40%;" ng-click="update()">Update</button>

</body>
</html>

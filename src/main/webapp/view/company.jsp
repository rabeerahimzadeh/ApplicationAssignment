<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>


</head>
<body ng-controller="companyCtrl">


<form name="companyForm" ng-submit="submit(companyForm)">
    <div style="margin-top:25%;" notifications="top right"></div>
    <span us-spinner="{radius:50, width:5, length: 13}" spinner-key="spinner-1"></span>


    <div class="ui padded segment">
        <div class="ui error message" ng-show="companyForm.email.$error.pattern"> Email is incorrect.</div>
        <div class="ui grid">


            <div class="four wide column">

                <div class="ui small label">
                    Name(*):
                </div>
                <div class="ui fluid input">
                    <input ng-model="name" name="name"
                           placeholder="Name" type="text" required>

                </div>

            </div>


            <div class="four wide column">
                <div class="ui small label">
                    Address(*):
                </div>
                <div class="ui fluid input">
                    <input ng-model="address" placeholder="Address" name="address" type="text" required>
                </div>
            </div>


            <div class="four wide column">
                <div class="ui small label">
                    City(*):
                </div>
                <div class="ui fluid input">
                    <input ng-model="city" placeholder="City" name="city" type="text" required>
                </div>
            </div>


            <div class="four wide column">
                <div class="ui small label">
                    Country(*):
                </div>
                <div class="ui fluid input">
                    <input ng-model="country" placeholder="Country" name="country" type="text" required>
                </div>
            </div>

            <div class="four wide column">
                <div class="ui small label">
                    Email:
                </div>
                <div class="ui fluid input">
                    <input ng-model="email" placeholder="Email" type="email" name="email" type="text">
                </div>
            </div>


            <div ng-hide="dateDisabled" class="four wide column">
                <div class="ui small label">
                    Phone Number (format: xxxx-xxx-xxxx):
                </div>
                <div class="ui fluid input">
                    <input ng-model="phoneNumber" placeholder="Phone Number" type="tel" pattern="^\d{4}-\d{3}-\d{4}$"
                           name="phoneNumber" type="text">
                </div>
            </div>


            <div style="margin-top: 50%;" class="four wide column">

            </div>

            <input type="submit" style="margin-right: 30%;margin-left: 30%;" value="Add"
                   class="ui fluid large teal submit button"/>

        </div>
    </div>


</form>




<div class="ui padded segment">
    <table class="ui teal table" at-table at-paginated at-list="filteredList" at-config="config">
        <thead></thead>

        <div class="form-inline">

        </div>
        <tbody>
        <tr>
            <td at-implicit at-sortable at-title="ID" at-attribute="companyId" width="200"
                at-initial-sorting="desc"></td>
            <td at-implicit at-sortable at-title="Name" at-attribute="name" width="200"></td>
            <td at-implicit at-sortable at-title="Email" at-attribute="email" width="200"></td>


            <td>
                <button type="button" class="ui blue button"
                        ng-click="details(item.companyId)">Details
                </button>
                <button type="button" class="ui green button" ng-click="addRemoveEmployee(item.companyId)">Add/Remove
                    Employee
                </button>
                <button type="button" class="ui olive button" ng-click="addRemoveOwner(item.companyId)">Add/Remove
                    Owner
                </button>
            </td>
        </tr>
        </tbody>
    </table>
    <at-pagination at-list="list" at-config="config"></at-pagination>
</div>

</body>
</html>

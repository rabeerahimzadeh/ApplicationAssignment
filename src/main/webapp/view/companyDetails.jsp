<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>


</head>
<body>


<div ng-controller="companyDetailsCtrl">
    <form name="companyDetailForm" ng-submit="submit(companyDetailForm)">
    <%--    <span us-spinner="{radius:50, width:5, length: 13}" spinner-key="spinner-1"></span>--%>


        <div class="ui padded segment">
            <div class="ui grid">


                <div class="four wide column">

                    <div class="ui small label">
                        Name(*):
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.name" name="name"
                               placeholder="Name" type="text" required>

                    </div>

                </div>


                <div class="four wide column">
                    <div class="ui small label">
                        Address(*):
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.address" placeholder="Address" name="address" type="text"
                               required>
                    </div>
                </div>


                <div class="four wide column">
                    <div class="ui small label">
                        City:
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.city" placeholder="City" name="city" type="text" required>
                    </div>
                </div>


                <div class="four wide column">
                    <div class="ui small label">
                        Country(*):
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.country" placeholder="Country" name="country" type="text"
                               required>
                    </div>
                </div>

                <div class="four wide column">
                    <div class="ui small label">
                        Email:
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.email" placeholder="Email" type="email" name="email">
                    </div>
                </div>


                <div ng-hide="dateDisabled" class="four wide column">
                    <div class="ui small label">
                        Phone Number (format: xxxx-xxx-xxxx):
                    </div>
                    <div class="ui fluid input">
                        <input ng-model="companyDetails.phoneNumber" type="tel" pattern="^\d{4}-\d{3}-\d{4}$"
                               placeholder="Phone Number" name="phoneNumber">
                    </div>
                </div>


                <div class="four wide column">
                </div>


                <input type="submit" style="margin-right: 30%;margin-left: 30%;" value="Update"
                       class="ui fluid large teal submit button"/>

            </div>
        </div>


    </form>


    <div ng-show="status === 'I'">
        <div class="ui padded segment">
            <div class="ui grid">

                <div class="four wide column">
                </div>


                <div class="four wide column">
                </div>

            </div>
        </div>
    </div>

</div>


</body>
</html>

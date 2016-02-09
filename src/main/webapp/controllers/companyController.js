var companyCtrl = angular.module("companyController", ['angular-table', 'ngDialog', 'angularSpinner', 'notifications']);

companyCtrl.controller('companyCtrl', ['$scope', '$http', 'companyService', 'ngDialog', 'usSpinnerService', '$notification',
    function ($scope, $http, companyService, ngDialog, usSpinnerService, $notification) {


        companyService.query({}, function (data) {
            $scope.list = data;

            $scope.filteredList = $scope.list;
            $scope.config = {
                itemsPerPage: 6,
                maxPages: 26,
                fillLastPage: true
            }
            usSpinnerService.stop('spinner-2');
            $scope.updateFilteredList = function () {
                $scope.filteredList = $filter("filter")($scope.list, $scope.query);
            };
        });


        $scope.submit = function (form) {
            if (form.$valid == true) {
                usSpinnerService.spin('spinner-1');
                companyService.create({
                        name: $scope.name,
                        address: $scope.address,
                        city: $scope.city,
                        country: $scope.country,
                        email: $scope.email,
                        phoneNumber: $scope.phoneNumber
                    },
                    function (data) {
                        usSpinnerService.stop('spinner-1');
                        companyService.query({}, function (data) {
                            $scope.list = data;

                            $scope.filteredList = $scope.list;
                            $scope.config = {
                                itemsPerPage: 6,
                                maxPages: 26,
                                fillLastPage: true
                            }
                            usSpinnerService.stop('spinner-2');
                            $scope.updateFilteredList = function () {
                                $scope.filteredList = $filter("filter")($scope.list, $scope.query);
                            };
                        });
                        $notification.success('Added Successfully', '');
                        name: $scope.name = "",
                            $scope.address = "",
                            $scope.city = "",
                            $scope.country = "",
                            $scope.email = "",
                            $scope.phoneNumber = ""

                    }, function (error) {
                        usSpinnerService.stop('spinner-1');
                        $notification.error('Error', 'Internal Error');
                    }
                );
            } else {
                $notification.error('Please correct the fields that mentioned in the above page');
            }
        }


        $scope.details = function (companyId) {
            $scope.companyId = companyId;
            ngDialog.open({template: 'view/companyDetails.jsp', className: 'ngdialog-theme-plain', scope: $scope});

        };

        $scope.addRemoveEmployee = function (companyId) {
            $scope.companyId = companyId;
            ngDialog.open({
                template: 'view/employees.jsp',
                controller: 'employeeCtrl',
                className: 'ngdialog-theme-default',
                scope: $scope
            });
        };


        $scope.addRemoveOwner = function (companyId) {
            $scope.companyId = companyId;
            ngDialog.open({
                template: 'view/owners.jsp',
                controller: 'ownerCtrl',
                className: 'ngdialog-theme-default',
                scope: $scope
            });
        };


    }]);


var companyDetailCtrl = angular.module("companyDetailsController", ['angular-table', 'ngDialog', 'notifications', 'angularSpinner']);
companyDetailCtrl.controller('companyDetailsCtrl', ['$scope', '$rootScope', '$http', 'companyService', 'ngDialog', '$notification', 'usSpinnerService',
    function ($scope, $rootScope, $http, companyService, ngDialog, $notification, usSpinnerService) {

        usSpinnerService.spin('spinner-posting-details');
        companyService.get({id: $scope.companyId}, function (data) {
            $scope.companyDetails = data;
            usSpinnerService.stop('spinner-posting-details');
        }, function (error) {
            usSpinnerService.stop('spinner-posting-details');
        });


        $scope.submit = function (form) {
            if (form.$valid == true) {
                usSpinnerService.spin('spinner-1');
                companyService.update({
                        companyId: $scope.companyId,
                        name: $scope.companyDetails.name,
                        address: $scope.companyDetails.address,
                        city: $scope.companyDetails.city,
                        country: $scope.companyDetails.country,
                        email: $scope.companyDetails.email,
                        phoneNumber: $scope.companyDetails.phoneNumber
                    },
                    function (data) {
                        usSpinnerService.stop('spinner-1');
                        $notification.success('Edited Successfully', '');

                    }, function (error) {
                        usSpinnerService.stop('spinner-1');
                        $notification.error('Error', 'Internal Error');
                    }
                );
            } else {
                $notification.error('Please correct the fields that mentioned in the above page');
            }
        }
    }]);
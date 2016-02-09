var employeeCtrl = angular.module("employeeController", ['angular-table', 'ngDialog', 'angularSpinner', 'notifications']);

employeeCtrl.controller('employeeCtrl', ['$scope', '$http', 'employeeService', 'ngDialog', 'usSpinnerService', '$notification',
    function ($scope, $http, employeeService, ngDialog, usSpinnerService, $notification) {


        employeeService.query({companyId: $scope.companyId}, function (data) {
            $scope.employeeList = data;

        });

        $scope.selection = [];
        // toggle selection for a given employee by name
        $scope.toggleSelection = function (id) {

            var idx = $scope.selection.indexOf(id);

            // is currently selected
            if (idx > -1) {
                $scope.selection.splice(idx, 1);
            }

            // is newly selected
            else {
                $scope.selection.push(id);
            }
        };


        $scope.update = function () {

            usSpinnerService.spin('spinner-1');
            employeeService.update({
                    selection: $scope.selection,
                    companyId: $scope.companyId

                },
                function (data) {
                    usSpinnerService.stop('spinner-1');
                    $notification.success('Updated Successfully', '');

                }, function (error) {
                    usSpinnerService.stop('spinner-1');
                    $notification.error('Error', 'Internal Error');
                }
            );

        }

    }]);

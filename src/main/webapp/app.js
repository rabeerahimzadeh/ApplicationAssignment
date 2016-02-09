var app = angular.module('application', ['ngRoute',
    'companyServices',
    'companyController',
    'companyDetailsController',
    'employeeServices',
    'employeeController',
    'ownerServices',
    'ownerController'
]);


app.config(function ($routeProvider) {
    $routeProvider
        .when('/company', {
            templateUrl: 'view/company.jsp',
            controller: 'companyCtrl'
        })
        .otherwise({
            redirectTo: '/company'
        });
});


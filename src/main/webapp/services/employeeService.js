angular.module('employeeServices', ['ngResource'])
    .factory('employeeService', function ($resource) {
        var resource = $resource('employee/:id', {}, {
            'query': {
                method: 'GET',
                isArray: true
            },
            'get': {
                method: 'GET',
                params: {
                    id: '@id'
                }
            },
            'update': {
                method: 'PUT'
            },
            'create': {
                method: 'POST'
            }
        });
        return resource;
    });


angular.module('companyServices', ['ngResource'])
    .factory('companyService', function ($resource) {
        var resource = $resource('company/:id', {}, {
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


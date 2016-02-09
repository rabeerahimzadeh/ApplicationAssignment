angular.module('ownerServices', ['ngResource'])
    .factory('ownerService', function ($resource) {
        var resource = $resource('owner/:id', {}, {
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


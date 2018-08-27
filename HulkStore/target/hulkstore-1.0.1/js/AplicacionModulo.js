'use strict';

// Declare app level module which depends on filters, and services
var module = angular.module('adminAplicacion', [
    'ngRoute'        
]);
module.config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/', {templateUrl: 'partials/index.html'});
        $routeProvider.when('/Venta', {templateUrl: 'partials/Venta.html', controller: 'VentaCtrl'});
        $routeProvider.when('/Producto', {templateUrl: 'partials/Producto.html', controller: 'ProductoCtrl'});
        $routeProvider.otherwise({redirectTo: '/'});
    }]);

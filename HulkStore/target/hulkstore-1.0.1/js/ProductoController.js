'use strict';


module.controller('ProductoCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.listarProductos = function () {
            $http.get('./webresources/Producto', {})
                    .success(function (data, status, headers, config) {
                        $scope.productos = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarProductos();


    }]);

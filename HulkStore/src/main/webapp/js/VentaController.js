'use strict';


module.controller('VentaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.carrito = [];

        $scope.listarProductos = function () {
            $http.get('./webresources/Producto', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarProductos();

        $scope.agregarProducto = function (producto) {
            var existe = false;
            angular.forEach($scope.carrito, function (val) {
                if (val.id === producto.id) {
                    val.cantidad++;
                    existe = true;
                }
            });
            if (!existe) {
                producto.cantidad = 1;
                $scope.carrito.push(producto);
            }
        };

        $scope.borrar = function (producto) {
            var index = $scope.carrito.indexOf(producto);
            if (index > -1) {
                $scope.carrito.splice(index, 1);
            }
        };

        $scope.comprar = function () {

        }


    }]);

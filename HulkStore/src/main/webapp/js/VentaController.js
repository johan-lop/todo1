'use strict';


module.controller('VentaCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.carrito = [];
        $scope.venta = {};

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
            $scope.calculaTotal();
        };

        $scope.borrar = function (producto) {
            var index = $scope.carrito.indexOf(producto);
            if (index > -1) {
                $scope.carrito.splice(index, 1);
            }
        };

        $scope.comprar = function () {
            $scope.venta.detalleVenta = $scope.carrito;
            $scope.venta.valor = $scope.valorTotal;
            $http.post('./webresources/Venta', JSON.stringify($scope.venta), {})
                    .success(function (data, status, headers, config) {
                        $scope.listarProductos();
                        $scope.carrito = [];
                        $scope.venta = {};
                        alert("Gracias por su compra");
                    }).error(function (data, status, headers, config) {
                alert((data && data.mensaje) ? data.mensaje : 'Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };

        $scope.calculaTotal = function () {
            $scope.valorTotal = 0;
            if ($scope.carrito.length) {
                angular.forEach($scope.carrito, function (val) {
                    if (!isNaN(val.cantidad)) {
                        $scope.valorTotal += val.valor * val.cantidad;
                    }
                });
            }
        };


    }]);

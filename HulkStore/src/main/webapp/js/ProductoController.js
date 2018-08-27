'use strict';


module.controller('ProductoCtrl', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

        $scope.carrito = [];
        $scope.nuevoProducto = {};

        $scope.listarProductos = function () {
            $http.get('./webresources/Producto', {})
                    .success(function (data, status, headers, config) {
                        $scope.lista = data;
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        $scope.listarProductos();

        $scope.editarProducto = function (producto) {
            $scope.nuevoProducto = producto;

        };

        $scope.readURL = function () {
            var input = document.getElementById('file');
            if (input.files && input.files[0]) {
                var formatos = input.accept.split(",");
                var valido = false;
                for (var i = 0; i < formatos.length; i++) {
                    if (input.files[0].name.indexOf(formatos[i]) !== -1) {
                        valido = true;
                        break;
                    }
                }
                if (valido) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $scope.nuevoProducto.imagen = e.target.result;
                        $scope.$apply();
                    };
                    reader.readAsDataURL(input.files[0]);
                } else {
                    alert('Formato de archivo incorrecto solo se aceptan las siguientes tipos de archivos  ' + input.accept);
                    input.value = '';
                }

            }
        };

        $scope.guardar = function () {
            $http.post('./webresources/Producto', JSON.stringify($scope.nuevoProducto), {})
                    .success(function (data, status, headers, config) {
                        $scope.nuevoProducto = {};
                        $scope.listarProductos();
                    }).error(function (data, status, headers, config) {
                alert('Error al consultar la informaci\xf3n, por favor intente m\xe1s tarde');
            });
        };
        
        $scope.limpiar = function() {
            $scope.nuevoProducto = {};
        };

    }]);

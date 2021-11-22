angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadProducts = function () { // функция загрузить студентов
        $http.get(contextPath + '/products') // посылаем гет-запрос на бэкенд по адресу /students
            .then(function (response) { // в ответ на этот запрос мы получаем некий ответ
                $scope.ProductsList = response.data; // положили ProductsList, чтобы обращаться к нему в index.html, выводится в data
            });
    };

    $scope.deleteProduct = function (productId){
            $http.get(contextPath + '/products/delete/' + productId) // посылаем гет-запрос на бэкенд по адресу /students
                .then(function (response) { // в ответ на этот запрос мы получаем некий ответ
                    $scope.loadProducts();
                });
        };

    $scope.changeScore = function (productId, delta) {
        $http({
            url: contextPath + '/products/change_score',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
                    $scope.loadProducts();
        });
    }


    $scope.loadProducts(); // при старте приложения вызываем эту функцию
});
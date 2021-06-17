angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/happy/api/v1';

    $scope.fillTable = function () {
        $http({
            url: contextPath + '/students',
            method: 'GET'
        }).then(function (response) {
            $scope.StudentsList = response.data;
        });
    };

    $scope.submitCreateNewStudent = function () {
        $http.post(contextPath + '/students', $scope.newStudent)
            .then(function (response) {
                $scope.newStudent = null;
                $scope.fillTable();
            });
    };

    $scope.deleteStudentById = function (productId) {
        $http.delete(contextPath + '/students/' + studentId)
            .then(function (response) {
                $scope.fillTable();
            });
    }

    $scope.deleteStudentById = function (studentId) {
            $http.delete(contextPath + '/students/' + studentId)
                .then(function (response) {
                    $scope.fillTable();
                });
        }

    $scope.fillTable();
});
'use strict';

var list = angular.module('listService', ['ngRoute']);

list.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'getEmployees'
  });
}])

list.controller('getEmployees', function($scope, $http) {
  $scope.$emit("refresh", true);
  $scope.$on('refresh', function(event){
    $http({
      method: 'GET',
      url: 'http://localhost:8080/employee/index?page=1&size=5'
    }).then(function success(response) {
      console.log("ini log get employee "+response);
      $scope.value = response.data.content
    })
  })
  
});



list.controller('deleteServiceCtrl', function ($scope, $http) {
  $scope.id = null;
  $scope.deletedata = function (data) {
  let said = confirm('Are you sure want to delete ?');

  if(said==false) {
    console.log('you out');
  } else {
  $http({
    method: 'DELETE',
    url: 'http://localhost:8080/employee',
    data: data,
    headers: {
        'Content-type': 'application/json'
    }
  })
  .then(function (response) {
    $scope.msg = "Data Deleted Successfully!";
    $scope.$emit("refresh", true);
  }, function (response) {
    $scope.msg = "Service not Exists";
    $scope.statusval = response.status;
    $scope.statustext = response.statusText;
    $scope.headers = response.headers();
  });
  }
  };
});
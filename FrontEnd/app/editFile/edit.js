'use strict';

var passingData = angular.module('Edit', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/Edit/:id', {
    templateUrl: 'editFile/Edit.html',
    controller: 'getEmployeeById'
  });
}])

passingData.controller('getEmployeeById', function($scope, $http, $routeParams) {
  $http({
    method: 'GET',
    url: 'http://localhost:8080/employee/'+$routeParams.id
  }).then(function success(response) {
    $scope.employee = response.data.employee
    $scope.positions = response.data.positionList
  })
});

passingData.controller('putEmployee', function($scope, $http, $location) {
  
  $scope.putData = function (id,name,birthDate,position,idNumber,gender) {
    let said = confirm('Are you sure want to submit this ?');
    if(said==true){
      let data = {
        id:id,
        name: name,
        birthDate: birthDate,
        position: position,
        idNumber: idNumber,
        gender: gender,
        isDelete: 0
      };
    
    $http.put('http://localhost:8080/employee', JSON.stringify(data)).then(function (respon) {
      if(respon.data)
      $scope.msg ="Post Data Submitted Successfully!"
      $location.path("#!/view1")
    }, function (respon) {
      $scope.msg = "Service not Exists";
      $scope.statusval = respon.status;
      $scope.statustext = respon.statusText;
      $scope.headers = respon.headers();
    }
    )
  }
}
})


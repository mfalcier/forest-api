angular.module('homework', [])
.controller('formController', function($scope, $http) {
	$scope.formData = {};
	$scope.processForm = function() {
		$http.get('http://localhost:8080/forest/discover/' + $scope.formData.forestId + '/' + $scope.formData.total).
	    then(function(response) {
	        $scope.cutDownAreas = response.data;
	    });
	};
});
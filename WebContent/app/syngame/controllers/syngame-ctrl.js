(function(){
	angular.module('syngame').controller('MainViewController',function($scope, $rootScope, $localStorage ,$state, $stateParams, $resource,  $filter, DTOptionsBuilder, modalPopupService) {

		$scope.message = $stateParams.message;
	    $scope.status = $stateParams.status;
	    $scope.gameList =[];
			
		$scope.dtOptions =  DTOptionsBuilder.newOptions()
		.withOption("bAutoWidth", false)
		.withOption("paging", true)
		.withOption("searching", true)
        .withOption("aaSorting", [])
        .withOption("responsive", true)
        .withOption("scrollX", true);
	
		
		$scope.search = function(){
			console.log("Display data in table");
		    
			$resource('syngame').query().$promise.then(function(resp) {
				 gameList = resp;
				 angular.extend($scope.gameList, resp);
			 });
		}
		$scope.search();
});
})();
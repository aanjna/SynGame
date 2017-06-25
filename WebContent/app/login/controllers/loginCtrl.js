(function() {
	angular.module('login').controller(
			'ValidLoginController',
			function($resource, $scope, $rootScope,$localStorage, $state, $uibModal) {

				$scope.login = {};
				$scope.login.username;
				$scope.login.password;
				$localStorage.user = $scope.login.username;
				
				$scope.save = function(dashboard) {
					var username = $scope.login.username;
					var password = $scope.login.password;
					var login = {
						userName : username,
						password : password
					}

					$resource('Syn/user/login').save(login).$promise.then(
							function(response) {
								console.log("success=====" + response.status);
								if(response.status== 'success'){
									$scope.message = response.message;
									$state.transitionTo('mis.dashboard');
									$localStorage.login = true;
								
									$localStorage.role = response.roleId;
									console.log("role id =:" +response.roleId);
								
								}
								else {
									$scope.message = response.message;
								}
							}, function(err) {
								console.log("err-----" + err);
								$scope.message = response.message;
								// $state.transitionTo('login.tmpl');
							});
				}
			});
	
	angular.module('login').controller('LogoutController',function($rootScope,$localStorage, $scope, $state){
		$localStorage.login = false;
		$localStorage.user = null;
		localStorage.clear();
		$state.transitionTo('login.tmpl',{reload : true});
	});
})();

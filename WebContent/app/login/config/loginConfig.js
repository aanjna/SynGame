(function(){
	angular.module('login').config([ '$stateProvider', function($stateProvider) {
		$stateProvider.state('login', {
			url : '',
			abstract :true,
			controller : 'loginModelController',
			data: {
				 breadcrumbProxy: 'login'
	        }
		}).state('login.tmpl', {
			url : '/login',
			views : {
				'@' : {
					templateUrl : 'app/login/html/login-tmpl.html',
					controller : 'ValidLoginController'
				}
			},
			params : {message : ''},
			data: {
	            displayName: 'Login'
	        }
		}).state('login.logout', {
			url : '/logout',
			views : {
				'@' : {
					
					controller : 'LogoutController'
				}
			},
			data: {
	            displayName: 'Logout'
	        }
		});
	}]);
})();
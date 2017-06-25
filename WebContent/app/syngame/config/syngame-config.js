(function(){
	angular.module('syngame').config([ '$stateProvider', function($stateProvider) {
		$stateProvider.state('syngame', {
			url : '/syngame',
			abstract :true,
			controller : 'MainViewModalController',
			data: {
				 breadcrumbProxy: 'syngame.list'
	        }
		}).state('syngame.list', {
			url : '/syngame',
			views : {
				'@' : {
					templateUrl : 'app/syngame/html/syngame.html',
					controller : 'MainViewController'
				}
			},
			data: {
	            displayName: 'syngame'
	        },
	        params : {
	        	message : '',
	        	status : ''
	        }
		});
	}]);
})();
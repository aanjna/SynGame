angular.module('login',['ui.router', 'ngResource']);
angular.module('syngame',['ui.router','datatables','angularUtils.directives.uiBreadcrumbs','ui.bootstrap','ngResource']);

angular.module('dms',['login','ngStorage','syngame']);

angular.module('dms').config(
		function($urlRouterProvider) {
			$urlRouterProvider.when('', 'login', 'syngame');
		});



angular.module('login').service('modalPopupService' ,function($window, $uibModal){
	function getBrowser(){
		 	var userAgent = $window.navigator.userAgent;
		 	console.log("userAgent :::: "+userAgent);
	        var browsers = {chrome: /chrome/i, safari: /safari/i, firefox: /firefox/i, ie: /internet explorer/i};
	        for(var key in browsers) {
	            if (browsers[key].test(userAgent)) {
	                return key;
	            }
	       };
	       return 'unknown';
	}

 	var browser = getBrowser();
	var isIEBrowser = (browser == 'ie');
	console.log("Browser....."+browser);

	function openPopup(options, disableBackdrop){
		if(isIEBrowser || disableBackdrop){
			options.backdrop = 'static';
		    options.keyboard = false;
		}

		$uibModal.open(options);
	}

	function closePopup($uibModalInstance, $uibModalStack){
		if($uibModalStack){
			$uibModalStack.dismissAll('closing');
		}
		else if($uibModalInstance){
			$uibModalInstance.dismiss('cancel');
		}
	}

	return{
		openPopup : openPopup,
		closePopup : closePopup
	};
});
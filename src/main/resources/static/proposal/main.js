var app = angular.module('proposalApp', ['ui.mask','ngRoute']);

app.config(['$routeProvider', function($routeProvider, $provide) {

	$routeProvider
		.when('/', {
			templateUrl : 'proposal/template/home.html',
			controller: 'HomeController'
		})
        .when('/proposals', {
            templateUrl : 'proposal/template/proposals.html',
            controller: 'ProposalController'
        })
		.otherwise({
			redirectTo: '/'
		});

}]);

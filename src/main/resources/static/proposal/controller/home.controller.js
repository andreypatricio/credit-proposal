app.controller("HomeController", function($scope, $timeout, HomeService){

	    $scope.proposal = {};
	    $scope.messageError = '';
	    $scope.messageSuccess = '';

    	$scope.submitProposal = function(){
        		HomeService.submitProposal($scope.proposal).then(function(response){
                    $scope.messageSuccess = 'Proposal has sent to queue!'
                    $scope.messageError = '';
        			$scope.saved = true;
        			if(response.data != null && response.data.message.search('constraint') > -1){
        			    $scope.messageError = 'CPF already exists!';
        			    $scope.messageSuccess = ''
        			}
        		});

        		$scope.proposal = {};

            };

        var timeoutPromise;
            $scope.$watch("messageSuccess", function(messageSuccess) {
                $timeout.cancel(timeoutPromise);
                timeoutPromise = $timeout(function(){
                    if($scope.messageSuccess.localeCompare('')){
                        $scope.messageSuccess = ''
                    }
             }, 4000);
        });

        var timeoutPromise;
            $scope.$watch("messageError", function(messageError) {
                $timeout.cancel(timeoutPromise);
                timeoutPromise = $timeout(function(){
                    if($scope.messageError.localeCompare('')){
                        $scope.messageError = ''
                    }
             }, 4000);
        });


});
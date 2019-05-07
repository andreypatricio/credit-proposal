app.controller("ProposalController", function($scope, $timeout, ProposalService){

    $scope.proposals = [];
    $scope.proposal = {};
    $scope.messageAnalyze = '';
    $scope.messageDelete = '';

            $scope.loadProposals = function () {
                ProposalService.loadProposals().then(function(response){
                    $scope.proposals = response;
                });
            };

            $scope.deleteProposal = function(proposal){
                ProposalService.deleteProposal(proposal.id).then(function(response){
                    $scope.messageAnalyze = ''
                    $scope.messageDelete = 'Proposal has been deleted!';
                    $scope.loadProposals();
                });
            };

            $scope.analyzeProposal = function(proposal){
                ProposalService.analyzeProposal(proposal).then(function(response){
                   $scope.loadProposals();
                   $scope.messageAnalyze = 'Proposal has been analyzed!'
                   $scope.messageDelete = '';
                });
            };

            var timeoutPromise;
                $scope.$watch("messageAnalyze", function(messageAnalyze) {
                    $timeout.cancel(timeoutPromise);
                    timeoutPromise = $timeout(function(){
                        if($scope.messageAnalyze.localeCompare('')){
                            $scope.messageAnalyze = ''
                        }
                 }, 4000);
            });

            var timeoutPromise;
                $scope.$watch("messageDelete", function(messageDelete) {
                    $timeout.cancel(timeoutPromise);
                    timeoutPromise = $timeout(function(){
                        if($scope.messageDelete.localeCompare('')){
                            $scope.messageDelete = ''
                        }
                 }, 4000);
            });

});
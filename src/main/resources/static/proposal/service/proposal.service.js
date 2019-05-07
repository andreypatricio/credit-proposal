app.service("ProposalService",function($http){

    	this.loadProposals = function(){
    		return $http.get("/proposals").then(function(response) {
    			return response.data;
    		}, function(errResponse) {
    			return errResponse;
    		});
    	}

        this.deleteProposal = function(id){
            return $http.delete("/proposals/"+ id).then(function(response) {
                return response.data;
            }, function(errResponse) {
                return errResponse;
            });
        }

        this.analyzeProposal = function(proposal){
            return $http.put("/proposals/"+ proposal.id, proposal).then(function(response) {
                return response.data;
            }, function(errResponse) {
                return errResponse;
            });
        }

});

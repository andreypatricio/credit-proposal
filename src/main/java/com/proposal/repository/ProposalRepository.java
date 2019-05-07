package com.proposal.repository;

import com.proposal.model.Proposal;
import org.springframework.data.repository.CrudRepository;


public interface ProposalRepository extends CrudRepository<Proposal, Long> {}

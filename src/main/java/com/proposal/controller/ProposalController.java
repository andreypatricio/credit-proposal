package com.proposal.controller;

import com.proposal.model.Proposal;
import com.proposal.repository.ProposalRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.math.BigDecimal;
import java.net.URI;

import static com.proposal.constants.ProposalConstants.*;

@RestController
@RequestMapping("proposals")
@Api(value = "Proposal")
public class ProposalController {

    @Autowired
    ProposalRepository proposalRepository;


    @ApiOperation(value = "Submit a proposal")
    @PostMapping
    public ResponseEntity<Proposal> submitProposal(@RequestBody final Proposal proposal) {

        proposal.setResult("Pending");
        proposal.setCpf(formatCPF(proposal.getCpf()));

        Proposal proposalSubmited = this.proposalRepository.save(proposal);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(proposalSubmited.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Load proposals list")
    @GetMapping
    public Iterable<Proposal> loadProposals() {
        return this.proposalRepository.findAll();
    }

    @ApiOperation(value = "Delete a proposal")
    @DeleteMapping("/{id}")
    public void deleteProposal(@PathVariable("id") final Long id) {
        this.proposalRepository.deleteById(id);
    }

    @ApiOperation(value = "Analyze a proposal")
    @PutMapping("/{id}")
    public Proposal analyzeProposal(@PathVariable("id") final Long id, @RequestBody final Proposal proposal) {
        return this.proposalRepository.save(analyze(proposal));
    }

    public Proposal analyze(Proposal proposal) {

        Integer points = 0;

        BigDecimal income = proposal.getIncome();
        Integer dependents = proposal.getDependents();
        Integer age = proposal.getAge();
        char maritalStatus = proposal.getMaritalStatus();
        char sex = proposal.getSex();

        if (DIVORCED == maritalStatus) {
            proposal.setResult(PROPOSAL_DENIED);
            proposal.setLimitApproved(DENIED_CREDIT_POLITICS);
        } else if (isBetween(income, BigDecimal.ZERO, MINIMUM_INCOME)) {
            proposal.setResult(PROPOSAL_DENIED);
            proposal.setLimitApproved(DENIED_LOW_INCOME);
        } else {
            if (isBetween(income, MAX_CLASS_FLOOR, MAX_CLASS_CEILING)) {
                points += 60;
            } else if (isBetween(income, A_CLASS_FLOOR, A_CLASS_CEILING)) {
                points += 50;
            } else if (isBetween(income, B_CLASS_FLOOR, B_CLASS_CEILING)) {
                points += 40;
            } else if (isBetween(income, C_CLASS_FLOOR, C_CLASS_CEILING)) {
                points += 20;
            } else if (isBetween(income, D_CLASS_FLOOR, D_CLASS_CEILING)) {
                points += 10;
            } else if (isBetween(income, E_CLASS_FLOOR, E_CLASS_CEILING)) {
                points += 0;
            }

            if (isBetween(age, 15, 19)) {
                points -= 10;
            } else if (isBetween(age, 20, 49)) {
                points += 10;
            }

            if (maritalStatus == MARRIED) {
                points += 10;
            } else if (maritalStatus == SINGLE) {
                points -= 10;
            }

            if (sex == WOMAN) {
                points -= 10;
            }

            points = points - (dependents * 10);

            if(points <= 0){
                proposal.setResult(PROPOSAL_DENIED);
                proposal.setLimitApproved(DENIED_CREDIT_POLITICS);
            } else if(points == LIMIT_APPROVED_100_500){
                proposal.setResult(PROPOSAL_APPROVED);
                proposal.setLimitApproved(APPROVED_100_500);
            } else if(points == LIMIT_APPROVED_500_1000) {
                proposal.setResult(PROPOSAL_APPROVED);
                proposal.setLimitApproved(APPROVED_500_1000);
            } else if(points == LIMIT_APPROVED_1000_1500) {
                proposal.setResult(PROPOSAL_APPROVED);
                proposal.setLimitApproved(APPROVED_1000_1500);
            } else if(points == LIMIT_APPROVED_1500_2000) {
                proposal.setResult(PROPOSAL_APPROVED);
                proposal.setLimitApproved(APPROVED_1500_2000);
            } else if(points >= LIMIT_APPROVED_MAX) {
                proposal.setResult(PROPOSAL_APPROVED);
                proposal.setLimitApproved(APPROVED_MAX);
            }

        }

        return proposal;
    }

    private String formatCPF(String cpf) {
        String formatted = "";

        String fist = cpf.substring(0, 3);
        String second = cpf.substring(3, 6);
        String third = cpf.substring(6, 9);
        String fourth = cpf.substring(9, 11);

        formatted = fist + "." + second + "." + third + "-" + fourth;

        return formatted;
    }

    public static <T extends Comparable<T>> boolean isBetween(T value, T start, T end) {
        return value.compareTo(start) >= 0 && value.compareTo(end) <= 0;
    }

}

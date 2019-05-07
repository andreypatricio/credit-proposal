package com.proposal.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PROPOSAL")
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CPF", unique = true)
    private String cpf;

    @Column(name = "STATE")
    private String state;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private char sex;

    @Column(name = "MARITAL_STATUS")
    private char maritalStatus;

    @Column(name = "DEPENDENTS")
    private Integer dependents;

    @Column(name = "INCOME")
    private BigDecimal income;

    @Column(name = "RESULT")
    private String result;

    @Column(name = "LIMIT_APPROVED")
    private String limitApproved;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public char getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(char maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getDependents() {
        return dependents;
    }

    public void setDependents(Integer dependents) {
        this.dependents = dependents;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getLimitApproved() {
        return limitApproved;
    }

    public void setLimitApproved(String limitApproved) {
        this.limitApproved = limitApproved;
    }
}

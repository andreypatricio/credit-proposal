package com.proposal.constants;

import java.math.BigDecimal;

public interface ProposalConstants {

    String PROPOSAL_DENIED = "Denied";
    String PROPOSAL_APPROVED = "Approved";
    String DENIED_LOW_INCOME = "Low Income";
    String DENIED_CREDIT_POLITICS = "Credit Politics";

    String APPROVED_100_500 = "Between $100 and $500";
    String APPROVED_500_1000 = "Between $500 and $1000";
    String APPROVED_1000_1500 = "Between $1000 and $1500";
    String APPROVED_1500_2000 = "Between $1500 and $2000";
    String APPROVED_MAX = "$2000+";

    char SINGLE = 'S';
    char MARRIED = 'M';
    char DIVORCED = 'D';
    char WIDOW_WIDOWER = 'W';

    char MAN = 'M';
    char WOMAN = 'W';

    BigDecimal MINIMUM_INCOME = BigDecimal.valueOf(400);
    BigDecimal MAX_CLASS_FLOOR = BigDecimal.valueOf(5000);
    BigDecimal MAX_CLASS_CEILING = BigDecimal.valueOf(99999);

    BigDecimal A_CLASS_FLOOR = BigDecimal.valueOf(4000);
    BigDecimal A_CLASS_CEILING = BigDecimal.valueOf(4999);
    BigDecimal B_CLASS_FLOOR = BigDecimal.valueOf(3000);
    BigDecimal B_CLASS_CEILING = BigDecimal.valueOf(3999);
    BigDecimal C_CLASS_FLOOR = BigDecimal.valueOf(2000);
    BigDecimal C_CLASS_CEILING = BigDecimal.valueOf(2999);
    BigDecimal D_CLASS_FLOOR = BigDecimal.valueOf(1000);
    BigDecimal D_CLASS_CEILING = BigDecimal.valueOf(1999);
    BigDecimal E_CLASS_FLOOR = BigDecimal.valueOf(501);
    BigDecimal E_CLASS_CEILING = BigDecimal.valueOf(999);

    Integer LIMIT_APPROVED_100_500 = 10;
    Integer LIMIT_APPROVED_500_1000 = 20;
    Integer LIMIT_APPROVED_1000_1500 = 30;
    Integer LIMIT_APPROVED_1500_2000 = 40;
    Integer LIMIT_APPROVED_MAX = 50;

}

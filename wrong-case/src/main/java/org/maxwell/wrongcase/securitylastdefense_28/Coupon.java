package org.maxwell.wrongcase.securitylastdefense_28;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Coupon {
    private long userId;
    private BigDecimal amount;
}

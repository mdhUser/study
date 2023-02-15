package org.maxwell.wrongcase.codeoptimization_21.reflection.right;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/15 11:05
 */
public enum BankAPIFieldType implements IFormatter {


    S {
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            return String.format("%-" + bankAPIField.length() + "s", value.toString()).replace(" ", "_");
        }
    },

    N {
        //stringBuilder.append(String.format("%" + bankAPIField.length() + "s", value.toString()).replace(' ', '0'));
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            return String.format("%" + bankAPIField.length() + "s", value.toString()).replace(" ", "_");
        }
    },
    M {
        //stringBuilder.append(String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(new BigDecimal("100")).longValue()));
        @Override
        public String format(Object value, BankAPIField bankAPIField) {
            if (!(value instanceof BigDecimal))
                throw new RuntimeException("错误类型导入");
            return String.format("%0" + bankAPIField.length() + "d", ((BigDecimal) value).setScale(2, RoundingMode.DOWN).multiply(BigDecimal.valueOf(100)).longValue());
        }
    };

}

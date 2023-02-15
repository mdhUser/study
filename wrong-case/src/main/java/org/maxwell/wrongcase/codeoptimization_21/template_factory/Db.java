package org.maxwell.wrongcase.codeoptimization_21.template_factory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/2/12 14:24
 */
public class Db {

    private static Map<Long, BigDecimal> items = new HashMap<>(10);

    static {
        items.put(1L, new BigDecimal("10"));
        items.put(2L, new BigDecimal("10"));
    }

    public static BigDecimal getItemPrice(long id) {
        return items.get(id);
    }

    public static String getUserCategory(long userId) {
        if (userId == 1L) return "Normal";
        if (userId == 2L) return "Vip";
        if (userId == 3L) return "Internal";
        return "Normal";
    }

    public static int getUserCouponPercent(long userId) {
        return 90;
    }

}

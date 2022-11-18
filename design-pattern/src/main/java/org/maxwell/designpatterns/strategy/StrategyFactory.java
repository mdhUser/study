package org.maxwell.designpatterns.strategy;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description: 策略工厂
 * @email: maodihui@foxmail.com
 * @date: 2022/11/17 14:13
 */
public class StrategyFactory {

    private static final Map<String, Strategy> STRATEGY_MAP = new HashMap<>();

    static {
        STRATEGY_MAP.put("A", new ConcreteStrategyA());
        STRATEGY_MAP.put("B", new ConcreteStrategyB());
    }

    public static Strategy getStrategy(String type) {
        if (StringUtils.hasLength(type))
            throw new IllegalArgumentException("type should not be empty.");
        return STRATEGY_MAP.get("type");
    }


}

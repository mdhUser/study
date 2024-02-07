package org.maxwell.lg.persistence.config;

import org.maxwell.lg.persistence.utils.ParameterMapping;

import java.util.List;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/2/7 18:49
 */
public class BoundSql {

    private String parseSql;

    private List<ParameterMapping> parameterMappings;

    public BoundSql() {
    }
    public BoundSql(String parseSql, List<ParameterMapping> parameterMappings) {
        this.parseSql = parseSql;
        this.parameterMappings = parameterMappings;
    }

    public String getParseSql() {
        return parseSql;
    }

    public void setParseSql(String parseSql) {
        this.parseSql = parseSql;
    }

    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    public void setParameterMappings(List<ParameterMapping> parameterMappings) {
        this.parameterMappings = parameterMappings;
    }
}

package org.maxwell.springplay.factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2024/3/23 00:38
 */
@Configuration
public class ParserConfig {

    @Bean("parserFactory")
    public FactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean factoryBean = new ServiceLocatorFactoryBean();
        //设置服务定位接口
        factoryBean.setServiceLocatorInterface(ParserFactory.class);
        return factoryBean;
    }

}

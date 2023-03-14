package org.maxwell.flowable;

import org.flowable.engine.ProcessEngine;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.DeploymentBuilder;
import org.flowable.engine.repository.ProcessDefinition;
import org.flowable.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2023/3/2 21:06
 */
public class FlowableTest {

    StandaloneProcessEngineConfiguration configuration;

    @Before
    public void before() {
        configuration = new StandaloneProcessEngineConfiguration();
        configuration.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        configuration.setJdbcUsername("root");
        configuration.setJdbcPassword("Maxwell0326");
        configuration.setJdbcUrl("jdbc:mysql://59.36.170.213:3306/flowable?serverTimezone=UTC&nullCatalogMeansCurrent=true");
        //如果数据库表结构不存在就创建
        configuration.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    }


    @Test
    public void testDeploy() {
        //获取流程引擎
        ProcessEngine processEngine = configuration.buildProcessEngine();
        //获取RepositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("holiday_request.bpmn20.xml")
                .name("请假流程").deploy();
        System.out.println("deploy.id=" + deployment.getId());
        System.out.println("deploy.name=" + deployment.getName());
    }

    /**
     * 查询流程
     */
    @Test
    public void testQuery() {

        ProcessEngine processEngine = configuration.buildProcessEngine();
        RepositoryService repositoryService = processEngine.getRepositoryService();

        ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery()
                .deploymentId("1").singleResult();


        processDefinition.getDeploymentId();
        processDefinition.getDescription();

    }

    /**
     * 启动流程实例
     */
    public void testRunProcess() {

        ProcessEngine processEngine = configuration.buildProcessEngine();
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //构建流程变量
        Map<String, Object> variables = new HashMap<>();
        variables.put("employee", "张三");
        variables.put("dayOfHolidays", 3);
        variables.put("description", "旅游");
        //创建启动流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holidayRequest", variables);
        System.out.println("processInstance.getProcessDefinitionId() = " + processInstance.getProcessDefinitionId());
        System.out.println("processInstance.getActivityId() = " + processInstance.getActivityId());


    }


}

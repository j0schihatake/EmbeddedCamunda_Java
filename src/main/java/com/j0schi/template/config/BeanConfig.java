package com.j0schi.template.config;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.impl.RuntimeServiceImpl;
import org.camunda.bpm.engine.impl.cfg.AbstractProcessEnginePlugin;
import org.camunda.bpm.engine.impl.cfg.ProcessEnginePlugin;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    public RuntimeService runtimeService(){
        return new RuntimeServiceImpl();
    }

    public ProcessEnginePlugin processEnginePlugin(){
        return new AbstractProcessEnginePlugin();
    }
}

package com.j0schi.template.controller;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/process")
public class ProcessController {

    @Autowired
    private RuntimeService runtimeService;

    /**
     * Запускает указанный процесс
     * Пример Url:
     * http://localhost:8080/api/process/start/onboarding
     * @param processKey
     * @param businessKey
     * @param params
     * @return
     */
    @GetMapping("/start/{processKey}")
    public String startProcessByKey(
            @PathVariable String processKey,
            @RequestParam(required = false) String businessKey,
            @RequestParam Map<String, Object> params) {

        // Запускаем процесс
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(
                processKey,
                businessKey,
                params
        );

        return String.format("Process '%s' started with ID: %s",
                processKey,
                instance.getId());
    }

    @PostMapping("/start")
    public String startProcess(@RequestBody Map<String, Object> variables) {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("onboarding", variables);
        return "Process started: " + instance.getId();
    }
}

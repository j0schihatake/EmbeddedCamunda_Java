package com.j0schi.template;

import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@EnableProcessApplication
public class CamundaTemplateApplication implements CommandLineRunner {

	@Autowired
	private RepositoryService repositoryService;

	public static void main(String[] args) {
		SpringApplication.run(CamundaTemplateApplication.class, args);
	}

	@Override
	public void run(String... args) {
		// Проверка задеплоенных процессов
		List<ProcessDefinition> processes = repositoryService.createProcessDefinitionQuery()
				.list();

		System.out.println("Deployed processes:");
		processes.forEach(p -> System.out.println(
				" - " + p.getKey() + " (v" + p.getVersion() + ")"
		));
	}

}

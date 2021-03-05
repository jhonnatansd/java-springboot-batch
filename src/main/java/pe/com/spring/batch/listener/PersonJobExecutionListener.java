package pe.com.spring.batch.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class PersonJobExecutionListener implements JobExecutionListener {

	@Override
	public void beforeJob(JobExecution jobExecution) {
		log.info("beforeJob");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		log.info("afterJob: {}", jobExecution.getStatus());
	}

}

package pe.com.spring.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pe.com.spring.batch.core.PersonItemProcessor;
import pe.com.spring.batch.core.PersonItemReader;
import pe.com.spring.batch.core.PersonItemWriter;
import pe.com.spring.batch.listener.PersonItemProcessListener;
import pe.com.spring.batch.listener.PersonItemReaderListener;
import pe.com.spring.batch.listener.PersonItemWriterListener;
import pe.com.spring.batch.listener.PersonJobExecutionListener;
import pe.com.spring.batch.model.Person;

@Configuration
public class BatchConfiguration {
	
	@Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
	
    @Bean
    public PersonItemReader reader() {
    	return new PersonItemReader();
    }
    
    @Bean
    public PersonItemProcessor processor() {
    	return new PersonItemProcessor();
    }
    
    @Bean
    public PersonItemWriter writer() {
    	return new PersonItemWriter();
    }
    
    @Bean
    public PersonItemReaderListener readerListener() {
    	return new PersonItemReaderListener();
    }
    
    @Bean
    public PersonItemProcessListener processListener() {
    	return new PersonItemProcessListener();
    }
    
    @Bean
    public PersonItemWriterListener writerListener() {
    	return new PersonItemWriterListener();
    }
    
    @Bean
    public Job job(Step step, PersonJobExecutionListener jobExecutionListener) {
        Job job = jobBuilderFactory.get("job1")
        		.listener(jobExecutionListener)
                .flow(step)
                .end()
                .build();
        
        return job;
    }
    
    @Bean
    public Step step(PersonItemReader reader,
                     PersonItemWriter writer,
                     PersonItemProcessor processor,
                     PersonItemReaderListener readerListener,
                     PersonItemProcessListener processListener,
                     PersonItemWriterListener writerListener) {

        TaskletStep step = stepBuilderFactory.get("step1")
                .<Person, Person> chunk(100)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(readerListener)
                .listener(processListener)
                .listener(writerListener)
                .build();
        
        return step;
    }

}

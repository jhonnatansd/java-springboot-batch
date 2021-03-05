package pe.com.spring.batch.core;

import java.util.Iterator;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;
import pe.com.spring.batch.repository.PersonRepository;

@Slf4j
public class PersonItemReader implements ItemReader<Person> {
	
	@Autowired
	private PersonRepository personRepository;
	
	private Iterator<Person> personIterator;
	
	@BeforeStep
	public void before(StepExecution stepExecution) {
		personIterator = personRepository.findAll().iterator();
	}

	@Override
	public Person read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		log.info("Reading information");
		
		if (personIterator != null && personIterator.hasNext()) {
			return personIterator.next();
		} else {
			return null;
		}
	}

}

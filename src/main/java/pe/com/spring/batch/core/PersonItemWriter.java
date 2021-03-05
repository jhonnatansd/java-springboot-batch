package pe.com.spring.batch.core;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;
import pe.com.spring.batch.repository.PersonRepository;

@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {
	
	@Autowired
	PersonRepository personRepository;

	@Override
	public void write(List<? extends Person> list) throws Exception {
		log.info("Saving Person");
		
		personRepository.saveAll(list);
	}

}

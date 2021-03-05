package pe.com.spring.batch.core;

import java.time.LocalDateTime;

import org.springframework.batch.item.ItemProcessor;

import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;

@Slf4j
public class PersonItemProcessor implements ItemProcessor<Person, Person>{

	@Override
	public Person process(Person person) throws Exception {
		if (person.getId() %2 != 0) {
			log.warn("Ignoring: {}", person.toString());
			return null;
		}

		log.info("Procesing: {}", person.toString());
		person.setNombre(person.getNombre().toUpperCase());
		person.setFechaActualizacion(LocalDateTime.now());
		
		return person;
	}

}

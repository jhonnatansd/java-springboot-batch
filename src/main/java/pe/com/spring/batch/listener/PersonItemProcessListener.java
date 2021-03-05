package pe.com.spring.batch.listener;

import org.springframework.batch.core.ItemProcessListener;

import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;

@Slf4j
public class PersonItemProcessListener implements ItemProcessListener<Person, Person>{

	@Override
	public void beforeProcess(Person person) {
		log.info("beforeProcess: {}", person);
	}

	@Override
	public void afterProcess(Person item, Person result) {
		log.info("afterProcess: {} -> {}", item, result);
	}

	@Override
	public void onProcessError(Person item, Exception e) {
		log.error("onProcessError: {} -> {}", item, e.getMessage());
	}

}

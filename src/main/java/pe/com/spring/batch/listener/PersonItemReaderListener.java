package pe.com.spring.batch.listener;

import org.springframework.batch.core.ItemReadListener;

import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;

@Slf4j
public class PersonItemReaderListener implements ItemReadListener<Person>{

	@Override
	public void beforeRead() {
		log.info("beforeRead");
	}

	@Override
	public void afterRead(Person person) {
		log.info("afterRead: {}", person);
	}

	@Override
	public void onReadError(Exception ex) {
		log.error("onReadError: {}", ex.getMessage());
	}

}

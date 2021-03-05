package pe.com.spring.batch.listener;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import lombok.extern.slf4j.Slf4j;
import pe.com.spring.batch.model.Person;

@Slf4j
public class PersonItemWriterListener implements ItemWriteListener<Person>{
	
	@Override
	public void beforeWrite(List<? extends Person> items) {
		log.info("beforeWrite");
	}

	@Override
	public void afterWrite(List<? extends Person> items) {
		log.info("afterWrite: {}", items);
	}

	@Override
	public void onWriteError(Exception e, List<? extends Person> items) {
		log.error("onWriteError: {}", e.getMessage());
	}

}

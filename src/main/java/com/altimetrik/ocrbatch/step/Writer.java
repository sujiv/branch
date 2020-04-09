package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.repository.ApplicationDetailsRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Writer implements ItemWriter<ApplicationDetails> {

	private ApplicationDetailsRepository applicationDetailsRepository;

	public Writer(ApplicationDetailsRepository applicationDetailsRepository){
		this.applicationDetailsRepository = applicationDetailsRepository;
	}

	@Override
	public void write(List<? extends ApplicationDetails> applicationDetails) throws Exception {
		for (ApplicationDetails details : applicationDetails) {
			System.out.println("Writing the data " + details);
			applicationDetailsRepository.save(details);


		}
	}

}
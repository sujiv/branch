package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<ApplicationDetails, ApplicationDetails> {

	@Override
	public ApplicationDetails process(ApplicationDetails data) throws Exception {
//		return data.toUpperCase();
		System.out.println("Processor.process(): Some OCR Processing done ");
		return data;
	}

}

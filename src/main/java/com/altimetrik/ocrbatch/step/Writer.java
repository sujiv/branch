package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class Writer implements ItemWriter<ApplicationDetails> {

	@Override
	public void write(List<? extends ApplicationDetails> applicationDetails) throws Exception {
		for (ApplicationDetails details : applicationDetails) {
			System.out.println("Writing the data " + details);
		}
	}

}
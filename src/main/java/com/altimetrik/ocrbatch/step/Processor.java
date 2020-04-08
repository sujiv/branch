package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.service.IRS941FormProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;

public class Processor implements ItemProcessor<FileStorage, ApplicationDetails> {

	@Autowired
	private IRS941FormProcessing irs941FormProcessing;

	@Override
	public ApplicationDetails process(FileStorage data) throws Exception {
//		return data.toUpperCase();
		System.out.println("Processor.process(): Some OCR Processing done ");

//		STEP 1. PROCESSING IRS941
		ApplicationDetails appDetails = new ApplicationDetails();
		appDetails = irs941FormProcessing.processIrs941(appDetails, data);



		return appDetails;
	}

}

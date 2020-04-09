package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.service.GrossPayrollFormProcessingService;
import com.altimetrik.ocrbatch.service.IRS941FormProcessing;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<FileStorage, ApplicationDetails> {

	private FileStorageRepository fileStorageRepository;
	private IRS941FormProcessing irs941FormProcessing;
	private GrossPayrollFormProcessingService grossPayrollFormProcessingService;

	public Processor(IRS941FormProcessing irs941FormProcessing,
					 GrossPayrollFormProcessingService grossPayrollFormProcessingService,
					 FileStorageRepository fileStorageRepository) {

		this.irs941FormProcessing = irs941FormProcessing;
		this.grossPayrollFormProcessingService = grossPayrollFormProcessingService;
		this.fileStorageRepository = fileStorageRepository;
	}

	@Override
	public ApplicationDetails process(FileStorage data) throws Exception {
//		return data.toUpperCase();
		System.out.println("Processor.process(): Some OCR Processing done ");

//		STEP 1. PROCESSING IRS941
		ApplicationDetails appDetails = new ApplicationDetails();
		appDetails = irs941FormProcessing.processIrs941(appDetails, data);

//		STEP 2. PROCESSING GROSS PAYROLL
		appDetails = grossPayrollFormProcessingService.processGrossPayroll(appDetails, data);

		System.out.println(appDetails);

		//		Updating the flags
		data.setIrs941Processed(true);
		data.setGrossPayrollProcessed(true);
		fileStorageRepository.save(data);

		return appDetails;
	}

}

package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.repository.ApplicationDetailsRepository;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.service.IRS941FormProcessing;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Reader implements ItemReader<FileStorage> {

	@Autowired
	ApplicationDetailsRepository applicationDetailsRepository;

	@Autowired
	private FileStorageRepository fileStorageRepository;


	private List<FileStorage> unProcessedFiles = new ArrayList<>();

	private int count = 0;

	@Override
	public FileStorage read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

//		unprocessedApplications = applicationDetailsRepository.findAllByIsBatchProcessedFalse();
//		System.out.println("Reader.read(): unprocessedApplications list size is " + unprocessedApplications.size());
//
//		//TODO: Decide if only one record should be fetched from the DB or multiple (depending on how many times read() method is invoked)
//

		/* new things */

		unProcessedFiles = fileStorageRepository.getAllByIrs941ProcessedFalseOrHealthcareCostsProcessedFalseOrGrossPayrollProcessedFalse();

		if (count < unProcessedFiles.size()) {
			return unProcessedFiles.get(count++);
		} else {
			count = 0;
		}

		return null;
	}



}
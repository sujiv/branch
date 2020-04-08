package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.repository.ApplicationDetailsRepository;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class Reader implements ItemReader<ApplicationDetails> {

	@Autowired
	ApplicationDetailsRepository applicationDetailsRepository;

	private List<ApplicationDetails> unprocessedApplications = new ArrayList<>();

	private int count = 0;

	@Override
	public ApplicationDetails read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

//		unprocessedApplications = applicationDetailsRepository.findAllByIsBatchProcessedFalse();
		System.out.println("Reader.read(): unprocessedApplications list size is " + unprocessedApplications.size());

		//TODO: Decide if only one record should be fetched from the DB or multiple (depending on how many times read() method is invoked)

		if (count < unprocessedApplications.size()) {
			return unprocessedApplications.get(count++);
		} else {
			count = 0;
		}
		return null;
	}

}
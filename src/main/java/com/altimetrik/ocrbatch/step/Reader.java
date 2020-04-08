package com.altimetrik.ocrbatch.step;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;

public class Reader implements ItemReader<ApplicationDetails> {

	private List<ApplicationDetails> unprocessedApplications = new ArrayList<>();

	private int count = 0;

	@Override
	public ApplicationDetails read() throws Exception, UnexpectedInputException,
            ParseException, NonTransientResourceException {

		//TODO: Create ApplicationDetails repository, autowire it and get only unprocessed records
		//TODO: Decide if only one record should be fetched from the DB or multiple (depending on how many times read() method is invoked)

		if (count < unprocessedApplications.size()) {
			return unprocessedApplications.get(count++);
		} else {
			count = 0;
		}
		return null;
	}

}
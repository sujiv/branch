package com.altimetrik.ocrbatch.config;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.listener.JobCompletionListener;
import com.altimetrik.ocrbatch.repository.ApplicationDetailsRepository;
import com.altimetrik.ocrbatch.repository.FileStorageRepository;
import com.altimetrik.ocrbatch.service.GrossPayrollFormProcessingService;
import com.altimetrik.ocrbatch.service.IRS941FormProcessing;
import com.altimetrik.ocrbatch.step.Processor;
import com.altimetrik.ocrbatch.step.Reader;
import com.altimetrik.ocrbatch.step.Writer;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Configuration
public class BatchConfig {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	private FileStorageRepository fileStorageRepository;

	@Autowired
	private ApplicationDetailsRepository applicationDetailsRepository;

	@Autowired
	private IRS941FormProcessing irs941FormProcessing;
	@Autowired
	private GrossPayrollFormProcessingService grossPayrollFormProcessingService;

	@Bean
	public Job processJob() {
		return jobBuilderFactory.get("processJob")
				.incrementer(new RunIdIncrementer()).listener(listener())
				.flow(orderStep1()).end().build();
	}

	@Bean
	public Step orderStep1() {
		return stepBuilderFactory.get("orderStep1").<FileStorage, ApplicationDetails> chunk(1)
				.reader(new Reader(fileStorageRepository)).processor(new Processor(irs941FormProcessing, grossPayrollFormProcessingService, fileStorageRepository))
				.writer(new Writer(applicationDetailsRepository)).build();
	}

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}

	@Bean
	public Tesseract getTesseract () {
		Tesseract tesseract = new Tesseract();
		tesseract.setDatapath("src/main/resources/tessdata");
		tesseract.setLanguage("eng");

		return tesseract;
	}

	/*@Bean
	public JpaItemWriter getJpaItemWriter() {

	}*/

}

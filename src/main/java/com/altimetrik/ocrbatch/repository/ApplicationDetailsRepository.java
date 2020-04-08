package com.altimetrik.ocrbatch.repository;

import com.altimetrik.ocrbatch.entity.ApplicationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationDetailsRepository extends JpaRepository<ApplicationDetails, Integer> {

    List<ApplicationDetails> findAllByIsBatchProcessedFalse();
}

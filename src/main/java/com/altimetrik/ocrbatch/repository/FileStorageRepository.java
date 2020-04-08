package com.altimetrik.ocrbatch.repository;

import com.altimetrik.ocrbatch.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Integer> {

    List<FileStorage> getAllByIrs941ProcessedIsFalse();
    List<FileStorage> getAllByHealthcareCostsProcessedIsFalse();
    List<FileStorage> getAllByGrossPayrollProcessedIsFalse();

}

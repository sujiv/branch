package com.altimetrik.ocrbatch.repository;

import com.altimetrik.ocrbatch.entity.FileStorage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileStorageRepository extends JpaRepository<FileStorage, Integer> {
}

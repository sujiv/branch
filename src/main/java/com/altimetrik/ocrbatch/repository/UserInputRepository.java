package com.altimetrik.ocrbatch.repository;

import com.altimetrik.ocrbatch.entity.FileStorage;
import com.altimetrik.ocrbatch.entity.UserInput;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInputRepository extends JpaRepository<UserInput, Integer> {

    @Override
    Optional<UserInput> findById(Integer integer);
}

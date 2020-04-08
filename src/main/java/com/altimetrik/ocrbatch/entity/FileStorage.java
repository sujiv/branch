package com.altimetrik.ocrbatch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Blob;

@Entity
@Table(name = "fileStorage")
@Data
public class FileStorage {

    @Id
    Integer blobID;

    @Lob
    private Blob irs941;

    @Lob
    private Blob healthcareCosts;

    @Lob
    private Blob grossPayroll;
}
package com.altimetrik.ocrbatch.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
@Data
public class FileStorage {

    @Id
    Integer blobID;

    @Lob
    private byte[] irs941;

    @Lob
    private byte[] healthcareCosts;

    @Lob
    private byte[] grossPayroll;

    private Boolean irs941Processed = false;

    private Boolean healthcareCostsProcessed = false;

    private Boolean grossPayrollProcessed = false;


}

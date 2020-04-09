package com.altimetrik.ocrbatch.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
//@Table(name = "file_storage")
public class FileStorage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer blobID;

    Integer userInputId;

    @Lob
    private byte[] irs941;

    @Lob
    private byte[] healthcareCosts;

    @Lob
    private byte[] grossPayroll;

    private Boolean irs941Processed = false;

    private Boolean healthcareCostsProcessed = false;

    private Boolean grossPayrollProcessed = false;

    private Timestamp createdTs;

    public FileStorage() {
    }

    public FileStorage(byte[] irs941, byte[] healthcareCosts, byte[] grossPayroll) {
        this.irs941 = irs941;
        this.healthcareCosts = healthcareCosts;
        this.grossPayroll = grossPayroll;
    }


}

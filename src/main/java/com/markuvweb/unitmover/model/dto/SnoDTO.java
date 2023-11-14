package com.markuvweb.unitmover.model.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SnoDTO {
    private long id;
    private String sno ;
    private String model;
    private String wc;
    private String nextWc;
    private String cdt;
    private String udt;
}

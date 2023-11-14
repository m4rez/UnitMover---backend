package com.markuvweb.unitmover.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name= "SNO")
public class SnoEntity implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "Id")
    private long id;

    @Column(name = "Sno")
    private String sno;

    @Column(name = "Model")
    private String model;

    @Column(name = "Wc")
    private String wc;

    @Column(name = "nextwc")
    private String nextWc;

    @Column(name = "Cdt")
    private String cdt;

    @Column(name = "Udt")
    private String udt;

}


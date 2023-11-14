package com.markuvweb.unitmover.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "UNIT_LOG")
public class UnitLogEntity implements Serializable {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "snoid")
    private long snoId;

    @Column(name = "Sno")
    private String sno;

    @Column(name = "pdline")
    private String pdLine;

    @Column(name = "Wc")
    private String wc;

    @Column(name = "ispass")
    private int isPass;

    @Column(name = "inputtype")
    private String inputType;

    @Column(name = "Editor")
    private String editor;

    @Column(name = "Cdt")
    private String cdt;

    @Column(name = "Udt")
    private String udt;
}
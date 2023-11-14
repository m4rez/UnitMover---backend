package com.markuvweb.unitmover.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name="SFC")
public class StationsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="Model")
    private String model;

    @Column(name="ftype")
    private String ftype;

    @Column(name="Flow")
    private String flow;

    @Column(name="Editor")
    private String editor;

    @Column(name="Cdt")
    private String cdt;

    @Column(name="Udt")
    private String udt;
}
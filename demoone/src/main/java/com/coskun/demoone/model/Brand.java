package com.coskun.demoone.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "brand")
@Data
public class Brand extends BaseEntity{
    @Id
    @SequenceGenerator(name = "user_seq_gen",sequenceName = "user_gen",initialValue = 100,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "user_seq_gen")
    @Column(name = "Id",length = 100)
    private Long   id;

    @Column(name = "Name",length = 100)
    private String name;






}

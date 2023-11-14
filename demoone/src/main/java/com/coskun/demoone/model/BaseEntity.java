package com.coskun.demoone.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity implements Serializable {

    private Date createdAt;
    private String createdBy ;
    private Date updateAt ;
    private String updatedBy ;

}

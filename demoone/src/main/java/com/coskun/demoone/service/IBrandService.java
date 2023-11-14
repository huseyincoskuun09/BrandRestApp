package com.coskun.demoone.service;

import com.coskun.demoone.dto.DbRequestItem;
import com.coskun.demoone.dto.DbResponseItem;


import java.util.List;

public interface IBrandService {

    DbResponseItem createBrand(DbRequestItem brand);
    List<DbRequestItem> getBrands();
    DbRequestItem getBrand(Long id);
    DbResponseItem updateBrand(Long id , DbRequestItem dbRequestItem);
    Boolean deleteBrand(Long id);

   // List<Brand> add();
}

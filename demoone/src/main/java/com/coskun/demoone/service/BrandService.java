package com.coskun.demoone.service;

import com.coskun.demoone.dto.DbRequestItem;
import com.coskun.demoone.dto.DbResponseItem;
import com.coskun.demoone.exception.UserNotFound;
import com.coskun.demoone.model.*;
import com.coskun.demoone.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class BrandService implements IBrandService{
    private final DataRepository dataRepository;
    private final ModelMapper modelMapper;

    public BrandService(DataRepository dataRepository,ModelMapper modelMapper){
        this.dataRepository = dataRepository;
        this.modelMapper = modelMapper;
    }



    @Override
    public DbResponseItem createBrand(DbRequestItem dbRequestItem) {
        Brand brand = modelMapper.map(dbRequestItem,Brand.class);
        brand.setCreatedAt(new Date());
        brand.setCreatedBy("Admin");
        return modelMapper.map(dataRepository.save(brand),DbResponseItem.class);
    }

    @Override
    public List<DbRequestItem> getBrands() {
        List<Brand> brands = dataRepository.findAll();
        List<DbRequestItem> dbRequestItems = brands.stream().map(brand ->modelMapper.map(brand,DbRequestItem.class)).collect(Collectors.toList());  //
        return dbRequestItems;
    }

    @Override
    public DbRequestItem getBrand(Long id) {
     Optional<Brand> brand =  dataRepository.findById(id);
     if (brand.isPresent()){
         return modelMapper.map(brand.get(),DbRequestItem.class);
     }

         throw new RuntimeException("Kullanıcı Bulunamadı");


    }

    @Override
    public DbResponseItem updateBrand(Long id, DbRequestItem dbRequestItem) {

        Optional<Brand> final_brand =  dataRepository.findById(id);
        if (final_brand.isPresent()){
           final_brand.get().setName(dbRequestItem.getName());
           final_brand.get().setUpdateAt(new Date());
           final_brand.get().setUpdatedBy("Baha");

           return modelMapper.map(dataRepository.save(final_brand.get()),DbResponseItem.class);
        }
        return null;
    }

    @Override
    public Boolean deleteBrand(Long id) {

        Optional<Brand> brand =  dataRepository.findById(id);
        if (brand.isPresent()){
            dataRepository.deleteById(id);
            return true ;
        }
        return false;
    }


}
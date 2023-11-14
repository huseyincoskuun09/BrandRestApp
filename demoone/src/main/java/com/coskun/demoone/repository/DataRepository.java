package com.coskun.demoone.repository;

import com.coskun.demoone.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Brand,Long> {
    // List<DbItem> save();
    //DbItem findByName(String name) ;

}

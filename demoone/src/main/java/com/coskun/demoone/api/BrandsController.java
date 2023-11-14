package com.coskun.demoone.api;

import com.coskun.demoone.dto.DbRequestItem;
import com.coskun.demoone.dto.DbResponseItem;
import com.coskun.demoone.model.Brand;
import com.coskun.demoone.service.IBrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//ResponseEntity neden kullanılıyor sorulacak

@RestController
@RequestMapping("/brand")
public class BrandsController {

    private final IBrandService iBrandService;

    public BrandsController(IBrandService iBrandService){

        this.iBrandService = iBrandService;
    }
    @PostMapping("/create")
    public ResponseEntity<DbResponseItem> createBrand(@RequestBody DbRequestItem brand){
        DbResponseItem resultBrand = iBrandService.createBrand(brand);
        return ResponseEntity.ok(resultBrand);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<DbRequestItem>> getBrands(){
       List<DbRequestItem>  brands = iBrandService.getBrands();
       return ResponseEntity.ok(brands) ;

    }
    @GetMapping("/getById/{id}")
    public ResponseEntity<DbRequestItem> getBrand(@PathVariable("id") Long id){
        DbRequestItem dbRequestItem = iBrandService.getBrand(id);

        return ResponseEntity.ok(dbRequestItem);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DbResponseItem> updataBrand(@PathVariable("id") Long id,@RequestBody DbRequestItem dbRequestItem){

        DbResponseItem final_brand = iBrandService.updateBrand(id,dbRequestItem);

        return ResponseEntity.ok(final_brand);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteBrand(@PathVariable("id") Long id){
        Boolean status = iBrandService.deleteBrand(id);
        return ResponseEntity.ok(status);
    }




}

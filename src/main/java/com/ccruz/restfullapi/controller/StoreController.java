package com.ccruz.restfullapi.controller;

import com.ccruz.restfullapi.entity.Store;
import com.ccruz.restfullapi.error.StoreNotFoundException;
import com.ccruz.restfullapi.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StoreController {
    @Autowired
    StoreService storeService;

    @GetMapping("/stores")
    public List<Store> findAllStores() {
        return storeService.findAllStores();
    }

    @GetMapping("/store/{name}")
    public Optional<Store> findByName(@PathVariable String name) {
        return storeService.findByName(name);
    }

    @GetMapping("/store/ignore_case/{name}")
    public Optional<Store> findByNameIgnoreCase(@PathVariable String name) {
        return storeService.findByNameIgnoreCase(name);
    }

    @GetMapping("/store/by_id/{id}")
    public Store findById(@PathVariable Long id) throws StoreNotFoundException {
        return storeService.findById(id);
    }

    @PostMapping("/store")
    public Store saveStore(@Valid @RequestBody Store store) {
        return storeService.saveStore(store);
    }

    @PutMapping("/store/{id}")
    public Store updateStore(@PathVariable Long id, @RequestBody Store store) {
        return storeService.updateStore(id, store);
    }

    @DeleteMapping("/store/{id}")
    public void deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
    }
}

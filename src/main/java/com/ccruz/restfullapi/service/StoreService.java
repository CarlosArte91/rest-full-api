package com.ccruz.restfullapi.service;

import com.ccruz.restfullapi.entity.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    List<Store> findAllStores();
    Store saveStore(Store store);
    Store updateStore(Long id, Store store);
    void deleteStore(Long id);
    Optional<Store> findStoreByName(String name);
    Optional<Store> findByName(String name);
    Optional<Store> findByNameIgnoreCase(String name);
}

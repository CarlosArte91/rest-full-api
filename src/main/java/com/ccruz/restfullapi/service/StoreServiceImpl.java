package com.ccruz.restfullapi.service;

import com.ccruz.restfullapi.entity.Store;
import com.ccruz.restfullapi.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    StoreRepository storeRepository;

    @Override
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    @Override
    public Store saveStore(Store store) {
        return storeRepository.save(store);
    }

    @Override
    public Store updateStore(Long id, Store store) {
        Store foundStore = storeRepository.findById(id).get();

        if (Objects.nonNull(store.getCode()) && !"".equalsIgnoreCase(store.getCode())) {
            foundStore.setCode(store.getCode());
        }

        if (Objects.nonNull(store.getName()) && !"".equalsIgnoreCase(store.getName())) {
            foundStore.setName(store.getName());
        }

        if (Objects.nonNull(store.getFloor()) && !"".equalsIgnoreCase(store.getFloor())) {
            foundStore.setFloor(store.getFloor());
        }

        return storeRepository.save(foundStore);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    @Override
    public Optional<Store> findStoreByName(String name) {
        return storeRepository.findStoreByNameWithJPQL(name);
    }

    @Override
    public Optional<Store> findByName(String name) {
        return storeRepository.findByName(name);
    }

    @Override
    public Optional<Store> findByNameIgnoreCase(String name) {
        return storeRepository.findByNameIgnoreCase(name);
    }
}

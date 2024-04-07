package com.ccruz.restfullapi.repository;

import com.ccruz.restfullapi.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {
    @Query("SELECT s FROM Store s WHERE s.name = :name")
    Optional<Store> findStoreByNameWithJPQL(String name);

    Optional<Store> findByName(String name);

    Optional<Store> findByNameIgnoreCase(String name);
}

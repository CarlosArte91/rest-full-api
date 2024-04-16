package com.ccruz.restfullapi.repository;

import com.ccruz.restfullapi.entity.Store;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StoreRepositoryTest {
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    TestEntityManager testEntityManager;

    @BeforeEach
    void setUp() {
        Store store =
                Store.builder()
                        .code("code-04")
                        .name("name-04")
                        .floor("floor-04")
                        .build();

        testEntityManager.persist(store);
    }

    @Test
    public void findStoreByNameIgnoreCaseFound() {
        Optional<Store> store = storeRepository.findByNameIgnoreCase("name-04");
        assertEquals(store.get().getName(), "name-04");
    }

    @Test
    public void findStoreByNameIgnoreCaseNotFound() {
        Optional<Store> store = storeRepository.findByNameIgnoreCase("name-xxx");
        assertEquals(store, Optional.empty());
    }
}

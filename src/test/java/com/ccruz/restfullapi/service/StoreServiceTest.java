package com.ccruz.restfullapi.service;

import com.ccruz.restfullapi.entity.Store;
import com.ccruz.restfullapi.repository.StoreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StoreServiceTest {
    @Autowired
    private StoreService storeService;

    @MockBean
    private StoreRepository storeRepository;

    @BeforeEach
    void setUp() {
        Store store = Store.builder()
                .id(1L)
                .code("code_05")
                .name("name_05")
                .floor("floor_05")
                .build();

        Mockito.when(storeRepository.findByNameIgnoreCase("name_05")).thenReturn(Optional.of(store));
    }

    @Test
    @DisplayName("Method test to obtain a store by its name")
    public void findByNameIgnoreCase() {
        String storeName = "name_05";
        Store store = storeService.findByNameIgnoreCase(storeName).get();
        assertEquals(storeName, store.getName());

        System.out.println(store);
    }
}
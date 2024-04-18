package com.ccruz.restfullapi.controller;

import com.ccruz.restfullapi.entity.Store;
import com.ccruz.restfullapi.service.StoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StoreController.class)
class StoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StoreService storeService;

    private Store store;

    @BeforeEach
    void setUp() {
        store = Store.builder()
                .id(1L)
                .code("code-001")
                .name("name-001")
                .floor("floor-001")
                .build();
    }

    @Test
    public void saveStore() throws Exception {
        Store postStore = Store.builder()
                .code("code-001")
                .name("name-001")
                .floor("floor-001")
                .build();

        Mockito.when(storeService.saveStore(postStore)).thenReturn(store);

        String jsonContent = "{\n   \"code\": \"code-001\",\n   \"name\": \"name-001\",\n   \"floor\": \"floor-001\"}";

        mockMvc.perform(post("/store").contentType(MediaType.APPLICATION_JSON).content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void findById() throws Exception {
        Mockito.when(storeService.findById(1L)).thenReturn(store);

        mockMvc.perform(get("/store/by_id/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(store.getName()));
    }
}
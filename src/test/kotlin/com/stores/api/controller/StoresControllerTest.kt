package com.stores.api.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.service.StoresService
import com.stores.api.utils.StoresFaker
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@WebMvcTest(controllers = [StoresController::class])
class StoresControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @MockBean
    private lateinit var storesService: StoresService

    private val id = Math.random().toLong()

    @Test
    fun `Given valid url, when GET store list is called, then returns 200 `() {
        val storeList = listOf(
            StoresFaker.fakeStore(),
            StoresFaker.fakeStore(),
            StoresFaker.fakeStore(),
            StoresFaker.fakeStore()
        )
        Mockito.`when`(storesService.getAllStores()).doReturn(storeList)

        mockMvc.perform(get("/api/v1/stores/get")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$").exists())
            .andExpect(jsonPath("$.[*].id").isNotEmpty)
    }

    @Test
    fun `Given valid url, when GET store by id is called, then returns 200 `() {
        val store = StoresFaker.fakeStore().copy(id = id)

        Mockito.`when`(storesService.getStoreById(id)).doReturn(store)

        mockMvc.perform(get("/api/v1/stores/get/{id}", id)
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(id))
    }

    @Test
    fun `Given valid url, when POST store is called, then returns 200 `() {
        val store = StoresFaker.fakeStore().copy(id = id)

        Mockito.`when`(storesService.createStore(store)).doReturn(store)

        mockMvc.perform(
            MockMvcRequestBuilders.post("/api/v1/stores/save")
            .content(objectMapper.writeValueAsString(store))
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value("Carrus24h"))
            .andExpect(jsonPath("$.country").value("ES"))
            .andExpect(jsonPath("$.city").value("Elche"))
            .andExpect(jsonPath("$.address").value("C/ Illice 21"))
            .andExpect(jsonPath("$.status").value(StoreStatus.OPEN.name))
            .andExpect(jsonPath("$.type").value(StoreType.MEDIUM_CAP.name))
    }
}
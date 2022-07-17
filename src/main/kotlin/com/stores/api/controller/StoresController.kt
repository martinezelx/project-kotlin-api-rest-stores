package com.stores.api.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.stores.api.controller.model.StoreDto
import com.stores.api.service.StoresService
import com.stores.api.service.model.Store

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@RestController
@RequestMapping("/api/v1/stores")
class StoresController(val storesService: StoresService) {

    @GetMapping("/get")
    fun getAllStores(): List<StoreDto> {
        return storesService.getAllStores().map {
            StoreDto.from(it)
        }
    }

    @GetMapping("/get/{id}")
    fun getStoreById(@PathVariable("id") storeId: Long): StoreDto {
        return StoreDto.from(storesService.getStoreById(storeId))
    }

    @PostMapping("/save")
    fun createStore(@RequestBody storeDto: StoreDto): StoreDto {
        return StoreDto.from(storesService.createStore(Store.from(storeDto)))
    }

    @PutMapping("/update/{id}")
    fun updateStoreById(@PathVariable("id") storeId: Long, @RequestBody storeDto: StoreDto): StoreDto {
        return StoreDto.from(storesService.updateStoreById(storeId, Store.from(storeDto)))
    }

    @DeleteMapping("/delete/{id}")
    fun deleteStoreById(@PathVariable("id") storeId: Long): StoreDto {
        return StoreDto.from(storesService.deleteStoreById(storeId))
    }
}
package com.stores.api.service

import com.stores.api.repository.StoresRepository
import com.stores.api.repository.model.StoreEntity
import com.stores.api.service.model.Store
import org.springframework.stereotype.Service

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@Service
class StoresService(val storesRepository: StoresRepository) {

    fun getAllStores(): List<Store> {
        return storesRepository.findAll().map {
            Store.from(it)
        }
    }

    fun getStoreById(storeId: Long): Store {
        return storesRepository.findById(storeId).orElse(null)?.let {
            Store.from(it)
        } ?: throw Exception(String.format("Not found store with id %s",storeId))
    }

    fun createStore(store: Store): Store {
        return Store.from(storesRepository.save(StoreEntity.from(store)))
    }

    fun updateStoreById(storeId: Long, store: Store): Store {
        return storesRepository.findById(storeId).orElse(null)?.let {
            val updatedStoreData : StoreEntity = it.copy(
                name = store.name,
                country = store.country,
                city = store.city,
                address = store.address,
                status = store.status,
                type = store.type
            )
            Store.from(storesRepository.save(updatedStoreData))
        } ?: throw Exception(String.format("Not found store with id %s",storeId))
    }

    fun deleteStoreById(storeId: Long): Store {
        return storesRepository.findById(storeId).orElse(null)?.let {
            storesRepository.delete(it)
            Store.from(it)
        } ?: throw Exception(String.format("Not found store with id %s",storeId))
    }

}
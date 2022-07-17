package com.stores.api.service.model

import com.stores.api.controller.model.StoreDto
import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.repository.model.StoreEntity

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
data class Store(
    val id: Long,
    val name: String,
    val country: String,
    val city: String,
    val address: String,
    val status: StoreStatus?,
    val type: StoreType?
) {
    companion object ModelMapper {
        fun from(storeEntity: StoreEntity): Store {
            return Store(
                id = storeEntity.id,
                name = storeEntity.name,
                country = storeEntity.country,
                city = storeEntity.city,
                address = storeEntity.address,
                status = storeEntity.status,
                type = storeEntity.type
            )
        }

        fun from(storeDto: StoreDto): Store {
            return Store(
                id = storeDto.id,
                name = storeDto.name,
                country = storeDto.country,
                city = storeDto.city,
                address = storeDto.address,
                status = storeDto.status,
                type = storeDto.type
            )
        }
    }
}
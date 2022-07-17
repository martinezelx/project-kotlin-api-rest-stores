package com.stores.api.controller.model

import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.service.model.Store

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
data class StoreDto(
    val id: Long,
    val name: String,
    val country: String,
    val city: String,
    val address: String,
    val status: StoreStatus?,
    val type: StoreType?
) {
    companion object ModelMapper {
        fun from(store: Store): StoreDto {
            return StoreDto(
                id = store.id,
                name = store.name,
                country = store.country,
                city = store.city,
                address = store.address,
                status = store.status,
                type = store.type
            )
        }
    }
}
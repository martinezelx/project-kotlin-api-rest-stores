package com.stores.api.utils

import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.repository.model.StoreEntity
import com.stores.api.service.model.Store

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
class StoresFaker {
    companion object {

        private val id = Math.random().toLong()

        fun fakeStore(): Store {
            return Store(
                id = id,
                name = "Carrus24h",
                country = "ES",
                city = "Elche",
                address = "C/ Illice 21",
                status = StoreStatus.OPEN,
                type = StoreType.MEDIUM_CAP
            )
        }

        fun fakeStoreEntity(): StoreEntity {
            return StoreEntity(
                id = id,
                name = "Carrus24h",
                country = "ES",
                city = "Elche",
                address = "C/ Illice 21",
                status = StoreStatus.OPEN,
                type = StoreType.MEDIUM_CAP
            )
        }

        fun fakeUpdatedStore(): Store {
            return Store(
                id = id,
                name = "NewCarrus24h",
                country = "ES",
                city = "Alicante",
                address = "C/ Paseo 10",
                status = StoreStatus.CLOSE,
                type = StoreType.HIGH_CAP
            )
        }

        fun fakeUpdatedStoreEntity(): StoreEntity {
            return StoreEntity(
                id = id,
                name = "NewCarrus24h",
                country = "ES",
                city = "Alicante",
                address = "C/ Paseo 10",
                status = StoreStatus.CLOSE,
                type = StoreType.HIGH_CAP
            )
        }
    }
}
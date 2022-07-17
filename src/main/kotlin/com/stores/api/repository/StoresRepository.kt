package com.stores.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.stores.api.repository.model.StoreEntity

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@Repository
interface StoresRepository : JpaRepository<StoreEntity, Long> {
}
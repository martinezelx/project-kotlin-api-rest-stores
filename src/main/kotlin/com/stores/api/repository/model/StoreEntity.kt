package com.stores.api.repository.model

import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.service.model.Store
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@Entity
@Table(name = "stores")
data class StoreEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name", nullable = false)
    val name: String = "",
    @Column(name = "country", nullable = false)
    val country: String = "",
    @Column(name = "city", nullable = false)
    val city: String = "",
    @Column(name = "address", nullable = false)
    val address: String = "",
    @Column(name = "status", nullable = true)
    val status: StoreStatus? = null,
    @Column(name = "type", nullable = true)
    val type: StoreType? = null
) {
    companion object ModelMapper {
        fun from(store: Store): StoreEntity {
            return StoreEntity(
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
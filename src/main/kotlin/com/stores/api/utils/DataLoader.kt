package com.stores.api.utils

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import com.stores.api.enums.StoreStatus
import com.stores.api.enums.StoreType
import com.stores.api.repository.StoresRepository
import com.stores.api.repository.model.StoreEntity

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
@Component
class DataLoader {

    @Bean
    fun storesDataLoader(storesRepository: StoresRepository): CommandLineRunner? {
        return CommandLineRunner {
            storesRepository.save(StoreEntity(1L, "Open24h","ES","Alicante","C/ False 123",
                StoreStatus.OPEN,StoreType.MEDIUM_CAP))
            storesRepository.save(StoreEntity(2L, "Milk&More","AR","Buenos Aires","C/ Messi 10",
                StoreStatus.OPEN,StoreType.MEDIUM_CAP))
            storesRepository.save(StoreEntity(3L, "CheEat","UY","Montevideo","C/ Cavani 21",
                StoreStatus.OPEN,StoreType.MEDIUM_CAP))
        }
    }
}
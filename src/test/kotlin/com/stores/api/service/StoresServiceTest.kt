package com.stores.api.service

import com.stores.api.repository.StoresRepository
import com.stores.api.utils.StoresFaker
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import java.util.*

/**
 * @author Luis Martinez
 * @since 0.0.1
 */
class StoresServiceTest {

    private val storesRepository: StoresRepository = mock { }
    private val classUnderTest = StoresService(storesRepository)
    private val id = Math.random().toLong()

    @Test
    fun `given stores, when list of stores are requested, then all stores are returned`() {
        val storeList = listOf(
            StoresFaker.fakeStoreEntity(),
            StoresFaker.fakeStoreEntity(),
            StoresFaker.fakeStoreEntity(),
            StoresFaker.fakeStoreEntity()
        )

        Mockito.`when`(storesRepository.findAll()).doReturn(storeList)
        assertEquals(4, classUnderTest.getAllStores().size)
    }

    @Test
    fun `given stores, when store is requested by id, then one store is returned`() {
        Mockito.`when`(storesRepository.findById(id)).doReturn(
            Optional.of(StoresFaker.fakeStoreEntity().copy(id = id))
        )
        val result = classUnderTest.getStoreById(id)
        assertEquals(id, result.id)
    }

    @Test
    fun `given stores, when store is requested by invalid id, throws exception`() {
        val invalidId = Math.random().toLong()
        assertThrows<Exception> { classUnderTest.getStoreById(invalidId) }
    }

    @Test
    fun `given new store data, when store is created, then returns the new store data`() {
        Mockito.`when`(storesRepository.save(StoresFaker.fakeStoreEntity())).doReturn(
            StoresFaker.fakeStoreEntity()
        )

        val result = classUnderTest.createStore(StoresFaker.fakeStore())
        assertEquals("Carrus24h", result.name)
        assertEquals("ES", result.country)
    }

    @Test
    fun `given updated store data, when store is updated by valid id, then it returns the updated store data`() {
        Mockito.`when`(storesRepository.findById(id)).doReturn(
            Optional.of(StoresFaker.fakeStoreEntity().copy(id = id))
        )
        Mockito.`when`(storesRepository.save(StoresFaker.fakeUpdatedStoreEntity().copy(id = id))).doReturn(
            StoresFaker.fakeUpdatedStoreEntity().copy(id = id)
        )

        val result = classUnderTest.updateStoreById(id, StoresFaker.fakeUpdatedStore().copy(id = id))
        assertEquals("NewCarrus24h", result.name)
        assertEquals("Alicante", result.city)
    }

    @Test
    fun `given stores, when store is deleted by id, then it returns the deleted store data`() {
        Mockito.`when`(storesRepository.findById(id)).doReturn(
            Optional.of(StoresFaker.fakeStoreEntity().copy(id = id))
        )
        Mockito.doNothing().`when`(storesRepository).delete(StoresFaker.fakeStoreEntity().copy(id = id))

        val result = classUnderTest.deleteStoreById(id)
        assertEquals(id, result.id)
    }
}
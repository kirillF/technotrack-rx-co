package coroutine

import common.Person
import common.mapper.Mapper
import common.network.Response
import coroutine.local.PersonStorage
import couroutine.network.NetworkService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.future.await
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class PersonRepository(private val networkService: NetworkService,
                       private val personStorage: PersonStorage,
                       private val mapper: Mapper<Response, Person>,
                       private val networkContext: CoroutineContext,
                       private val dbContext: CoroutineContext) {

    suspend fun getPerson(id: Int): Person {
        println(Thread.currentThread())
        val response = CoroutineScope(networkContext).async { getPersonRequest(1) }.await()
        val person = mapper.map(response)
        CoroutineScope(dbContext).launch { personStorage.save(person) }.join()
        return person
    }

    private suspend fun getPersonRequest(id: Int): Response {
        return networkService.getPerson(id).await()
    }
}
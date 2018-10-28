package coroutine


import common.mapper.PersonMapper
import coroutine.local.PersonStorage
import couroutine.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking

fun main() {
    val repo = PersonRepository(NetworkService(), PersonStorage(), PersonMapper(), Dispatchers.IO, newSingleThreadContext("dbContext"))
    runBlocking {
        println(repo.getPerson(1))
    }
}


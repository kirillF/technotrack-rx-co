package callbacks

import common.Person
import callbacks.exectutors.Schedulers
import callbacks.local.PersonStorage
import callbacks.network.NetworkService
import common.mapper.Mapper
import common.network.Response

class PersonRepository(
    private val networkService: NetworkService,
    private val personStorage: PersonStorage,
    private val mapper: Mapper<Response, Person>,
    private val schedulers: Schedulers) {

    fun getPerson(id: Int, success: (Person) -> Unit, failure: (Exception) -> Unit) {
        println(Thread.currentThread())
        schedulers.networkExecutor.execute(Runnable {
            networkService.getPerson(id, { response ->
                val person = mapper.map(response)
                schedulers.dbExecutor.execute(Runnable {
                    personStorage.save(person, {
                        success(person)
                    }, { exception -> failure(exception) })
                })
            }, { exception -> failure(exception) })
        })
    }

}
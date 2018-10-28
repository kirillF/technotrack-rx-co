package rx

import common.Person
import common.mapper.Mapper
import common.network.Response
import io.reactivex.Flowable
import io.reactivex.Scheduler
import rx.local.PersonStorage
import rx.network.NetworkService

class PersonRepository(private val networkService: NetworkService,
                       private val personStorage: PersonStorage,
                       private val mapper: Mapper<Response, Person>,
                       private val networkScheduler: Scheduler,
                       private val dbScheduler: Scheduler) {

    fun getPerson(id: Int): Flowable<Person> {
        println(Thread.currentThread())
        return networkService.getPerson(id)
            .map { mapper.map(it) }
            .subscribeOn(networkScheduler)
            .flatMap { personStorage.save(it)
                .subscribeOn(dbScheduler)}
    }

}
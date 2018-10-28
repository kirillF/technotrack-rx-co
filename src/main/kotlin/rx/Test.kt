package rx


import common.mapper.PersonMapper
import io.reactivex.schedulers.Schedulers
import rx.local.PersonStorage
import rx.network.NetworkService

fun main() {
    val repo = PersonRepository(NetworkService(), PersonStorage(), PersonMapper(), Schedulers.io(), Schedulers.single())
    repo.getPerson(1).blockingSubscribe({
        println(it)
    },
    {
        println(it)
    })
}


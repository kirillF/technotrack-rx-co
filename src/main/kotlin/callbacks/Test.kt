package callbacks

import callbacks.exectutors.Schedulers
import callbacks.local.PersonStorage
import callbacks.network.NetworkService
import common.mapper.PersonMapper

fun main() {
    val repo = PersonRepository(NetworkService(), PersonStorage(), PersonMapper(), Schedulers())
    repo.getPerson(1, {
        println(it)
    }, {
        println(it)
    })
}


package rx.network

import common.network.Response
import io.reactivex.Flowable
import java.lang.IllegalArgumentException

class NetworkService {

    fun getPerson(id: Int): Flowable<Response> {
        return Flowable.fromCallable {
            println(Thread.currentThread())
            if (id >= 0) {
                println("Retrieved from network")
                Response(200, responseJson)
            } else {
                throw IllegalArgumentException("Invalid id: $id")
            }
        }
    }

    companion object {
        const val responseJson = "{\n" +
                "   \"id\":1,\n" +
                "   \"name\":\"John\",\n" +
                "   \"surname\":\"Smith\",\n" +
                "   \"avatar_url\":\"https://sm.ign.com/ign_me/news/b/bethesda-c/bethesda-confirms-fallout-4-preloading_gj5r.png\",\n" +
                "   \"gender\":\"male\"\n" +
                "}"
    }

}
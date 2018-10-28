package callbacks.network

import common.network.Response
import java.lang.IllegalArgumentException

class NetworkService {

    fun getPerson(id: Int, success: (Response) -> Unit, failure: (Exception) -> Unit) {
        println(Thread.currentThread())
        if (id >= 0) {
            println("Retrieved from network")
            success(Response(200, responseJson))
        } else {
            failure(IllegalArgumentException("Invalid id: $id"))
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
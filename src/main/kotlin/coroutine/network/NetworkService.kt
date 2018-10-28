package couroutine.network

import common.network.Response
import java.util.concurrent.CompletableFuture

class NetworkService {

    fun getPerson(id: Int): CompletableFuture<Response> {
        println(Thread.currentThread())
        if (id >= 0) {
            println("Retrieved from network")
            return CompletableFuture.completedFuture(Response(200, responseJson))
        } else {
            throw Throwable("Invalid id: $id")
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
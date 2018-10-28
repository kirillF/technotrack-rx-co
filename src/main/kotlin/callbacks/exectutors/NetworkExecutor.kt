package callbacks.exectutors

import java.util.concurrent.Executors

class NetworkExecutor: Executor {
    private val executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    override fun execute(runnable: Runnable) {
        executor.execute(runnable)
    }

}
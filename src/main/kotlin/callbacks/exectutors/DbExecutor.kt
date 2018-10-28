package callbacks.exectutors

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class DbExecutor: Executor {
    private val executor = Executors.newCachedThreadPool()

    override fun execute(runnable: Runnable) {
        executor.execute(runnable)
    }

}
package callbacks.exectutors

class Schedulers(val networkExecutor: Executor = NetworkExecutor(),
                 val dbExecutor:Executor = DbExecutor()) {
}
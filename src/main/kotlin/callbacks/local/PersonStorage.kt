package callbacks.local

import common.Person
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class PersonStorage {
    private val persons = mutableMapOf<Int, Person>()
    private val lock = ReentrantLock()

    fun save(person: Person, success: (Int) -> Unit, failure: (Exception) -> Unit) {
        println(Thread.currentThread())
        lock.withLock {
            if (!persons.containsKey(person.id)) {
                persons[person.id] = person
                println("Saved to storage")
                success(person.id)
            } else {
                failure(IllegalArgumentException("Person with id ${person.id} already exists"))
            }
        }
    }

}
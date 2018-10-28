package coroutine.local

import common.Person
import java.lang.IllegalArgumentException
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class PersonStorage {
    private val persons = mutableMapOf<Int, Person>()
    private val lock = ReentrantLock()

    fun save(person: Person) {
            println(Thread.currentThread())
            lock.withLock {
                if (!persons.containsKey(person.id)) {
                    persons[person.id] = person
                    println("Saved to storage")
                } else {
                    throw IllegalArgumentException("Person with id ${person.id} already exists")
                }
            }
    }

}
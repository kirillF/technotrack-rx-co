package common.mapper

import common.Gender
import common.Person
import common.network.Response
import org.json.JSONObject

class PersonMapper: Mapper<Response, Person> {

    override fun map(input: Response): Person {
        val jsonObject = JSONObject(input.responseBody)
        val id = jsonObject.getInt("id")
        val name = jsonObject.getString("name")
        val surname = jsonObject.getString("surname")
        val avatarUrl = jsonObject.getString("avatar_url")
        val gender = when(jsonObject["gender"]) {
            "male" -> Gender.Male
            else -> Gender.Female
        }
        return Person(id, name, surname, avatarUrl, gender)
    }
}
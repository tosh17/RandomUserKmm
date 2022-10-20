package ru.thstdio.firstapp2.data

import ru.thstdio.firstapp2.domain.uistate.view.UserItemViewState
import kotlin.math.log
import kotlin.random.Random

object UiStub {


    val userItems = List(100){
        Generator.generateUserViewState()
    }
}

private object Generator {
    val random = Random(42)

    private fun generateId(): Int {
        return random.nextInt(100)
    }

    private fun generateThumbUrl(id: Int): String {
        return "https://randomuser.me/api/portraits/thumb/men/$id.jpg"
    }


    fun generateUserViewState(): UserItemViewState {
        val id = generateId()
        return UserItemViewState(
            id = id.toString(),
            name = "User id #$id",
            logo = generateThumbUrl(id)
        )
    }
}
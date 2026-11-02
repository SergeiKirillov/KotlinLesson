import java.util.Locale

fun main() {
    val greeting: String = "Hello Kotlin"
    println(greeting)

    for (i in 0 until (10)) {
        println("for until $i")
    }

    for (i in 10 ..< 20) {
        println("for 10 until $i < 20 ")
    }

    for (i in 19 downTo 0) {
        println("for downTo $i")
    }

    val play = Player("Игорь")
    play.score = 3
    println("Имя ${play.name} - ${play.score}")
    play.score = -2
    println("Имя ${play.name} - ${play.score}")
}

class Player(name: String) {
    val name = name
        get() = field.uppercase(Locale.getDefault())

    var score: Int = 0
        set(value) {
            field =
                    if (value >= 0) {
                        value
                    } else {
                        0
                    }
        }
    
    
}

import kotlin.random.Random

interface DiceRoller {
    fun rollDice(): Int = Random.nextInt(0, 6)
}

class Players : DiceRoller, Moveable() {}

abstract class Moveable() {
    protected var x: Int = 0
    protected var y: Int = 0

    fun sleep() {
        println("abstract sleep")
    }

    open fun move(x: Int, y: Int) {
        this.x = x
        this.y = y
    }
}

open class ActivePlayer(val name: String) : Moveable(), DiceRoller {

    open fun printName() {
        println(this.name)
    }
}

class ConfusedPlayer(name: String) : ActivePlayer(name) {
    override fun move(x: Int, y: Int) {
        this.x = y
        this.y = x
    }
    fun myPrint() {
        println("class-> ${x}, ${y}")
    }
}

data class User(val username: String, private val password: String) {
    fun String.hidePassword() = "*".repeat(password.length)
}

fun main() {
    println("Урок 2. Интерфейсы")
    val pl1 = Players().rollDice()
    println("Кости $pl1")
    val pl2 = Players()
    pl2.move(2, 3)
    pl2.sleep()

    val pl3 = ConfusedPlayer("Наследование")
    pl3.printName()
    val x = 10
    val y = 20
    println("$x , $y")
    pl3.move(x, y)
    pl3.myPrint()

    val us1 = User("user", "password")
    println("${us1.username}")
    println("${us1.hidePassword()}")

   

}

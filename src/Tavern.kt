import java.io.File
import kotlin.math.roundToInt

const val TAVEN_NAME = "Taernyl's Folly"

var playerGold = 10
var playerSilver = 10
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")

fun main(args: Array<String>) {
//    if (patronList.contains("Eli")) {
//        println("The tavern master says: Eli's in the back playing cards.")
//    } else {
//        println("The tavern master says: Eli isn't here.")
//    }
//    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
//        println("The tavern master says: Yes, they're seated by the stew kettle.")
//    } else {
//        println("The tavern master says: No, they left hours ago.")
//    }
//
////    placeOrder("shandy,Dragon's Breath,5.91")
//
//    patronList.forEachIndexed { index, patron ->
//        println("Good evening, $patron - you're #${index + 1} in line.")
//        placeOrder(patron, menuList.shuffled().first())
//    }
//
//    menuList.forEachIndexed { index, data ->
//        println("$index: $data")
//    }

    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
//        println(name)
        uniquePatrons += name
    }

    println(uniquePatrons)

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
}


fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val remainingBalance = totalPurse - price
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }

fun formatGreeting(vipGuest: String?): String {
    return vipGuest?.let {
        "Welcome, $it. Please, go straight to your private room."
    } ?: "Welcome, valued customer."
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVEN_NAME.indexOf('\'')
    val tavernMaster = TAVEN_NAME.substring(0..<indexOfApostrophe)
//    println("Madrigal speaks with $tavernMaster about their order.")
    println("$patronName  speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
//    val message = "Madrigal buys a $name ($type) for $price."
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

//    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
//        "Madrigal says: Thanks for the $name."
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

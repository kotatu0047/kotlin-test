const val  MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    val playerName = "Tetragon"
//    playerName = "Vladimir" // Error: Val cannot be reassigned
    var experiencePoints = 5
    experiencePoints += 5  // OK
    println(experiencePoints)
    println(playerName)
}

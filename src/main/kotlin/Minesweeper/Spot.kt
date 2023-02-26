package Minesweeper

import kotlin.random.Random

class Spot {
    var state = random_state()
    // creates a random state for each spot either 0 or 1
    fun random_state():Int{
        val value = Random.nextInt(1,100)
        if (value < 50){
            return 1
        } else{
            return 0
        }
    }

}
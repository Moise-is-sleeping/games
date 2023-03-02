package Minesweeper

class Table {
        var original_board : MutableList<MutableList<Any>> = mutableListOf()
        var dublicate_board : MutableList<MutableList<Any>> = mutableListOf()
        var numbers_list :MutableList<MutableList<Any>> = mutableListOf()
        var count = 1
        var size = 0
        val positions = mutableListOf<String>()

        //creates a list of lists based on the size given
        fun create_board(){
            for (i in 1..size){
                val row = mutableListOf<Any>()
                val row2 = mutableListOf<Any>()
                val row3 = mutableListOf<Any>()
                for (a in 1..size){
                    val spot = Spot()
                    row.add(spot.state)
                    row2.add("X")
                    row3.add(count)
                    count += 1
                }
                original_board.add(row)
                dublicate_board.add(row2)
                numbers_list.add(row3)
            }
        }

        //displays the board that's given as well as a board showing the positions
        fun display_board(board : MutableList<MutableList<Any>>){
            for (i in 0 until board.size){
                val row = board[i]
                val row2 = numbers_list[i]
                for(spot in row){
                    print("$spot  ")
                }
                print("         ")
                for(spot2 in row2){
                    val space = " ".repeat(4-spot2.toString().length)
                    print("$spot2$space")
                }
                print("\n")
            }
        }

        //conversts a given positin into a coordinate x and y
        fun coordinate_calculator(position:Int):String{
            val y = (position-1)/size
            val x = (position-1) - (size * y)
            val coordinates = ("$y$x")
            return coordinates
        }

        // checks the coordinates around the given position and returns the number of mines
        fun counter(coordinates : String,item : Any):Int{
            val X = coordinates[1].digitToInt()
            val Y = coordinates[0].digitToInt()
            //list with the rows above and below the given y coordinates
            val row_list = listOf(Y-1,Y,Y+1)
            // list with the x coordinates in front and behind the given x coordinates
            val column_list = listOf(X-1,X,X+1)
            var counter = 0
            // loop that iterates over each x and y coordinate in order to count the mines
            for(y in row_list ){
                if(y in 0 until size){
                    for(x in column_list){
                        if(x in 0 until size){
                            positions.add("$y$x")
                            if(original_board[y][x] == item)
                                counter += 1
                        }
                    }
                }

                }
            return counter
            }

        // Checks if the position the player has choosen has a mine or not
        fun loss_checker(coordinates: String):Boolean{
            val X = coordinates[1].digitToInt()
            val Y = coordinates[0].digitToInt()
            return original_board[Y][X] == 0

        }

        // replace the position player has choosen with the number of mines around it
        fun replace(coordinates: String, counter : Int){
            val X = coordinates[1].digitToInt()
            val Y = coordinates[0].digitToInt()
            if(counter == 0){
                dublicate_board[Y][X] = " "
                original_board[Y][X] = " "
            }else{
                dublicate_board[Y][X] = counter

            }
        }

        fun reveal_spaces(){
            var coordinates = ""
            for (i in 0 until original_board.size){
                val row = original_board[i]
                for( a in 0 until row.size){
                    coordinates = "$i$a"
                    if(counter(coordinates, " ") != 0){
                        if(counter(coordinates,0) == 0){
                            original_board[i][a] = " "
                            dublicate_board[i][a] = " "
                            numbers_list[i][a] = " "
                        }
                    }
                }
            }
        }

        fun reveal_number_mines(){
            var coordinates = ""
            for (i in 0 until original_board.size){
                val row = original_board[i]
                for( a in 0 until row.size){
                    coordinates = "$i$a"
                    if(counter(coordinates, " ") != 0){
                        if(counter(coordinates,0) != 0) {
                            dublicate_board[i][a] = counter(coordinates, 0)
                            numbers_list[i][a] = " "
                        }
                    }
                }
            }
        }

}





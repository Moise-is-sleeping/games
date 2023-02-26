package Minesweeper

class Table {
        var board : MutableList<MutableList<Int>> = mutableListOf()
        var size = 0

        //creates a list of lists based on the size given
        fun create_board(){
            for (i in 1..size){
                val row = mutableListOf<Int>()
                for (a in 1..size){
                    val spot = Spot()
                    row.add(spot.state)
                }
                board.add(row)
            }
        }

        //prints out each item in the board list
        fun display_board(){
            for (row in board){
                for(spot in row){
                    print("$spot  ")
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
        fun mine_counter(coordinates : String):Int{
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
                            if(board[y][x] == 0)
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
            return board[Y][X] == 0

        }
    
        // replace the position player has choosen with the number of mines around it
        fun replace(coordinates: String, counter : Int){
            val X = coordinates[1].digitToInt()
            val Y = coordinates[0].digitToInt()
            board[Y][X] = counter
        }
}





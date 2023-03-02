package Minesweeper

fun main() {
    val game = Table()
    print("Choose the size : ")
    game.size = readln().toInt()
    game.create_board()
    while(true){
        game.display_board(game.dublicate_board)
        print("Input a position : ")
        val Input = readln().toInt()
        if(game.loss_checker(game.coordinate_calculator(Input))){
            game.display_board(game.original_board)
            print("Game Over !!")
            break
        }
        game.counter(game.coordinate_calculator(Input),0)
        game.replace(game.coordinate_calculator(Input),game.counter(game.coordinate_calculator(Input),0))
        for(i in 1..game.size){
            game.reveal_spaces()
            game.reveal_number_mines()
        }





    }


}
package Minesweeper

fun main() {
    val game = Table()
    print("Choose the size : ")
    game.size = readln().toInt()
    game.create_board()
    while(true){
        game.display_board()
        print("Input a position : ")
        val Input = readln().toInt()
        if(game.loss_checker(game.coordinate_calculator(Input))){
            break
        }
        game.mine_counter(game.coordinate_calculator(Input))
        game.replace(game.coordinate_calculator(Input),game.mine_counter(game.coordinate_calculator(Input)))
    }


}
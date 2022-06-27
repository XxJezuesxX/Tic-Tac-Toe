import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class TicTacToe
{
    private static char[][] board = {     {' ',' ',' '}, 
                                          {' ',' ',' '},
                                          {' ',' ',' '}
                                     };
    private static char player; // 'X' or 'O
    /* 
     * Instantiate board to be a 3 by 3 char array of spaces.
     * Set player to be 'X'.
     */
    public TicTacToe() 
    {
        /*
        * Step 1: create an empty board, with an initial value
        * of a space (' ')
        */
        this.board = board;
        player = 'X';
    }
    /*
     * Switches the current player from X to O, or O to X.
     */
    public static void switchTurn(char[][] board) {
        // Step 3: Fill in with your code to toggle between
        // 'X' and 'O'
        if(player == 'X')
        {
            player = 'O';
        }else
        {
            player = 'X'; 
        }
    }
    /*
     * Returns true if the current player has won the game.
     * Three in a row, column or either diagonal.
     * Otherwise, return false.
     */
    public static boolean won(char[][] board) {
        /* Step 5: Fill in the code for the won method. This method
        * should return true if the current player has 3 in-a-row 
        * in any row, column or diagonal. Otherwise, return false.
        */
        if( (board[0][0] == player && board[0][1] == player && board[0][2] == player)||
            (board[1][0] == player && board[1][1] == player && board[1][2] == player)||
            (board[2][0] == player && board[2][1] == player && board[2][2] == player)||
            
            (board[0][0] == player && board[1][0] == player && board[2][0] == player)||
            (board[0][1] == player && board[1][1] == player && board[2][1] == player)||
            (board[0][2] == player && board[1][2] == player && board[2][2] == player)||
            
            (board[0][0] == player && board[1][1] == player && board[2][2] == player)||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player))
            
        { 
            return true; 
        }else
        {
            return false;
        }
    }
    /*
     * Returns true if there are no places left to move
     */
    public static boolean stalemate(char[][] board) 
    {
        /*
         * Step 4: Fill in the code for the stalemate method. It
         * should return true if there are no more places to move 
         * on the board. Otherwise, return false; 
         */
        if(board == null)
        {
            return false;
        }
        List<Character> coord = new ArrayList<Character>();
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            { // till here, the code gives me the coordinates
                coord.add(board[i][j]);
            }
        }
        if(coord.contains(' '))
        { //if any position is empty,
            return false; //basically breaks the loop here and (the method is assigned false?)
        }else
        {
            return true;
        }
         // replace with your own return 
    }
    public static char getPlayer()
    {
        return player;
    }
    public static void print(char[][] board)
    {
        System.out.println();
        System.out.println("\t  1 2 3");
        System.out.println();
        System.out.println("\tA "+board[0][0]+"|"+board[0][1]+"|"+board[0][2]);
        System.out.println("\t  -----");
        System.out.println("\tB "+board[1][0]+"|"+board[1][1]+"|"+board[1][2]);
        System.out.println("\t  -----");
        System.out.println("\tC "+board[2][0]+"|"+board[2][1]+"|"+board[2][2]);
        System.out.println();
    }
    /* 
     * If s represents a valid (- no replacing text, empty space ==> empty space) move, add the current player's symbol (X/O) to the board 
       and return true.
     * Otherwise return false.
     */
    public static boolean play (String s, char[][] board, char player){
        switch(s)
        { 
            case "A1":
                board[0][0] = player; break; //break from switch 
            case "A2":
                board[0][1] = player; break;
            case "A3":
                board[0][2] = player; break;    
            case "B1":
                board[1][0] = player; break;    
            case "B2": 
                board[1][1] = player; break;   
            case "B3":
                board[1][2] = player; break;
            case "C1":
                board[2][0] = player; break;
            case "C2":
                board[2][1] = player; break;
            case "C3":
                board[2][2] = player; break; 
            default:
                return false;    
        }
        if(board != null)
        {
            return true;
        }else
        {
            return false;
        }
    }
    private static boolean isPositionTaken(String p, char[][] board) 
    {
        switch(p) 
        {
            case "A1":
                return (board[0][0] == ' ');
            case "A2":
                return (board[0][1] == ' ');
            case "A3":
                return (board[0][2] == ' ');
            case "B1":
                return (board[1][0] == ' ');
            case "B2":
                return (board[1][1] == ' ');
            case "B3":
                return (board[1][2] == ' ');
            case "C1":
                return (board[2][0] == ' ');
            case "C2":
                return (board[2][1] == ' ');
            case "C3":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }
    /* 
     * Step 6: Main Method for Final Step - Delete your main method 
     * and uncomment this one. 
     * Runs the game by getting input from the user, making the 
     * appropriate moves, and prints who won or if it was a stalemate. 
    */ 
    public static void main(String[] args)
    { 
       Scanner in = new Scanner(System.in);
       TicTacToe game = new TicTacToe();
       System.out.println("Welcome to Tic-tac-toe");
       System.out.println("Enter coordinates for your move following the X and O prompts");
       while(!game.stalemate(board)) 
       {
            game.print(board);
            System.out.print(game.getPlayer() + ":");
            String input = in.nextLine().toUpperCase(); 
            //Loop while the method play does not return true when given their move.
            //Body of loop should ask for a different move
            if(game.isPositionTaken(input, board))
            {
                while(game.play(input, board, player))
                {
                    if(!game.play(input, board, player))
                    {
                        switchTurn(board);
                    }else{
                        break;
                    }
                    System.out.print(game.getPlayer() + ":");
                }
            }else if (input != "A1" ||input != "A2" ||input != "A3" ||
                      input != "B1" ||input != "B2" ||input != "B3"||
                      input != "C1" ||input != "C2" ||input != "C3" )
            {
                System.out.println("Illegal move. Enter correct move.");
                switchTurn(board);
            }
            else if(!game.isPositionTaken(input, board))
            {
                System.out.println("Position already taken");
                switchTurn(board);
            }
            //If the game is won, call break;
            if(game.won(board))
            { 
              break;
            }
            //Switch the turn
            game.switchTurn(board);
       }
       game.print(board);
       if(game.won(board))
       {
         System.out.println("Player "+game.getPlayer()+" Wins!!!!");
       } 
       else 
       {
         System.out.println("Stalemate!");
       }
    }
}

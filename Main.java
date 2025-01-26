public class Main{
    
    public static void main(String[] args) {
        BoardDisplay myDisplay = new BoardDisplay();
        myDisplay.scramble();
        myDisplay.updateBoard();
        Boolean won = false;
        while(!won){
            won = myDisplay.hasWonGame();
        }
        // Board myBoard = new Board(); 
        // System.out.println(myBoard);
        
    }
}
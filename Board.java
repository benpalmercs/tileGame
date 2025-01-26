public class Board {
    private int[][] board;
    private int[][] goal;
    public Board(){
        this.board = new int[3][3];
        for(int i = 0;i<3;i++){
            for(int f = 0; f<3;f++){
                if(!(i==2 && f==2)){
                    this.board[i][f] = i*3+f+1;
                }
            }
        }
    }


    public int[] findBlank(){
        int[] coords = new int[2];
        for(int i = 0;i<3;i++){
            for(int f = 0; f<3;f++){
                if(this.board[i][f]==0){
                    coords[0]=i;
                    coords[1]=f;
                }
            }
        }
        return coords;
    }

    public Boolean canMove(int i, int f){
        return (i==this.findBlank()[0] || f==this.findBlank()[1]);
    }
    public boolean blankIsAbove(int i){
        return i>this.findBlank()[0];
    }

    public boolean blankIsRight(int f){
        return f<this.findBlank()[1];
    }

    public void moveUp(int tileRow, int col){
        int blankRow = this.findBlank()[0];
        if(this.canMove(tileRow,col) && this.blankIsAbove(tileRow)){
            for(int i = blankRow;i<tileRow;i++){
                this.board[i][col] = this.board[i+1][col];
                
            } 
            this.board[tileRow][col]=0;
        }
    }

    public void moveDown(int tileRow, int col){
        int blankRow = this.findBlank()[0];
        if(this.canMove(tileRow,col) && !(this.blankIsAbove(tileRow))){
            for(int i = blankRow;i>tileRow;i--){
                this.board[i][col] = this.board[i-1][col];
                
            } 
            this.board[tileRow][col]=0;
        }
    }

    public void moveRight(int row, int tileCol){
        int blankCol = this.findBlank()[1];
        if(this.canMove(row, tileCol) && (this.blankIsRight(tileCol))){
            for(int i = blankCol;i>tileCol;i--){
                this.board[row][i] = this.board[row][i-1];
                
            } 
            this.board[row][tileCol]=0;
        }
    }

    public void moveLeft(int row, int tileCol){
        int blankCol = this.findBlank()[1];
        if(this.canMove(row, tileCol) && !(this.blankIsRight(tileCol))){
            for(int i = blankCol;i<tileCol;i++){
                this.board[row][i] = this.board[row][i+1];
                
            } 
            this.board[row][tileCol]=0;
        }
    }

    public void moveTile(int row, int col){
        if(this.canMove(row,col)){
            if(this.findBlank()[0]==row){
                if(this.blankIsRight(col)){
                    this.moveRight(row,col);
                }
                else{
                    this.moveLeft(row,col);
                }
            }
            else if(this.findBlank()[1]==col){
                if(this.blankIsAbove(row)){
                    this.moveUp(row,col);
                }
                else{
                    this.moveDown(row,col);
                }
            }
        }
    }

    public Boolean hasWon(){
        this.goal = new int[3][3];
        for(int i = 0;i<3;i++){
            for(int f = 0; f<3;f++){
                if(!(i==2 && f==2)){
                    this.goal[i][f] = i*3+f+1;
                }
            }
        }
        for(int i = 0;i<3;i++){
            for(int f = 0; f<3;f++){
                if(this.goal[i][f]!=this.board[i][f]){
                    return false;
                }
            }
        }
        return true;
        
    }

    public void scrambleBoard() {
        // Clear the board
        for (int i = 0; i < 3; i++) {
            for (int f = 0; f < 3; f++) {
                this.board[i][f] = 0;
            }
        }
    
        // Place numbers 1 to 8 randomly on the board
        for (int i = 1; i < 9; i++) {
            boolean placed = false;
            while (!placed) {  // Use '==' or '!' for comparison
                int randI = (int) (Math.random() * 3); // Random row index
                int randF = (int) (Math.random() * 3); // Random column index
                if (this.board[randI][randF] == 0) {  // Check if the cell is empty
                    this.board[randI][randF] = i;    // Place the number
                    placed = true;                  // Exit the loop
                }
            }
        }
    }
    


    public int[][] getBoard(){
        return board;
    }

    public String toString(){
        return (""+this.board[0][0] + " " + this.board[0][1]+ " " + this.board[0][2]+"\n"
                +this.board[1][0] + " " + this.board[1][1]+ " " + this.board[1][2]+"\n"
                +this.board[2][0] + " " + this.board[2][1]+ " " + this.board[2][2]+"\n");
    }
}

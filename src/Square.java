import java.awt.*;

/**
 * A class written to support the TicTacToe Game.
 *
 * Each Square object is one position of the TicTacToe
 * board. It maintains information on the marker, its
 * location on the board, and whether it is part
 * of the winning set.
 *
 * @author: Nandhini Namasivayam
 * @version: Jan 2023
 */

public class Square {

    private String marker;
    private int row;
    private int col;
    private boolean isWinningSquare;

    private TicTacToeViewer t;
    public static final int imageSize = (int)(TicTacToeViewer.SIDE_LENGTH*0.4);

    /**
     * Constructor to initialize one Square of the
     * TicTacToe board
     * @param row the row the square is in
     * @param col the column the square is in
     */
    public Square(int row, int col, TicTacToeViewer t) {
        this.t = t;

        this.row = row;
        this.col = col;

        this.marker = TicTacToe.BLANK;
        this.isWinningSquare = false;
    }

    /******************** Getters and Setters ********************/
    public String getMarker() {
        return this.marker;
    }

    public void setMarker(String marker) {
        this.marker = marker;
    }

    public void setWinningSquare() {
        this.isWinningSquare = true;
    }

    /**
     * Checks if the square has the BLANK marker
     * @return True if the square is empty, False otherwise
     */
    public boolean isEmpty() {
        return this.marker.equals(TicTacToe.BLANK);
    }

    /**
     * @return the marker for the square
     */
    public String toString() {
        return this.marker;
    }

    public void draw(Graphics g, int topX, int topY, Image imageO, Image imageX){
        g.setColor(Color.black);
        g.drawRect(topX, topY, TicTacToeViewer.SIDE_LENGTH, TicTacToeViewer.SIDE_LENGTH);

        if(this.isWinningSquare){
            g.setColor(Color.GREEN);
            g.fillRect(topX, topY, TicTacToeViewer.SIDE_LENGTH, TicTacToeViewer.SIDE_LENGTH);
        }


        // Prints X or Y image in corret place if needed
        int xPos = topX + TicTacToeViewer.SIDE_LENGTH/2 - imageSize/2;
        int yPos = topY + TicTacToeViewer.SIDE_LENGTH/2 - imageSize/2;
        // fills in X/O
        if(this.marker.equals("X")){
            g.drawImage(imageX, xPos, yPos, imageSize,imageSize, t);
        }
        else if(this.marker.equals("O")){
            g.drawImage(imageO, xPos, yPos, imageSize,imageSize, t);
        }


    }
}

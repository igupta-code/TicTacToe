import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.*;
import java.awt.*;

public class TicTacToeViewer extends JFrame {
    // TODO: Complete this class
    public static final int WINDOW_WIDTH = 800,
                            WINDOW_HEIGHT = 800,
                            BUFFER_X = (int)(WINDOW_WIDTH*0.2),
                            BUFFER_Y = (int)(WINDOW_HEIGHT*0.2),
                            SIDE_LENGTH = (int)(WINDOW_WIDTH*0.19),
                            LABEL_OFFSET = (int)(WINDOW_WIDTH*0.05);
    public final String TITLE = "Tic Tac Toe";
    private Square[][] board = new Square[3][3];

    private TicTacToe t;

    private Image imageO;
    private Image imageX;



    public TicTacToeViewer(TicTacToe t){
        this.t = t;
        imageO = new ImageIcon("Resources/O.png").getImage();
        imageX = new ImageIcon("Resources/X.png").getImage();


        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = t.getBoard()[i][j];

        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle(TITLE);
        this.setVisible(true);
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);

        // Print out the number labels
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 30));
        for(int i = 0; i < 3; i++){
            int xPos = BUFFER_X + SIDE_LENGTH/2 + i*SIDE_LENGTH;
            int yPos = BUFFER_Y - LABEL_OFFSET;

            g.drawString(Integer.toString(i), xPos , yPos);
        }
        for(int i = 0; i < 3; i++){
            int xPos = BUFFER_X - LABEL_OFFSET;
            int yPos = BUFFER_Y + SIDE_LENGTH/2 + i*SIDE_LENGTH;

            g.drawString(Integer.toString(i), xPos , yPos);
        }

        // Draws the board
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int topX = BUFFER_X + (SIDE_LENGTH * i);
                int topY = BUFFER_Y + (SIDE_LENGTH * j);

                board[j][i].draw(g, topX, topY, imageO, imageX);
            }
        }
        if(t.getGameOver()){
            if(t.getWinner().equals("X")) {
                g.drawString("X Wins!", BUFFER_X, BUFFER_Y + 3 * SIDE_LENGTH + LABEL_OFFSET);
            }
            else if(t.getWinner().equals("O")){
                g.drawString("O Wins!", BUFFER_X, BUFFER_Y + 3 * SIDE_LENGTH + LABEL_OFFSET);
            }
            else{
                g.drawString("Game ends in a Tie!", BUFFER_X, BUFFER_Y + 3 * SIDE_LENGTH + LABEL_OFFSET);
            }
        }
    }

    // Draw Final Message




}

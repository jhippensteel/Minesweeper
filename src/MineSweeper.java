import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame{
    JPanel boardDisplay = new JPanel();
    Square[][] board;
    boolean isFirstMove = true;
    int allMines, revealedSquares = 0;


    public MineSweeper(int size){
        isFirstMove = true;
        int row, col;
        board = new Square[size][size];
        Square square;
        setTitle("MineSweeper");
        this.setSize(size*50, size*50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardDisplay.setLayout(new GridLayout(size, size)); setLocationRelativeTo(null);
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
                square = new Square(Math.random() < .0125);
                square.row = row;
                square.col = col;
                square.game = this;
                if(square.mine)allMines++;
                boardDisplay.add(square);
                board[row][col] = square;

            }
        }
        this.add(boardDisplay);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MineSweeper game = new MineSweeper(10);
    }

}

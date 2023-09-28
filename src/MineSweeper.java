import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame{
    JPanel boardDisplay = new JPanel();

    public MineSweeper(int size){
        int row, col;
        Square square;
        setTitle("MineSweeper");
        this.setSize(size*50, size*50);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        boardDisplay.setLayout(new GridLayout(size, size)); setLocationRelativeTo(null);
        for (row = 0; row < size; row++) {
            for (col = 0; col < size; col++) {
                square = new Square(Math.random() < 0.2);
                square.row = row;
                square.col = col;
                square.game = this;
                boardDisplay.add(square);

            }
        }
        this.add(boardDisplay);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        MineSweeper game = new MineSweeper(5);
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Square extends JButton {
    boolean mine;
    int row, col;
    boolean revealed = false;
    MineSweeper game;


    public Square(boolean makeMine) {
        mine = makeMine;
        //if(mine) setText("*");
        addActionListener(new SquareListener());
    }

    class SquareListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if(mine) {
                setBackground(Color.red);
                setText("*");
                JOptionPane.showMessageDialog(null, "BOOM, Game over");
            }
            else setBackground(Color.lightGray);
        }
    }
}

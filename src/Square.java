import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Square extends JButton {
    boolean mine;
    boolean flagged = false;
    int row, col;
    boolean revealed = false;
    MineSweeper game;
    int mineCount;


    public Square(boolean makeMine) {
        mine = makeMine;
        //if(mine) setText("*");
        addMouseListener(new SquareListener());
        revealed = false;
        mineCount = 0;
    }

    class SquareListener implements MouseListener {

        public void mouseClicked(MouseEvent e) {
            if(flagged && e.getButton()==1) return;
            if(e.getButton()==3) {
                flagged = !flagged;
                if(flagged) setBackground(Color.yellow); else setBackground(null);
                return;
            }
            if(game.isFirstMove && mine) {mine = false;game.allMines--;}
            game.isFirstMove = false;
            expose(row, col);
        }




        public void mousePressed(MouseEvent e) {

        }


        public void mouseReleased(MouseEvent e) {

        }


        public void mouseEntered(MouseEvent e) {

        }


        public void mouseExited(MouseEvent e) {

        }
    }
    public void expose(int x, int y){
        game.revealedSquares++;
        int r, c;
        if(game.board[x][y].mine) {
            game.board[x][y].setBackground(Color.red);
            game.board[x][y].setText("*");
            JOptionPane.showMessageDialog(null, "BOOM, Game over");
            return;
        }
        game.board[x][y].setBackground(Color.lightGray);
        game.board[x][y].revealed=true;
        if((int) Math.pow(game.board.length,2)-game.revealedSquares == game.allMines) {JOptionPane.showMessageDialog(null, "Congratulations, You Won");return;}
        else {System.out.println("Suares Left" + (Math.pow(game.board.length,2)-game.revealedSquares) + "Mines: " + game.allMines);}

        for (r = x - 1; r <= x + 1; r++) {
            for (c = y - 1; c <= y + 1; c++) {
                if(r<0 || r>game.board.length-1)break;
                if(c<0 || c > game.board[r].length-1)continue;
                if (game.board[r][c].mine) {
                    game.board[x][y].mineCount++;
                }
            }
        }
        if(game.board[x][y].mineCount > 0) game.board[x][y].setText("" + game.board[x][y].mineCount);
        else{
            //System.out.println("Minecount: "+ mineCount);
            for (r = x - 1; r <= x + 1; r++) {
                for (c = y - 1; c <= y + 1; c++) {
                    if(r<0 || r>game.board.length-1)break;
                    if(c<0 || c > game.board[r].length-1)continue;
                    if(!game.board[r][c].revealed) {
                        expose(r, c);
                    }
                }
            }
        }
        //else {System.out.println(mineCount);};

    }
}

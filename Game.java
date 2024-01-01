import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.io.IOException;



public class Game extends JPanel implements KeyListener {

    public static int ROWS;
    public static int COLUMNS;
    public static final int TILE_SIZE=48;
    public static Matrice mat;
    public static Player patrick;
    public static TabImages tabImage=new TabImages();

    public Game(){
        this.mat=new Matrice("levels/map.txt");
        ROWS=mat.lines;
        COLUMNS=mat.columns;

        setPreferredSize(new Dimension(TILE_SIZE*COLUMNS,TILE_SIZE*ROWS));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(this);
        setFocusable(true);

        patrick=new Player(mat);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g; 
        int x=0, y=0;
        for (int i=0; i<ROWS; i++){
            for(int j=0; j<COLUMNS; j++){
                g.drawImage(tabImage.images.get(mat.matrice[i][j]), x, y, 48, 48, null);
                x+=48;
            }
            y+=48;
            x=0;

        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        mat.affMat();
        if(key == KeyEvent.VK_UP){
            if (mat.movePatrik(patrick.playerX, patrick.playerY, Direction.NORD)){
                patrick.playerX-=1;
            }
        }else if(key == KeyEvent.VK_RIGHT){  
            if (mat.movePatrik(patrick.playerX, patrick.playerY, Direction.EST)){
                patrick.playerY+=1;
            }
        }else if(key == KeyEvent.VK_LEFT){
            if (mat.movePatrik(patrick.playerX, patrick.playerY, Direction.OUEST)){
                patrick.playerY-=1;
            }
        }else if(key == KeyEvent.VK_DOWN){       
            if (mat.movePatrik(patrick.playerX, patrick.playerY, Direction.SUD)){
                patrick.playerX+=1;
            }
        }
        repaint();
    }



    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

}
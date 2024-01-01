import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class App extends Game {
    public static Game game;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sokoban Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Game game = new Game();
        frame.add(game);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
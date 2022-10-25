package Ch04;

import javax.swing.*;
import java.awt.*;

    class Main extends JPanel{
    String type;
    int n;
    public Main(){
        type = JOptionPane.showInputDialog("Select function (A/M):");
        n = Integer.parseInt(JOptionPane.showInputDialog("Input table size:"));
    }
    @Override
    public void paintComponent(Graphics g){
        int w = getWidth();
        int h = getHeight();
        int x = 0;
        int y = 0;
        int cellWidth = w/n;
        int cellHeight = h/n;

        for (int j = 1; j <= n; j++){
            for (int i = 1; i <= n; i++){
                if(i == 1 || j ==1){
                    g.setColor(Color.cyan);
                    g.fillRect(x, y, cellWidth, cellHeight);

                }
                g.setColor(Color.black);
                g.drawRect(x, y, cellWidth, cellHeight);

                if(i == 1){
                    g.drawString("" + j, x+10, y+25);
                } else if (j == 1){
                    g.drawString("" + i, x+10, y+25);
                } else {
                    int outputValue = 0;
                    if (type.toLowerCase().equals("a")){
                        outputValue = i + j;
                    } else if (type.toLowerCase().equals("m")){
                        outputValue = i * j;
                    }
                    g.drawString("" + outputValue, x+10, y+25);
                }
                x += cellWidth;
            }
            x = 0;
            y += cellHeight;
        }
    }
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(450,450);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}




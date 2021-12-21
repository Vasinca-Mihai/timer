package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyFrame extends JFrame implements ActionListener {
    public static boolean bol= true;
    public static JButton b1;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b1 = new JButton();
        b1.setBounds(5,5,20,20);
        frame.add(b1);
        frame.setVisible(true);
        while (bol){
            System.out.println("here");
        }
    }
    public MyFrame(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == b1){
            bol = false;
        }
    }
}

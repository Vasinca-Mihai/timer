package Timer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceManager {
    JFrame window;
    JButton m1Start;
    JButton m1Validate;
    JLabel m1FileInput;
    JTextField m1FileInputTF;
    JTextField m1NrOfSetsTF;
    JTextField m1StartAtTF;
    JLabel m1NrOfSets;
    JLabel m1StartAt;

    public InterfaceManager(){
        window = new JFrame();
        window.setSize(640,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        m1FileInput = new JLabel("Input the name of the file to be loaded: ");
        m1FileInput.setSize(400,60);
        //m1FileInput.setBackground(new Color(200,0,200));
        //m1FileInput.setOpaque(true);
        m1FileInput.setFont(new Font("",Font.PLAIN,20));
        m1FileInput.setHorizontalAlignment(JLabel.RIGHT);
        m1FileInput.setLocation(10,10);

        m1NrOfSets = new JLabel("Input the nr of sets you want to do: ");
        m1NrOfSets.setFont(m1FileInput.getFont());
        m1NrOfSets.setSize(m1FileInput.getSize());
        m1NrOfSets.setHorizontalAlignment(JLabel.RIGHT);
        m1NrOfSets.setLocation(10,10 + 60 + 10);
        window.add(m1NrOfSets);

        m1FileInputTF = new JTextField();
        m1FileInputTF.setFont(m1FileInput.getFont());
        m1FileInputTF.setLocation(410,10);
        m1FileInputTF.setSize(200,60);

        m1NrOfSetsTF = new JTextField();
        m1NrOfSetsTF.setFont(m1FileInput.getFont());
        m1NrOfSetsTF.setLocation(410,10 + 60 + 10);
        m1NrOfSetsTF.setSize(200,60);
        window.add(m1NrOfSetsTF);

        m1StartAt = new JLabel("Input the nr of sets you want to do: ");
        m1StartAt.setFont(m1FileInput.getFont());
        m1StartAt.setSize(m1FileInput.getSize());
        m1StartAt.setHorizontalAlignment(JLabel.RIGHT);
        m1StartAt.setLocation(10,10 + (60 + 10)*2);
        window.add(m1StartAt);

        m1StartAtTF = new JTextField();
        m1StartAtTF.setFont(m1FileInput.getFont());
        m1StartAtTF.setLocation(410,10 + (60 + 10)*2);
        m1StartAtTF.setSize(200,60);
        window.add(m1StartAtTF);

        m1Validate = new JButton();
        m1Validate.setSize(600,60);
        m1Validate.setFont(m1FileInput.getFont());
        m1Validate.setText("Validate imputed data.");
        m1Validate.setLocation(10,10+(60+10)*3);
        window.add(m1Validate);

        m1Start = new JButton();
        m1Start.setSize(600,60);
        m1Start.setFont(m1FileInput.getFont());
        m1Start.setText("Start exercising.");
        m1Start.setLocation(10,10+(60+10)*4);
        m1Start.setEnabled(false);
        window.add(m1Start);


        window.setResizable(true);
        window.add(m1FileInput);
        window.add(m1FileInputTF);
        window.setVisible(true);
    }
}
package Timer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfaceManager implements ActionListener{
    static InterfaceManager instance;

    JFrame window;
    JButton m1Start;
    JButton m1Validate;
    JLabel m1FileInput;
    JTextField m1FileInputTF;
    JTextField m1NrOfSetsTF;
    JTextField m1StartAtTF;
    JLabel m1NrOfSets;
    JLabel m1StartAt;
    List<Component> menu1;
    List<Component> menu2;
    List<Component> activeMenu;

    JLabel m2ExTitle;
    JLabel m2ExDescription;
    JLabel m2Counter;

    public static InterfaceManager getInstance(){
        if(instance == null){
            return new InterfaceManager();
        }else return instance;
    }
    private InterfaceManager(){
        window = new JFrame();
        window.setSize(640,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        //window.setIconImage(new ImageIcon("./src/Resources/BigProfilePic.png").getImage());

        initiateM1();
        initiateM2();
        switchMenu(1);

        window.setResizable(true);
        window.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == m1Validate){
            if(new File("./src/UserData/"+m1FileInputTF.getText()+".txt").isFile()) {
                m1Start.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(new JFrame(),"No such file found.","404",JOptionPane.INFORMATION_MESSAGE);
            }
            //System.out.println(m1FileInputTF.getText());
            //System.out.println(m1NrOfSetsTF.getText());
            //System.out.println(m1StartAtTF.getText());
        }else if(e.getSource() == m1Start) {
            switchMenu(2);
            //ExercisingLogic.startExercising();
        }
    }

    private void initiateM1(){
        m1FileInput = new JLabel("Input the name of the file to be loaded: ");
        m1FileInput.setSize(400,60);
        m1FileInput.setLocation(10,10);
        m1FileInput.setFont(new Font("",Font.PLAIN,20));
        m1FileInput.setHorizontalAlignment(JLabel.RIGHT);

        m1NrOfSets = new JLabel("Input the nr of sets you want to do: ");
        m1NrOfSets.setFont(m1FileInput.getFont());
        m1NrOfSets.setSize(m1FileInput.getSize());
        m1NrOfSets.setHorizontalAlignment(JLabel.RIGHT);
        m1NrOfSets.setLocation(10,10 + 60 + 10);

        m1FileInputTF = new JTextField();
        m1FileInputTF.setFont(m1FileInput.getFont());
        m1FileInputTF.setLocation(410,10);
        m1FileInputTF.setSize(200,60);

        m1NrOfSetsTF = new JTextField();
        m1NrOfSetsTF.setFont(m1FileInput.getFont());
        m1NrOfSetsTF.setLocation(410,10 + 60 + 10);
        m1NrOfSetsTF.setSize(200,60);

        m1StartAt = new JLabel("Input the exercise to start at:");
        m1StartAt.setToolTipText("This field is meant to be used in case something interrupted your workout (default: 0)");
        m1StartAt.setFont(m1FileInput.getFont());
        m1StartAt.setSize(m1FileInput.getSize());
        m1StartAt.setHorizontalAlignment(JLabel.RIGHT);
        m1StartAt.setLocation(10,10 + (60 + 10)*2);

        m1StartAtTF = new JTextField();
        m1StartAtTF.setFont(m1FileInput.getFont());
        m1StartAtTF.setLocation(410,10 + (60 + 10)*2);
        m1StartAtTF.setSize(200,60);

        m1Validate = new JButton();
        m1Validate.setSize(600,60);
        m1Validate.setFont(m1FileInput.getFont());
        m1Validate.setText("Validate imputed data.");
        m1Validate.setLocation(10,10+(60+10)*3);
        m1Validate.addActionListener(this);

        m1Start = new JButton();
        m1Start.setSize(600,60);
        m1Start.setFont(m1FileInput.getFont());
        m1Start.setText("Start exercising.");
        m1Start.setLocation(10,10+(60+10)*4);
        m1Start.setEnabled(false);
        m1Start.addActionListener(this);

        menu1 = new ArrayList<>(Arrays.asList(m1FileInput,m1StartAt,m1NrOfSets,m1Start,m1FileInputTF,m1Validate,m1NrOfSetsTF,m1StartAtTF));
    }

    private void initiateM2(){
        m2ExTitle = new JLabel();
        m2ExTitle.setLocation(0,10);
        m2ExTitle.setSize(640,100);
        m2ExTitle.setText("Burpees");
        m2ExTitle.setHorizontalAlignment(JLabel.CENTER);
        m2ExTitle.setFont(new Font("",Font.PLAIN,70));

        m2ExDescription = new JLabel();
        m2ExDescription.setLocation(0,120);
        m2ExDescription.setText("pushups with jumps");
        m2ExDescription.setSize(640,60);
        m2ExDescription.setHorizontalAlignment(JLabel.CENTER);
        m2ExDescription.setFont(new Font("",Font.PLAIN,20));

        m2Counter = new JLabel();
        m2Counter.setText("25 reps");
        m2Counter.setSize(640,280);
        m2Counter.setLocation(0,190);
        m2Counter.setHorizontalAlignment(JLabel.CENTER);
        m2Counter.setVerticalAlignment(JLabel.CENTER);
        m2Counter.setFont(new Font("",Font.PLAIN,100));

        menu2 = new ArrayList<>(Arrays.asList(m2ExTitle,m2Counter,m2ExDescription));
    }

    private void switchMenu(int to){
        List<Component> toMenu = null;
        switch(to) {
            case 1:toMenu = menu1;break;
            case 2:toMenu = menu2;break;
        }
        window.getContentPane().removeAll();
        for(int i=0;i<toMenu.size();i++){
            window.add(toMenu.get(i));
        }
        activeMenu = toMenu;
        window.update(window.getGraphics());
    }
}
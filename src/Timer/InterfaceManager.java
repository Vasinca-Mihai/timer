package Timer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfaceManager implements ActionListener {

    private static JFrame window;
    private static JButton m1Start;
    private static JButton m1Validate;
    private static JLabel m1FileInput;
    private static JTextField m1FileInputTF;
    private static JTextField m1NrOfSetsTF;
    //private static JTextField m1StartAtTF;
    private static JLabel m1NrOfSets;
    //private static JLabel m1StartAt;
    //private static MyKeyListener KL;

    private static JLabel m2ExTitle;
    private static JLabel m2ExDescription;
    private static JLabel m2Counter;
    private static JButton m2Done;

    private static List<Component> menu1;
    private static List<Component> menu2;

    public static void main(String[] args) {
        //KL = new MyKeyListener();
        new InterfaceManager();
    }

    //public static InterfaceManager getInstance(){
    //    if(instance == null){
    //        return new InterfaceManager();
    //    }else return instance;
    //}

    public InterfaceManager(){
        window = new JFrame();
        //window.addKeyListener(KL);
        window.setSize(640,500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);
        //window.setIconImage(new ImageIcon("./src/Resources/BigProfilePic.png").getImage());

        initiateM1();
        initiateM2();
        switchMenu(1);

        window.setResizable(false);
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
        }else if(e.getSource() == m1Start) {
            switchMenu(2);
            ExercisingLogic.startExercising();
        }else if(e.getSource() == m2Done){
            ExercisingLogic.continueExLogic();
            System.out.println("here");
        }
    }

    private void initiateM1(){
        m1FileInput = new JLabel("Input the name of the file to be loaded: ");
        m1FileInput.setSize(400,60);
        m1FileInput.setLocation(10,10);
        m1FileInput.setFont(new Font("Arial",Font.PLAIN,20));
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

        //m1StartAt = new JLabel("Input the exercise to start at:");
        //m1StartAt.setToolTipText("This field is meant to be used in case something interrupted your workout (default: 0)");
        //m1StartAt.setFont(m1FileInput.getFont());
        //m1StartAt.setSize(m1FileInput.getSize());
        //m1StartAt.setHorizontalAlignment(JLabel.RIGHT);
        //m1StartAt.setLocation(10,10 + (60 + 10)*2);
//
        //m1StartAtTF = new JTextField();
        //m1StartAtTF.setFont(m1FileInput.getFont());
        //m1StartAtTF.setLocation(410,10 + (60 + 10)*2);
        //m1StartAtTF.setSize(200,60);

        m1Validate = new JButton();
        m1Validate.setSize(600,60);
        m1Validate.setFont(m1FileInput.getFont());
        m1Validate.setText("Validate imputed data.");
        m1Validate.setLocation(10,10+(60+10)*2);
        m1Validate.addActionListener(this);

        m1Start = new JButton();
        m1Start.setSize(600,60);
        m1Start.setFont(m1FileInput.getFont());
        m1Start.setText("Start exercising.");
        m1Start.setLocation(10,10+(60+10)*3);
        m1Start.setEnabled(false);
        m1Start.addActionListener(this);

        menu1 = new ArrayList<>(Arrays.asList(m1FileInput,m1NrOfSets,m1Start,m1FileInputTF,m1Validate,m1NrOfSetsTF));
        //for(int i=0;i<menu1.size();i++){
        //    menu1.get(i).addKeyListener(KL);
        //}
    }

    private void initiateM2(){
        m2ExTitle = new JLabel();
        m2ExTitle.setLocation(0,10);
        m2ExTitle.setSize(640,100);
        m2ExTitle.setText("Placeholder title");
        m2ExTitle.setHorizontalAlignment(JLabel.CENTER);
        m2ExTitle.setFont(new Font("Arial",Font.PLAIN,70));

        m2ExDescription = new JLabel();
        m2ExDescription.setLocation(0,120);
        m2ExDescription.setText("Placeholder description");
        m2ExDescription.setSize(640,50);
        m2ExDescription.setHorizontalAlignment(JLabel.CENTER);
        m2ExDescription.setFont(new Font("Arial",Font.PLAIN,20));

        m2Counter = new JLabel();
        m2Counter.setText("Placeholder ct");
        m2Counter.setSize(640,240);
        m2Counter.setLocation(0,180);
        m2Counter.setHorizontalAlignment(JLabel.CENTER);
        m2Counter.setVerticalAlignment(JLabel.CENTER);
        m2Counter.setFont(new Font("Arial",Font.PLAIN,100));

        m2Done = new JButton();
        m2Done.setSize(600,40);
        m2Done.setFont(m1FileInput.getFont());
        m2Done.setText("Done.");
        m2Done.setLocation(10,240+180);
        m2Done.addActionListener(this);
        m2Done.setVisible(false);



        menu2 = new ArrayList<>(Arrays.asList(m2ExTitle,m2Counter,m2ExDescription,m2Done));
        //for(int i=0;i<menu2.size();i++){
        //    menu2.get(i).addKeyListener(KL);
        //}
    }

    public static void switchMenu(int to){
        List<Component> toMenu = null;
        switch(to) {
            case 1:toMenu = menu1;break;
            case 2:toMenu = menu2;break;
        }
        window.getContentPane().removeAll();
        for(int i=0;i<toMenu.size();i++){
            window.add(toMenu.get(i));
        }
        window.update(window.getGraphics());
    }

    public static void updateTextFiled(TextFiledName filedName,String updateTo){
        switch (filedName){
            case M2_ExTitle: m2ExTitle.setText(updateTo);break;
            case M2_Counter: m2Counter.setText(updateTo);break;
            case M2_ExDescription: m2ExDescription.setText(updateTo);break;
        }
        window.update(window.getGraphics());
    }
    public static void EnableDisableDoneButton(boolean bool){
        m2Done.setVisible(bool);
    }
}
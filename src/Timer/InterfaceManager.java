package Timer;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InterfaceManager implements ActionListener {

    private static final int defaultNrOfSets = 1;
    private static final int defaultRestTimeSets = 120;
    private static final String defaultFile = "default";

    private static JFrame window;
    private static JButton mmStart;
    private static JButton mmValidate;
    private static JLabel mmFileInput;
    private static JTextField mmFileInputTF;
    private static JTextField mmNrOfSetsTF;
    //private static JTextField m1StartAtTF;
    private static JLabel mmNrOfSets;
    //private static JLabel m1StartAt;
    //private static MyKeyListener KL;
    private static JLabel mmTimeBetweenSets;
    private static JTextField mmTimeBetweenSetsTF;

    private static JLabel exExTitle;
    private static JLabel exExDescription;
    private static JLabel exCounter;
    private static JButton exDone;

    private static List<Component> mainMenu;
    private static List<Component> exerciseMenu;

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
        mmStart.setEnabled(false);
        String errorMessage = "detected problems:\n";
        if(e.getSource() == mmValidate){
            if(!new File("./src/UserData/"+ mmFileInputTF.getText()+".txt").isFile()){
                errorMessage += "\tInputted file was not found.\n";
            }
            if(!(new File("./src/UserData/"+ defaultFile +".txt").isFile()) && mmFileInputTF.getText().isEmpty()){
                errorMessage += "\tThe default file was not found (default file is named: \""+defaultFile+"\").\n";
            }
            if(!mmNrOfSetsTF.getText().isEmpty()){
                if(Integer.parseInt(mmNrOfSetsTF.getText())<=0){
                    errorMessage += "\tThe number of sets inputted is invalid (smaller than one).\n";
                }
            }
            if(!mmTimeBetweenSetsTF.getText().isEmpty()){
                if(Integer.parseInt(mmTimeBetweenSetsTF.getText())<=0) {
                    errorMessage += "\tThe rest time between sets is invalid (smaller than one).\n";
                }
            }
            //System.out.println(errorMessage);
            if(errorMessage.equals("detected problems:\n")){
                mmStart.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(new JFrame(),errorMessage,"Some error occurred.",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        /*if(e.getSource() == mmValidate){
            if(new File("./src/UserData/"+ mmFileInputTF.getText()+".txt").isFile()) {
                mmStart.setEnabled(true);
            }else{
                if(!(new File("./src/UserData/"+ defaultFile +".txt").isFile())){
                    JOptionPane.showMessageDialog(new JFrame(),"The default file is missing!","404",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(new JFrame(),"No such file found.\n If left blank it will default to: \""+defaultFile+"\"","404",JOptionPane.INFORMATION_MESSAGE);
                    mmStart.setEnabled(true);
                }
            }
        }*/else if(e.getSource() == mmStart) {
            switchMenu(2);
            ExercisingLogic.startExercising();
        }else if(e.getSource() == exDone){
            ExercisingLogic.continueExLogic();
            //System.out.println("here");
        }
    }

    private void initiateM1(){
        mmFileInput = new JLabel("Input the name of the file to be loaded: ");
        mmFileInput.setSize(400,60);
        mmFileInput.setLocation(10,10);
        mmFileInput.setToolTipText("if left blank it will default to\""+defaultFile+"\"");
        mmFileInput.setFont(new Font(Font.SERIF,Font.PLAIN,20));
        mmFileInput.setHorizontalAlignment(JLabel.RIGHT);

        mmNrOfSets = new JLabel("Input the nr of sets you want to do: ");
        mmNrOfSets.setToolTipText("if left blank / is invalid it will default to: "+defaultNrOfSets);
        mmNrOfSets.setFont(mmFileInput.getFont());
        mmNrOfSets.setSize(mmFileInput.getSize());
        mmNrOfSets.setHorizontalAlignment(JLabel.RIGHT);
        mmNrOfSets.setLocation(10,10 + 60 + 10);

        mmFileInputTF = new JTextField();
        mmFileInputTF.setFont(mmFileInput.getFont());
        mmFileInputTF.setLocation(410,10);
        mmFileInputTF.setSize(200,60);

        mmNrOfSetsTF = new JTextField();
        mmNrOfSetsTF.setFont(mmFileInput.getFont());
        mmNrOfSetsTF.setLocation(410,10 + 60 + 10);
        mmNrOfSetsTF.setSize(200,60);

        mmTimeBetweenSets = new JLabel("Input the rest time before each set (seconds):");
        mmTimeBetweenSets.setToolTipText("if left blank / is invalid it will default to: "+defaultRestTimeSets+" seconds");
        mmTimeBetweenSets.setFont(mmFileInput.getFont());
        mmTimeBetweenSets.setSize(mmFileInput.getSize());
        mmTimeBetweenSets.setHorizontalAlignment(JLabel.RIGHT);
        mmTimeBetweenSets.setLocation(10,10 + (60 + 10)*2);
//
        mmTimeBetweenSetsTF = new JTextField();
        mmTimeBetweenSetsTF.setFont(mmFileInput.getFont());
        mmTimeBetweenSetsTF.setLocation(410,10 + (60 + 10)*2);
        mmTimeBetweenSetsTF.setSize(200,60);

        mmValidate = new JButton();
        mmValidate.setSize(600,60);
        mmValidate.setFont(mmFileInput.getFont());
        mmValidate.setText("Validate imputed data.");
        mmValidate.setLocation(10,10+(60+10)*3);
        mmValidate.addActionListener(this);

        mmStart = new JButton();
        mmStart.setSize(600,60);
        mmStart.setFont(mmFileInput.getFont());
        mmStart.setText("Start exercising.");
        mmStart.setLocation(10,10+(60+10)*4);
        mmStart.setEnabled(false);
        mmStart.addActionListener(this);

        mainMenu = new ArrayList<>(Arrays.asList(mmFileInput, mmNrOfSets, mmStart,
                mmFileInputTF, mmValidate, mmNrOfSetsTF, mmTimeBetweenSets, mmTimeBetweenSetsTF));
        //for(int i=0;i<menu1.size();i++){
        //    menu1.get(i).addKeyListener(KL);
        //}
    }

    private void initiateM2(){
        exExTitle = new JLabel();
        exExTitle.setLocation(0,10);
        exExTitle.setSize(640,100);
        exExTitle.setText("Placeholder title");
        exExTitle.setHorizontalAlignment(JLabel.CENTER);
        exExTitle.setFont(new Font("Arial",Font.PLAIN,70));

        exExDescription = new JLabel();
        exExDescription.setLocation(0,120);
        exExDescription.setText("Placeholder description");
        exExDescription.setSize(640,50);
        exExDescription.setHorizontalAlignment(JLabel.CENTER);
        exExDescription.setFont(new Font("Arial",Font.PLAIN,20));

        exCounter = new JLabel();
        exCounter.setText("Placeholder ct");
        exCounter.setSize(640,240);
        exCounter.setLocation(0,180);
        exCounter.setHorizontalAlignment(JLabel.CENTER);
        exCounter.setVerticalAlignment(JLabel.CENTER);
        exCounter.setFont(new Font("Arial",Font.PLAIN,100));

        exDone = new JButton();
        exDone.setSize(600,40);
        exDone.setFont(mmFileInput.getFont());
        exDone.setText("Done.");
        exDone.setLocation(10,240+180);
        exDone.addActionListener(this);
        exDone.setVisible(false);



        exerciseMenu = new ArrayList<>(Arrays.asList(exExTitle, exCounter, exExDescription, exDone));
        //for(int i=0;i<menu2.size();i++){
        //    menu2.get(i).addKeyListener(KL);
        //}
    }

    public static void switchMenu(int to){
        List<Component> toMenu = null;
        switch(to) {
            case 1:toMenu = mainMenu;break;
            case 2:toMenu = exerciseMenu;break;
        }
        window.getContentPane().removeAll();
        for(int i=0;i<toMenu.size();i++){
            window.add(toMenu.get(i));
        }
        window.update(window.getGraphics());
    }

    public static void updateTextFiled(TextFiledName filedName,String updateTo){
        switch (filedName){
            case EXMENU_ExTitle: exExTitle.setText(updateTo);break;
            case EXMENU_Counter: exCounter.setText(updateTo);break;
            case EXMENU_ExDescription: exExDescription.setText(updateTo);break;
        }
        window.update(window.getGraphics());
    }

    public static void EnableDisableDoneButton(boolean bool){
        exDone.setVisible(bool);
    }

    public static String getFilePath(){
        if(!mmFileInputTF.getText().isEmpty())
            return "./src/UserData/"+ mmFileInputTF.getText()+".txt";
        return "./src/UserData/"+defaultFile+".txt";
    }

    public static int getTimeBetweenSets(){
        if(!mmTimeBetweenSetsTF.getText().isEmpty()){
            return Integer.getInteger(mmTimeBetweenSetsTF.getText());
        }
        return defaultRestTimeSets;
    }

    public static int getNumberOfSets(){
        if(!mmNrOfSetsTF.getText().isEmpty()){
            return Integer.getInteger(mmNrOfSetsTF.getText());
        }
        return defaultNrOfSets;
    }
}
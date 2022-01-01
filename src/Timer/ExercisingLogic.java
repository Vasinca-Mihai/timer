package Timer;

import ext_lib.tinysound.Sound;
import ext_lib.tinysound.TinySound;

import java.io.File;
import java.util.List;

public class ExercisingLogic {
    private static Sound sound_start;
    private static Sound sound_stop;
    private static Sound sound_beep;
    private static double volume = 1;
    private static boolean localCheck = true;
    private static int exerciseNr =0;
    private static List<Excercice> set;

    public static void startExercising(){
        Set.readSet(InterfaceManager.getFilePath());
        set = Set.getSet();
        //interfaceManager = InterfaceManager.getInstance();
        TinySound.init();
        SoundLoader.setSet(set);
        //dir referance
        sound_start = TinySound.loadSound(new File("./src/Resources/Sounds/start2.wav"));
        sound_stop = TinySound.loadSound(new File("./src/Resources/Sounds/stop2.wav"));
        sound_beep = TinySound.loadSound(new File("./src/Resources/Sounds/beep.wav"));

        for(int i=InterfaceManager.getNumberOfSets();i>0;i--){
            InterfaceManager.updateTextFiled(TextFiledName.EXMENU_ExDescription,"");
            InterfaceManager.updateTextFiled(TextFiledName.EXMENU_ExTitle,"Rest");
            interruptedSleepSeconds(InterfaceManager.getTimeBetweenSets());
            goTroughExercises();
        }
        terminateProgram();
    }
    public static void interruptedSleepSeconds(int seconds){
        for(int i=seconds;i>0;i--){
            InterfaceManager.updateTextFiled(TextFiledName.EXMENU_Counter,i+" s");
            //System.out.println("seconds remaining: "+i);
            if(i <6) {
                sound_beep.play(volume);
            }
            sleep(1000);
        }
    }

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){e.printStackTrace();}
    }
    public static void goTroughExercises(){
        //Scanner s = new Scanner(System.in);
        //for(int i=0; i< 2 /*ex.size()*/;i++){
            sleep(2000);
            set.get(exerciseNr).getSoundFile().play(volume);
            //System.out.println("\tNext exercise: "+ex.get(i).getExName());
            //System.out.println("\t"+ex.get(i).getExDesc());
            InterfaceManager.updateTextFiled(TextFiledName.EXMENU_ExTitle,set.get(exerciseNr).getExName());
            InterfaceManager.updateTextFiled(TextFiledName.EXMENU_ExDescription,set.get(exerciseNr).getExDesc());

            interruptedSleepSeconds(set.get(exerciseNr).getRestTime() - 2);
            sound_start.play(volume);
            if(set.get(exerciseNr).isInTime()) {
                interruptedSleepSeconds(set.get(exerciseNr).getExeWork());
                sound_stop.play(volume);
                exerciseNr++;
                if(exerciseNr<set.size()){
                    goTroughExercises();
                }
                if(exerciseNr>=set.size()){
                    //terminateProgram();
                }
            }else {
                InterfaceManager.EnableDisableDoneButton(true);
                InterfaceManager.updateTextFiled(TextFiledName.EXMENU_Counter,"Reps: "+set.get(exerciseNr).getExeWork());
                //System.out.println("Please press enter once done");
                //localCheck = true;
                //while (localCheck){
                    //try {
                    //    Thread.sleep(1000);
                    //}catch (InterruptedException e){e.printStackTrace();}
                    //System.out.println("here");
                //}
                //InterfaceManager.EnableDisableDoneButton(false);
                //s.nextLine();
            }

        //}
    }

    public static void terminateProgram(){
        sleep(1000);
        TinySound.shutdown();
    }
    public static void setVolume(double v){
        volume = v;
    }

    public static void continueExLogic(){
        sound_stop.play(volume);
        InterfaceManager.EnableDisableDoneButton(false);
        exerciseNr++;
        if(exerciseNr<set.size()){
            goTroughExercises();
        }
        if(exerciseNr>=set.size()){
            terminateProgram();
        }

    }
}
//in action listener to change local check
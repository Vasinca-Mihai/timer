package Timer;

import ext_lib.tinysound.Sound;
import ext_lib.tinysound.TinySound;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class ExercisingLogic {
    private static Sound sound_start;
    private static Sound sound_stop;
    private static Sound sound_beep;
    private static double volume = 1;
    //private static InterfaceManager interfaceManager;

    public static void startExercising(){
        List<Excercice> set = Set.getSet();
        //interfaceManager = InterfaceManager.getInstance();
        TinySound.init();
        SoundLoader.setSet(set);
        sound_start = TinySound.loadSound(new File("./src/Resources/Sounds/start2.wav"));
        sound_stop = TinySound.loadSound(new File("./src/Resources/Sounds/stop2.wav"));
        sound_beep = TinySound.loadSound(new File("./src/Resources/Sounds/beep.wav"));

        goTroughExercises(set);

        sleep(1000);
        TinySound.shutdown();
    }
    public static void interruptedSleepSeconds(int seconds){
        for(int i=seconds;i>0;i--){
            InterfaceManager.updateTextFiled(TextFiledName.M2_Counter,i+" s");
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
    public static void goTroughExercises(List<Excercice> ex){
        Scanner s = new Scanner(System.in);
        for(int i=0; i< 2 /*ex.size()*/;i++){
            sleep(2000);
            ex.get(i).getSoundFile().play(volume);
            //System.out.println("\tNext exercise: "+ex.get(i).getExName());
            //System.out.println("\t"+ex.get(i).getExDesc());
            InterfaceManager.updateTextFiled(TextFiledName.M2_ExTitle,ex.get(i).getExName());
            InterfaceManager.updateTextFiled(TextFiledName.M2_ExDescription,ex.get(i).getExDesc());

            interruptedSleepSeconds(ex.get(i).getRestTime() - 2);
            sound_start.play(volume);
            if(ex.get(i).isInTime()) {
                interruptedSleepSeconds(ex.get(i).getExeWork());
            }else {
                InterfaceManager.updateTextFiled(TextFiledName.M2_Counter,"Reps: "+ex.get(i).getExeWork());
                System.out.println("Please press enter once done");
                //s.nextLine();
            }
            sound_stop.play(volume);
        }
    }
    public static void setVolume(double v){
        volume = v;
    }
}
//in action listener add a nextEx method and if the ex is automated call it after wqait
//next ex repalces go trough ex and is recurring (sefl call)
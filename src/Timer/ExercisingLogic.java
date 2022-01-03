package Timer;

import ext_lib.tinysound.Sound;
import ext_lib.tinysound.TinySound;

import java.io.File;
import java.util.List;

public class ExercisingLogic extends Thread{
    private static Sound sound_start;
    private static Sound sound_stop;
    private static Sound sound_beep;
    private static double volume = 1;
    private static int exerciseNr =0;
    private static List<Excercice> set;

    @Override
    public void run(){
        startExercising();
    }

    public static void startExercising(){
        Set.readSet(InterfaceManager.getFilePath());
        set = Set.getSet();
        TinySound.init();
        SoundLoader.setSet(set);
        sound_start = TinySound.loadSound(new File(UniversalVar.soundsFilepath+"start2.wav"));
        sound_stop = TinySound.loadSound(new File(UniversalVar.soundsFilepath+"stop2.wav"));
        sound_beep = TinySound.loadSound(new File(UniversalVar.soundsFilepath+"beep.wav"));

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
            sleep(2000);
            set.get(exerciseNr).getSoundFile().play(volume);
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
                //if(exerciseNr>=set.size()){
                    //terminateProgram();
                //}
            }else {
                InterfaceManager.EnableDisableDoneButton(true);
                InterfaceManager.updateTextFiled(TextFiledName.EXMENU_Counter,"Reps: "+set.get(exerciseNr).getExeWork());
                while (UniversalVar.getDoneCheck()){
                    //System.out.println("here");
                    sleep(500);
                }
                UniversalVar.setDoneCheck(true);
                continueExLogic();
            }


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
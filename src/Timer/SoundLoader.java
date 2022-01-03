package Timer;

import ext_lib.tinysound.TinySound;

import java.io.File;
import java.util.List;

public class SoundLoader {
    static List<Excercice> set;
    private static void initiateSounds(){
        for(int i=0;i< set.size();i++){
            set.get(i).setSoundFile(TinySound.loadSound(
                    new File(UniversalVar.soundsFilepath+set.get(i).getExName()+".wav")));
            //here are referenced sound data
        }
    }

    public static void setSet(List<Excercice> set) {
        SoundLoader.set = set;
        initiateSounds();
    }
}

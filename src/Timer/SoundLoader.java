package Timer;

import ext_lib.tinysound.Sound;
import ext_lib.tinysound.TinySound;

import java.io.File;
import java.util.List;

public class SoundLoader {
    static List<Excercice> set;
    private static void initiateSounds(){
        for(int i=0;i< set.size();i++){
            set.get(i).setSoundFile(TinySound.loadSound(
                    new File("./src/Resources/Sounds/"+set.get(i).getExName()+".wav")));
        }
    }

    public static void setSet(List<Excercice> set) {
        SoundLoader.set = set;
        initiateSounds();
    }
}

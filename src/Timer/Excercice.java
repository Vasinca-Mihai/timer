package Timer;

import ext_lib.tinysound.Sound;

import java.io.File;

public class Excercice {
    private int exeTime;
    private int restTime;
    private String exName;
    private String exDesc;
    private Sound soundFile;
    private boolean inTime;

    public Excercice(boolean inTime, int exeTime, int restTime, String exName, String exDesc) {
        this.exeTime = exeTime;
        this.restTime = restTime;
        this.exName = exName;
        this.exDesc = exDesc;
        this.inTime = inTime;
    }

    public int getExeTime() {
        return exeTime;
    }

    public int getRestTime() {
        return restTime;
    }

    public String getExName() {
        return exName;
    }

    public String getExDesc() {
        return exDesc;
    }

    public Sound getSoundFile() {
        return soundFile;
    }

    public boolean isInTime() {
        return inTime;
    }

    public void setSoundFile(Sound soundFile) {
        this.soundFile = soundFile;
    }
}

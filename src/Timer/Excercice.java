package Timer;

import ext_lib.tinysound.Sound;

public class Excercice {
    private int exeWork;
    private int restTime;
    private String exName;
    private String exDesc;
    private Sound soundFile;
    private boolean inTime;

    public Excercice(boolean inTime, int exeTime, int restTime, String exName, String exDesc) {
        this.exeWork = exeTime;
        this.restTime = restTime;
        this.exName = exName;
        this.exDesc = exDesc;
        this.inTime = inTime;
    }

    public int getExeWork() {
        return exeWork;
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

    public String toString(){
        return "in time: "+inTime+", ex name: "+exName+", ex time:" +exeWork+", ex rest: "+restTime+"\n"+exDesc;
    }
}

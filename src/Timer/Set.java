package Timer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Set {
    private static List<Excercice> ex = new ArrayList<Excercice>(Arrays.asList(
            (new Excercice(false,45,15,"Butt kicks","pe loc duci un picior la fund apoi pe celalat")),
            (new Excercice(true,45,15,"Burpees","Americane")),
            (new Excercice(true,45,15,"Jumping jacks","fluturasi")),
            (new Excercice(true,45,15,"Switching lunges","fandare pe stanga apoi dreapta")),
            (new Excercice(true,45,15,"Squat taps","genoflexiuni cu atins solul")),
            (new Excercice(true,45,15,"Mountain climbers","alergare pe loc in pos de flotare")),
            (new Excercice(true,45,15,"Shoulder to shoulder","death")),
            (new Excercice(true,45,15,"Seated in and out","")),
            (new Excercice(true,45,15,"Leg flutters","")),
            (new Excercice(true,45,15,"Bicycles",""))
    ));
    public static List<Excercice> getSet(){return ex;}
}

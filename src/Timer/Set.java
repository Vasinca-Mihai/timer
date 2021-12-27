package Timer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

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

    public static void readSet(String file){
        Scanner scanner = null;

        try{
            scanner = new Scanner(new BufferedReader(new FileReader(file)));
        }catch (FileNotFoundException e){e.printStackTrace();}
        List<Excercice> set = new ArrayList<>();
        if(scanner != null){
            scanner.useDelimiter(":");
            while (scanner.hasNext()){
                set.add(new Excercice(scanner.nextBoolean(),
                        scanner.nextInt(),
                        scanner.nextInt(),//"",""));
                        scanner.next(),
                        scanner.next()));
                /*
                System.out.println(scanner.nextBoolean());
                System.out.println(scanner.nextInt());
                System.out.println(scanner.nextInt());
                System.out.println(scanner.next());
                System.out.println(scanner.next());*/
                //try {
                //    Thread.sleep(100);
                //}catch (InterruptedException e){e.printStackTrace();}
                //System.out.println(set);
                if(scanner.hasNextLine()){
                   scanner.nextLine();
                }
            }
            scanner.close();
        }


        //reading logic
        //System.out.println(set.get(0));
        //System.out.println(set.get(1));
        //System.out.println(set.get(2));
        ex = set;

    }
}

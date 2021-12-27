package test;

import Timer.Set;
import Timer.Excercice;

import java.util.List;

public class MyFrame {
    public static void main(String[] args) {
        Set.readSet("./src/UserData/rus.txt");
        List<Excercice> set = Set.getSet();
        for(int i=0;i<set.size();i++){
            System.out.println(set.get(i));
        }
    }
}

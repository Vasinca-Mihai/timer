package test;

import Timer.Set;
import Timer.Excercice;
import Timer.UniversalVar;

import java.util.List;

public class MyFrame {
    public static void main(String[] args) {
        Set.readSet(UniversalVar.setFilePath+"default.txt");
        //referance to file path
        List<Excercice> set = Set.getSet();
        for(int i=0;i<set.size();i++){
            System.out.println(set.get(i));
        }
    }
}

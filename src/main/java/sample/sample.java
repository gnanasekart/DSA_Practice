package sample;

import java.util.ArrayList;

public class sample {

    public static void main(String[] args) {
       // System.gc();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(-1);
        list.get(1);
        list.add(2,5);

        list.remove(1);

    }
}

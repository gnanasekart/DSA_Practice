package sample;

import java.util.*;

public class QueueSample {

    public static void main(String[] args) {

        String s = "()[]{}";
//        Map<Character, Character> map = new HashMap<>();
//        map.put(')', '(');
//        map.put('}', '{');
//        map.put(']', '[');



        //     Stack<Character> st = new Stack<>();
//        for(Character c: s.toCharArray()){
//            if(c==')' || c=='}'|| c==']'){
//                st.pop();
//            }else st.push(c);
//        }

//        for(Character c: s.toCharArray()){
//            st.push(c);
//        }
//
//        while(!st.isEmpty()){
//
//        }


        //String s = "ab#c", t = "ad#c";
        //String s = "ab##", t = "c#d#";
        //String s = "a#c", t = "b";
//        String s = "a##c", t="#a#c";
//        Stack<Character> st = new Stack<>();
//        for(Character c: s.trim().toCharArray()){
//            if(c=='#'){
//                if(!st.isEmpty())
//                    st.pop();
//            }else{
//                st.push(c);
//            }
//        }
//        Stack<Character> st2 = new Stack<>();
//        for(Character c: t.trim().toCharArray()){
//            if(c=='#'){
//                if (!st2.isEmpty())
//                    st2.pop();
//            }else{
//                st2.push(c);
//            }
//        }
//        if(Arrays.equals(st.toArray(),st2.toArray() )){
//            System.out.println(true);
//        }else System.out.println(false);


//        List<String> l= Arrays.asList("5","2","C","D","+");
        List<String> l= Arrays.asList("5","-2","4","C","D","9","+","+");


        Stack<String> st = new Stack<>();
        for(String ss: l){
            if(ss=="C"){
                st.pop();
            }else if(ss=="D"){
                String t =st.peek();
                int a = Integer.parseInt(t)*2;
                st.push(a+"");
            }else if(ss=="+"){
                int first = Integer.parseInt(st.pop());
                int second = Integer.parseInt(st.pop());
                st.push(second+"");
                st.push(first+"");
                st.push((first+second)+"");
            }else{
                st.push(ss);
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=Integer.parseInt(st.pop());
        }
        System.out.println(sum);
    }
}

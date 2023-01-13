package HackerRank_Daily_Practice.Array;

import org.testng.Assert;
import org.testng.annotations.Test;

public class P_I_Securing_Message {


    @Test
    public void ex1(){
    String name = "gnana Sekar";
        Assert.assertEquals(getEncryptedName(name), "gnana sekar");
    }

    @Test
    public void ex2(){
        String name = "gnana Sekar";
        Assert.assertEquals(getEncryptedName(name), "rakes anang");
    }

    @Test
    public void ex3(){
        String name = "gnanasekar";
        Assert.assertEquals(getEncryptedName(name), "rakesanang");
    }


    private String getEncryptedName(String name){

        if(new Validator().validator(name)){
            String lower = new String(name).toLowerCase();
            StringBuilder sb = new StringBuilder(lower).reverse();
            return sb.toString();
        }else{
            throw new IllegalArgumentException("Try again with valid name");
        }
    }

class Validator{
    public boolean validator(String name){
        for(char ch : name.toCharArray()){
            if(ch!=' ' && !(Character.isLowerCase(ch) || Character.isUpperCase(ch))){
                return false;
            }
        }
        return true;
    }
}

}

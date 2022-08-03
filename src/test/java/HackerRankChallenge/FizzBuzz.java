package HackerRankChallenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FizzBuzz {
	public static void Fb(int i){
	    if(i%3==0 && i%5==0){
	        System.out.println("FizzBuzz");
	    }else if(i%3==0 && i%5!=0){
	        System.out.println("Fizz");
	    }else if(i%3!=0 && i%5==0){
	        System.out.println("Buzz");
	    }else if(i%3!=0 && i%5!=0){
	        System.out.println(i);
	    }
	}

	    public static void fizzBuzz(int n) {
	        for(int i=1; i<=n; i++){
	        Fb(i);    
	        }
	        
	    }

	

	    public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        int n = Integer.parseInt(bufferedReader.readLine().trim());

	        FizzBuzz.fizzBuzz(n);

	        bufferedReader.close();
	    }
	
}

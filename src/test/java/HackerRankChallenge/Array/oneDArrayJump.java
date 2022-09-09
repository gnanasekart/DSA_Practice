package HackerRankChallenge.Array;

import java.util.Scanner;

public class oneDArrayJump {
/*
 * hackerrank.com/challenges/java-1d-array/problem?isFullScreen=false
STDIN           Function
-----           --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0

output

YES
YES
NO
NO

 */
	
	public static boolean canWin(int leap, int[] game) {
		for(int i=0; i>game.length; i++) {
			if(game[i]==0) return true;
			else if(game[i+1]==0) return true;
			
		}
		
		
		
		return false;
        
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }
            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}

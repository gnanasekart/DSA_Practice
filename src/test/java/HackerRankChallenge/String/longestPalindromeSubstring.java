package HackerRankChallenge.String;

import org.testng.annotations.Test;

public class longestPalindromeSubstring {

	@Test
	public void ex() {
		String s = "babad";
		System.out.println(longestPalindrome(s));

	}

	public String longestPalindrome(String s) {
		int i=0;
		while(s.length()>i) {
		if (s == null || s.length()==0) return "";
		else if(s.length()==1) return s;
		String sub ="", rev="";
		StringBuffer sb = new StringBuffer();
		for (int L=0; L<s.length(); L++) {
			for(int R=L+1; R<s.length(); R++) {
				sub = s.substring(L, R);
				rev = sb.replace(0, sb.length(), "")
						.append(sub.substring(0, sub.length())).reverse().toString();

				if(sub.equals(rev) && sub.length()>=1) {
					return sub;
				}
			}
		}
		i++;
		return sub;
	}
		return s;
		
	}

}
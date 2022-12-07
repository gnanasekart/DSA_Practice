package LeetCode_Daily_Practice.Collection.String;

public class No_Of_Char_Remove_to_make_Anagram {

    public static void main(String[] args)
    {
        String s = "steps";
        String t = "steka";
        int count1[] = new int[26];
        int count2[] = new int[26];
        for(int i=0; i<26; i++)
        {
            count1[i]=0;
            count2[i]=0;
        }
        for (int i=0; i<s.length(); i++)
        {
            count1[s.charAt(i)-'a']++;
        }
        for (int i=0; i<t.length(); i++)
        {
            count2[t.charAt(i)-'a']++;
        }
        int ans=0;
        for(int i=0;i<26; i++)
        {
            ans+=Math.abs(count1[i]-count2[i]);
        }
        System.out.println(ans);
    }
}

package LeetCode_Daily_Practice.Collection.String;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class P_E_2_N1_Unique_Email_Address {
   /*
    leetcode.com/problems/unique-email-addresses/

    Every valid email consists of a local name and a domain name, separated by the '@' sign.
    Besides lowercase letters, the email may contain one or more '.' or '+'.

    For example, in "alice@leetcode.com", "alice" is the local name,
    and "leetcode.com" is the domain name.
    If you add periods '.' between some characters in the local name part of an email address,
    mail sent there will be forwarded to the same address without dots in the local name.
    Note that this rule does not apply to domain names.

    For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    If you add a plus '+' in the local name, everything after the first plus sign will be ignored.
    This allows certain emails to be filtered. Note that this rule does not apply to domain names.

    For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    It is possible to use both of these rules at the same time.

    Given an array of strings emails where we send one email to each emails[i],
    return the number of different addresses that actually receive mails.

 Constraints:
    1 <= emails.length <= 100
    1 <= emails[i].length <= 100
    emails[i] consist of lowercase English letters, '+', '.' and '@'.
    Each emails[i] contains exactly one '@' character.
    All local and domain names are non-empty.
    Local names do not start with a '+' character.
    Domain names end with the ".com" suffix.

*/
    @Test
    public void example1(){
        String[] s = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Assert.assertEquals(uniqueEmail(s), 2);
    }

    @Test
    public void example2(){
        String[] s =  {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
        Assert.assertEquals(uniqueEmail(s), 3);
    }

    @Test
    public void example3(){
        String[] s = {"test.emailalex@leetcode.com","test.e.mailbob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        Assert.assertEquals(uniqueEmail(s), 3);
    }
    //[]

/*
Pseudo Code
1. split the email with @ symbol
2. replace the dot symbol
3. get the index of + and concat with domain name
4. add the conceited email address into set
*/

    private int uniqueEmail(String[] emails){
        if(emails.length < 1) return 0;

        int plusIndex=0, atIndex=0;
        String newEmail = "", removedot="";
        String[] splitat = {}, splitplus = {};
        Set<String> diffEmail = new HashSet<>();
        for(String email: emails){
            splitat = email.split("@");
            removedot = splitat[0].replace(".", "");
            atIndex = email.indexOf("@");
            if(removedot.contains("+")){
                splitplus = removedot.split("\\+");
                newEmail = splitplus[0]+email.substring(atIndex, email.length());
            }else{
                newEmail = removedot+ email.substring(atIndex, email.length());
            }
            diffEmail.add(newEmail);
        }
        return diffEmail.size();
    }

}

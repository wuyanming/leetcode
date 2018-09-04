package StringSummary;

import java.util.ArrayList;
import java.util.List;

public class IntegertoRoman_12 {
    public  String intToRoman(int num) {

        String M[] = {"", "M", "MM", "MMM"}; //0,1000,2000,3000
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0,100,200,300---900
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//0,10,20,30---90
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//0,1,2,3----9

        return M[num / 1000] + C[(num % 1000) / 100] + X[(num % 100) / 10] + I[num % 10];
    }

    //Input: 1994
    //Output: "MCMXCIV"
    //Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


   /* static List<String> romanizer(List<Integer> numbers) {
        List<String> listResult = new ArrayList<>();
        for(int i =0; i< numbers.size();i++){

            String M[] = {"", "M", "MM", "MMM"}; //0,1000,2000,3000
            String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0,100,200,300---900
            String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//0,10,20,30---90
            String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//0,1,2,3----9

            String singleResult = M[numbers.get(i) / 1000] + C[(numbers.get(i)  % 1000) / 100] + X[(numbers.get(i)  % 100) / 10] + I[numbers.get(i)  % 10];
            listResult.add(singleResult);
            return listResult;
        }*/

}



package HighFrequence.Summary;

import java.util.HashSet;
import java.util.Set;

public class MaximumXORofTwoNumbersinanArray421 {

//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/discuss/91049/Java-O(n)-solution-using-bit-manipulation-and-HashMap
//I think most people who find it hard to understand the code is stuck on this line if(set.contains(tmp ^ prefix))
//The tricky part here is that we need to be aware of a key property of XOR applying on the above line: if A ^ B = C, then A ^ B ^ B = C ^ B, then A = C ^ B
//Before executing that line, max stands for the maximum we can get if we consider only the most significant i - 1 bits, tmp stands for the potential max value we can get when considering the most significant i bits. How can we get this tmp? The only way we can get this value is that we have two values A and B in the set (a set of most significant i bits of each member), such that A ^ B equals to tmp. As mentioned earlier, A ^ B = tmp is equivalent to A = tmp ^ B. Here is where that line comes in: set.contains(tmp ^ B).
//BTW, though this is a great solution, it is actually faulty if the input contains negative numbers (though not required by the problem itself) as i starts from 31 instead of 30. It would be a perfect solution if the input is unsigned int instead.

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;

        for (int i = 31; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();

            for (int num : nums) {
                set.add(num & mask);
            }

            int tmp = max | (1 << i);

            for (int prefix : set) {
                if (set.contains(tmp ^ prefix)) {
                    max = tmp;
                    break;
                }
            }

        }

        return max;
    }

    //I just need to dumb down the problem for myself. For me, I understand the problem like this, the question is asking you to find the max XOR of any 2 numbers, here's an example of the biggest XOR, my understanding is...make the result all 1s..eg,
    //1111 ^ 0000 = 1111 (15 ^ 0 = 15)
    //The part confused me the most is the,
    //int tmp = max | (1 << i);and
    //if(set.contains(tmp ^ prefix))
    //I treat tmp as the current "guessed new max" (not yet confirmed), which is the "old max which we have confirmed before" OR-ing "1 << i", this basically means "let's enable 1 more bit from the "confirmed max we found from last time".
    //Since we made a guess of the "new max" denoted as tmp. Then what do we need to do with it? I see people commenting,
    //0^0=0
    //[0^1=1]
    //[1^0=1]
    //1^1=0
    //I KNOW THAT, but, what does it have to do with the question? SOOOO, basically what they are trying to say is...TO MAXIMIZE your solution, you want the result to be "1". In the case of tmp which we enabled the new bit to be "1", now all we need to do is to find a number in the set that has "0" on this bit, then we can confirm that there are at least 2 numbers in the set who's XOR result can achieve our "guessed new max". If those numbers exist, then we have CONFIRMED that our "guessed new max" IS the current max.
    //To summarize 2) OG used "tmp ^ prefix", this means that "if if we enable 1 more bit for max (guessed max), is there a number out there that has a 0 on this bit?" If this exist, then that means our "guess of the new max" is achievable.
    //Just a reminder to my future self if I come across this problem again. If I'm confusing you more, please move on other comments. Please learn better markdown :P


    //I know some people may still be confused after reading this amazing code,
    // I will put my explanation here with more lines of code to avoid confusion.
    public int findMaximumXORSec(int[] nums) {
        int maxResult = 0;
        int mask = 0;

        /*The maxResult is a record of the largest XOR we got so far. if it's 11100 at i = 2, it means
        before we reach the last two bits, 11100 is the biggest XOR we have, and we're going to explore
        whether we can get another two '1's and put them into maxResult

        This is a greedy part, since we're looking for the largest XOR, we start
        from the very begining, aka, the 31st postition of bits. */
        for (int i = 31; i >= 0; i--) {

            //The mask will grow like  100..000 , 110..000, 111..000,  then 1111...111
            //for each iteration, we only care about the left parts
            mask = mask | (1 << i);

            Set<Integer> set = new HashSet<>();
            for (int num : nums) {

/*                we only care about the left parts, for example, if i = 2, then we have
                {1100, 1000, 0100, 0000} from {1110, 1011, 0111, 0010}*/
                int leftPartOfNum = num & mask;
                set.add(leftPartOfNum);
            }

            // if i = 1 and before this iteration, the maxResult we have now is 1100,
            // my wish is the maxResult will grow to 1110, so I will try to find a candidate
            // which can give me the greedyTry;
            int greedyTry = maxResult | (1 << i);

            for (int leftPartOfNum : set) {
                //This is the most tricky part, coming from a fact that if a ^ b = c, then a ^ c = b;
                // now we have the 'c', which is greedyTry, and we have the 'a', which is leftPartOfNum
                // If we hope the formula a ^ b = c to be valid, then we need the b,
                // and to get b, we need a ^ c, if a ^ c exisited in our set, then we're good to go
                int anotherNum = leftPartOfNum ^ greedyTry;
                if (set.contains(anotherNum)) {
                    maxResult = greedyTry;
                    break;
                }
            }

            // If unfortunately, we didn't get the greedyTry, we still have our max,
            // So after this iteration, the max will stay at 1100.
        }

        return maxResult;
    }
}

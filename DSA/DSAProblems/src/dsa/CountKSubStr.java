package dsa;

// Java program to CountKSubStr number of substrings
// with exactly distinct characters in a given string
import java.util.Arrays;

public class CountKSubStr
{
    // Function to count number of substrings
    // with exactly k unique characters
    int countkDist(String str, int k)
    {
        // Initialize result
        int res = 0;

        int loopCount = 0;

        int n = str.length();

        // To store count of characters from 'a' to 'z'
        int cnt[] = new int[26];

        // Consider all substrings beginning with
        // str[i]
        for (int i = 0; i < n; i++)
        {
            loopCount++;
            int dist_count = 0;

            // Initializing count array with 0
            Arrays.fill(cnt, 0);

            // Consider all substrings between str[i..j]
            for (int j=i; j<n; j++)
            {
                loopCount++;
                // If this is a new character for this
                // substring, increment dist_count.
                System.out.println(str.charAt(j)+" "+(str.charAt(j) - 'a'));
                if (cnt[str.charAt(j) - 'a'] == 0)
                    dist_count++;

                // Increment count of current character
                cnt[str.charAt(j) - 'a']++;

                // If distinct character count becomes k,
                // then increment result.
                if (dist_count == k)
                    res++;

                // If distinct character count greater than k
                // then break this substring
                if(dist_count > k)
                   break;
            }
        }
        System.out.println("Loop Count: "+loopCount);
        return res;
    }

    // Driver Program
    public static void main(String[] args)
    {
        CountKSubStr ob = new CountKSubStr();
        String ch = "abcca";
        int k = 2;
        System.out.println("Total substrings with exactly " +
                k + " distinct characters : "
                + ob.countkDist(ch, k));
    }
}

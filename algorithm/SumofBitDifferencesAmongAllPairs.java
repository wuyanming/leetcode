package BasicConcepts;

public class SumofBitDifferencesAmongAllPairs {
    static int sumBitDifferences(int arr[], int n) {
        int ans = 0; // Initialize result

        // traverse over all bits
        for (int i = 0; i < 32; i++) {

            // count number of elements with i'th bit set
            int count = 0;

            for (int j = 0; j < n; j++)
                if ((arr[j] & (1 << i)) == 0)
                    count++;

            // Add "count * (n - count) * 2"
            // to the answer
            ans += (count * (n - count) * 2);
        }

        return ans;
    }

    // Driver prorgram
    public static void main(String args[]) {

        int arr[] = {1, 3, 5};
        int n = arr.length;

        System.out.println(sumBitDifferences(arr, n));
    }
}

import java.util.Arrays;

public class LeetCode1619 {

    public static final String URL = "https://leetcode.cn/problems/mean-of-array-after-removing-some-elements/";

    public double trimMean(int[] arr) {

        int n = arr.length;
        Arrays.sort(arr);
        int partialSum = 0;
        for (int i = n / 20; i < 19 * n / 20; i++) {
            partialSum += arr[i];
        }
        return partialSum / (n * 0.9);

    }

}

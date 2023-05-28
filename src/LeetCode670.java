public class LeetCode670 {

    public static final String URL = "https://leetcode.cn/problems/maximum-swap/";

    public static void main(String[] args) {
        int t = 1993;
        LeetCode670 leetCode670 = new LeetCode670();
        System.out.println(leetCode670.maximumSwap(t));
    }

    public int maximumSwap(int num) {

        if (num < 10) {
            return num;
        }

        char[] chars = String.valueOf(num).toString().toCharArray();

        int l = 0;
        int r = 0;
        int c = -1;
        int rc = -1;

        int max = -1;
        int maxI = -1;

        while (l < chars.length) {

            if (chars[l] == '9') {
                l++;
                continue;
            }

            c = Integer.parseInt(String.valueOf(chars[l]));

            r = l + 1;

            while (r < chars.length) {
                rc =  Integer.parseInt(String.valueOf(chars[r]));
                if (rc > c & rc >= max) {
                    max = rc;
                    if (r >= maxI) {
                        maxI = r;
                    }
                }
                r++;
            }

            if (maxI > 0) {
                char temp = chars[l];
                chars[l] = chars[maxI];
                chars[maxI] = temp;
                return Integer.parseInt(String.valueOf(chars));
            }

            l++;
            max = -1;
            maxI = -1;
        }

        return num;

    }

}

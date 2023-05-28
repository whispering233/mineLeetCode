import java.util.*;
import java.util.stream.Collectors;

public class LeetCode672 {

    public static final String URL = "https://leetcode.cn/problems/bulb-switcher-ii/";

    public static void main(String[] args) {
        System.out.println(0 ^ 0);
        System.out.println(0 ^ 0 ^ 0);
    }

    // 当你觉得此代码写起来繁琐时，就不要往下写了，想清楚再写
    public int flipLights(int n, int presses) {
        Set<Integer> seen = new HashSet<Integer>();
        // 4种开关，偶数次按动复原
        // 故就只有16种组合
        for (int i = 0; i < 1 << 4; i++) {

            // 模拟灯泡开关情况
            int[] pressArr = new int[4];
            for (int j = 0; j < 4; j++) {
                pressArr[j] = (i >> j) & 1;
            }

            // 纯按动次数
            int sum = Arrays.stream(pressArr).sum();

            // 纯按动次数要 ≤ 实际按动次数
            // 并且，排除掉偶数次多余按动后，其奇偶性应该一致
            // 这里就是过滤掉 不可能出现的按动情况
            if (sum % 2 == presses % 2 && sum <= presses) {

                // 异或的本质在于找出 纯不同，相同的直接过滤掉

                // 只有一个灯泡
                int status = pressArr[0] ^ pressArr[1] ^ pressArr[3];

                // 两个灯泡以上
                // 等价于6个灯泡时
                if (n >= 2) {
                    status |= (pressArr[0] ^ pressArr[1]) << 1;
                }
                // 等价于 5个灯泡时
                if (n >= 3) {
                    status |= (pressArr[0] ^ pressArr[2]) << 2;
                }
                if (n >= 4) {
                    status |= (pressArr[0] ^ pressArr[1] ^ pressArr[3]) << 3;
                }
                seen.add(status);
            }
        }
        return seen.size();
    }

}

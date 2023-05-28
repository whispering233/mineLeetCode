package com.whispering.leetcode.question;

import java.util.ArrayList;
import java.util.List;

public class LeetCode857 {

    public static final String URL = "https://leetcode.cn/problems/minimum-cost-to-hire-k-workers/";


    public static void main(String[] args) {
        int[] q = new int[]{10, 20, 5};
        int[] w = new int[]{70, 50, 30};
        int k = 2;
        LeetCode857 leetCode857 = new LeetCode857();
        double v = leetCode857.mincostToHireWorkers(q, w, k);
        System.out.println(v);
        System.out.println(70.0 *  (10.0 / 20.0));
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {

        /*
        搜索问题，递归
         */

        if (k == 0) {
            return 0;
        }

        return searchWageGroup(quality, wage, k, 0, new ArrayList<Integer>());

    }

    public double searchWageGroup(int[] quality, int[] wage, int k, int layer, List<Integer> wageGroup) {

        if (k == 0) {
            return findMinCostBasedSelected(quality, wage, wageGroup);
        }

        double minV = Integer.MAX_VALUE;

        for (int i = layer; i < quality.length; i++) {

            wageGroup.add(i);

            double v = searchWageGroup(quality, wage, k - 1, i + 1, wageGroup);

            // 出递归之后要复原
            wageGroup.remove(wageGroup.size() - 1);

            if (v < minV) {
                minV = v;
            }
        }

        return minV;

    }

    public double findMinCostBasedSelected(int[] quality, int[] wage, List<Integer> wageGroup) {

        int k = wageGroup.size();

        double[] q = new double[k];
        double[] w = new double[k];

        for (int i = 0; i < k; i++) {

            q[i] = (double)quality[wageGroup.get(i)];
            w[i] = (double)wage[wageGroup.get(i)];
        }

        double min = Integer.MAX_VALUE;
        double sum = 0;

        outer: for (int i = 0; i < q.length; i++) {
            sum = 0;
            for (int j = 0; j < w.length; j++) {
                double r = (double) (q[j] / q[i]);
                double w_ = w[j];
                double pay = w_ * r;
                if (pay < w_) {
                    continue outer;
                }
                sum += pay;
            }
            if (sum < min ) {
                min = sum;
            }
        }
        return min;

    }

}

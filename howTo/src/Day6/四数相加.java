package Day6;

import java.util.HashMap;

//这个题比四数字之和简单的地方在于它是在四个数组 且不需要去重

public class 四数相加 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer i:nums1) {
            for (Integer j:nums2) {
                int sum = i+j;

                //这里需要注意使用getOrDefault来防止空指针
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }

        for (Integer i:nums3) {
            for (Integer j:nums4) {
                res += map.getOrDefault(0-i-j,0);
            }
        }


        return res;
    }
}

package Day5;

import java.util.HashSet;

public class 两个数组的交集 {
    /*
    * 给定两个数组 nums1 和 nums2 ，返回 它们的 交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。*/
    public int[] intersection(int[] nums1, int[] nums2) {
        //习惯性判空
        if (nums1==null||nums2==null||nums1.length==0||nums2.length==0){
            return new int[0];
        }
        HashSet<Integer>set1 = new HashSet<>();
        HashSet<Integer>set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])){
                set2.add(nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int index = 0;
        for (Integer integer:set2) {
            res[index++] = integer;
        }
        return res;
    }
}

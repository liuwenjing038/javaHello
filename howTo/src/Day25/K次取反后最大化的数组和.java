package Day25;

import java.util.Arrays;

public class K次取反后最大化的数组和 {
    public int largestSumAfterKNegations(int[] nums, int K) {
        nums = Arrays.stream(nums)
                // 基本intStream不可以使用自定义排序  因此要先转换成IntegerStream对象
                .boxed()
                .sorted(((o1, o2) -> Math.abs(o2) - Math.abs(o1)))
                // 再转换回来intStream对象 最后转为int数组
                .mapToInt(Integer::intValue).toArray();
        //遍历数组将k个负数取反
        for (int i = 0; i < nums.length && K > 0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                K--;
            }
        }
        //如果全是正数的数组k还是大于0 则将最小的数反复取反
        while (K>0){
            nums[nums.length-1] = -nums[nums.length-1];
            K--;
        }
        return Arrays.stream(nums).sum();
    }
}

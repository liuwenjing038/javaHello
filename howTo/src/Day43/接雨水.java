package Day43;

public class 接雨水 {
    public int trap(int[] height) {
        if (height.length <= 2) return 0;
        int[] left = new int[height.length];
        left[0] = height[0];
        int[] right = new int[height.length];
        right[height.length - 1] = height[height.length - 1];
        // 求出每个位置左边最高的高度
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        // 求出每个位置右边最高的高度
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        // 求出每个位置能装多少水 min(left,right) - height[i]
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            int temp = Math.min(left[i], right[i]) - height[i];
            if (temp > 0){
                sum += temp;
            }
        }
        return sum;
    }
}

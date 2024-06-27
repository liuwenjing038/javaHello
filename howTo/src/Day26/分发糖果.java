package Day26;

public class 分发糖果 {
    public int candy(int[] ratings) {
        //创建糖果数组
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        //先处理右边比左边大的情况
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }
        //在从后往前遍历处理左边比右边大的情况
        //不能从左往右遍历  因为需要前面需要用到后面的值
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //这里是如果它比左右都高，则需要取大值
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        int result = 0;
        for (int i = 0; i < candy.length; i++) {
            result += candy[i];
        }
        return result;
    }
}

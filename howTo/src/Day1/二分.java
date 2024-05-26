package Day1;

public class 二分 {

//    第一个版本  right≤ left
    public int search(int[]nums,int target){
        if (target<nums[0] || target>nums[nums.length-1]) return -1;
        int left = 0,right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)>>1;
            if(nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }

//    第二个版本 right< left
//    这种写法主要需要观察新区间是左闭右开的,因此对于右边的开区间需要包含mid
    public int search2(int[]nums,int target){
        if (target<nums[0] || target>nums[nums.length-1]) return -1;
        int left = 0,right = nums.length;
        while (left < right){
            int mid = left + (right-left)>>1;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid+1;    //target在mid的右边即[mid + 1,right)
            }else
                right = mid ;    //target在mid的左边即[left,mid)
        }
        return -1;
    }
}

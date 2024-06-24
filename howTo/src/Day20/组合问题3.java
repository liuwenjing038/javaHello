package Day20;

import java.util.ArrayList;
import java.util.List;
//找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
//只使用数字1到9
//每个数字 最多使用一次

public class 组合问题3 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer>path = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k,n,1,0);
        return res;
    }
    public void backTracking(int k,int n,int start,int sum){
        //剪枝
        if (sum>n) return;
        if (path.size() == k){
            if (sum == n){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9-(k-path.size())+1; i++) {
            path.add(i);
            sum+=i;
            //进入下一层
            backTracking(k,n,i+1,sum);
            //回溯
            sum-=i;
            //回溯
            path.remove(path.size()-1);
        }
    }
}

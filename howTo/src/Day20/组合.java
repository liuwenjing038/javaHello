package Day20;

import java.util.ArrayList;
import java.util.List;

public class 组合 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,k,1);
        return res;
    }
    public void backtrack(int n,int k,int startIndex){
        //如果path的大小等于了k  说明已经走到了节点
        if(path.size() == k){
            res.add(new ArrayList<>(path));
            return;
        }
        //横向遍历
//        for(int i = startIndex;i<=n;i++){
        //剪枝 不满足组合长度的就不需要遍历了
        for(int i = startIndex;i<=n-(k-path.size())+1;i++){
            path.add(i);
            //纵向遍历  需要注意这里需要+1 进入下层递归
            backtrack(n,k,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }
}

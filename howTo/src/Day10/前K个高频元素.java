package Day10;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
//        首先创建一个小根堆,即优先级队列,然后按第二个元素排序
//        这里需要注意如果第一个元素排序就是o1[0]
//        如果大根堆就是(o1,o2)->o2[1]-o1[1]
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        int[] res = new int[k];
//        先统计每个元素的数量
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry:map.entrySet()) {
            int[] temp = new int[2];
            temp[0] = entry.getKey();
            temp[1] = entry.getValue();
            priorityQueue.add(temp);
            if (priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll()[0];
        }
        return res;
    }
}


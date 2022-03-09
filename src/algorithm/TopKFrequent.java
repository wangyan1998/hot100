package algorithm;
//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//        1 <= nums.length <= 10^5
//        k 的取值范围是 [1, 数组中不相同的元素的个数]
//        题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
//        进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author wy
 * @date 2022/3/8 9:15
 */
public class TopKFrequent {
    /**
     * 使用堆+哈希表
     * 先用哈希表统计每个元素出现的次数
     * 然后建立大根堆并遍历map，并保持该堆内的元素个数为k，如果堆顶元素小于当前map的值，出堆，
     * 把当前键值对插入堆。最后把剩下的堆中的键值对的键取出来
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums,int k){
        Map<Integer,Integer> occurrences=new HashMap<>();
        for (int num:nums){
            occurrences.put(num,occurrences.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        for (Map.Entry<Integer,Integer> entry:occurrences.entrySet()){
            int num=entry.getKey(),count=entry.getValue();
            if (queue.size()==k){
                if (queue.peek()[1]<count){
                    queue.poll();
                    queue.offer(new int[]{num,count});
                }
            }else {
                queue.offer(new int[]{num,count});
            }
        }
        int[] ret=new int[k];
        for (int i=0;i<k;i++){
            ret[i]=queue.poll()[0];
        }
        return ret;
    }
}

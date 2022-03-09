package algorithm;
//假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
//        每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个
//        身高大于或等于 hi 的人。
//        请你重新构造并返回输入数组people 所表示的队列。返回的队列应该格式化为数组 queue ，
//        其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
//        1 <= people.length <= 2000
//        0 <= hi <= 10^6
//        0 <= ki < people.length
//        题目数据确保队列可以被重建

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author wy
 * @date 2022/3/9 9:43
 */
public class ReconstructQueue {
    /**
     * 对身高进行升序排列，对于身高相同的情况，对前面高的人数进行降序排列
     * 这样每个人的位置不会受到排在前面人的影响，因为前面的人都比他自己矮，他只需要
     * 按照ki的指示从当前已经排了一半的队列中在他前面留出ki个空位给他后面的人用就行了。
     *
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person1[0] - person2[0];
                } else {
                    return person2[1] - person1[1];
                }
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];
        for (int[] person : people) {
            int spaces = person[1] + 1;
            for (int i = 0; i < n; ++i) {
                if (ans[i] == null) {
                    --spaces;
                    if (spaces == 0) {
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 和第一个方法正好相反，将身高降序排列，身高相同的，按照前面高的人数升序排列
     * 这样每个人只能看到前面比自己高的人，不会受到后面的人的影响，所以每次就可以在当前队里进行
     * 插空，只要让前面有ki个人就行了，因为已经插入的都是比自己高的。而后面的插入都是比自己矮的
     * 不会因为ki而影响位置的变化
     * @param people
     * @return
     */
    public int[][] reconstructQueue1(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] person1, int[] person2) {
                if (person1[0] != person2[0]) {
                    return person2[0] - person1[0];
                } else {
                    return person1[1] - person2[1];
                }
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1], person);
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

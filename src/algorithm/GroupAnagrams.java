package algorithm;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//        字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。


import java.util.*;

/**
 * @author wy
 * @date 2022/2/18 17:54
 */
public class GroupAnagrams {
    /**
     * 典型的字符串和map的题目。
     * 将排序后的字符串作为键存入map,然后进行相应的list
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] array=str.toCharArray();
            Arrays.sort(array);
            String key=new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<String>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}

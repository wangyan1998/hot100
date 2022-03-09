package algorithm;
//给定一个经过编码的字符串，返回它解码后的字符串。
//        编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。
//        注意 k 保证为正整数。
//        你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
//        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像3a或2[4]的
//        输入。

import java.util.Map;
import java.util.Stack;

/**
 * @author wy
 * @date 2022/3/8 11:30
 */
public class DecodeString {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> stack1 = new Stack<>();
        Stack<String> stack2 = new Stack<>();
        int num = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                stack1.push(num);
                stack2.push(res);
                res = "";
                num = 0;
            } else if (c == ']') {
                int curnum = stack1.pop();
                String curres = stack2.pop();
                String ss = "";
                for (int j = 0; j < curnum; j++) ss += res;
                res = curres + ss;
            } else if ('0' <= c && c <= '9') {
                num = num * 10 + (c - '0');
            } else {
                res += c;
            }
        }
        return res;
    }
}

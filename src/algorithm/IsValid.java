package algorithm;
//给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
//        有效字符串需满足：
//        左括号必须用相同类型的右括号闭合。
//        左括号必须以正确的顺序闭合。

import java.util.*;

/**
 * @author wy
 * @date 2022/2/13 15:12
 */
public class IsValid {
    /**
     * 使用栈进行配对
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(!stack.isEmpty()&&(s.charAt(i)==')'&&stack.peek()=='('||s.charAt(i)==']'&&stack.peek()=='['||s.charAt(i)=='}'&&stack.peek()=='{')){
                stack.pop();
            }else {
                stack.push(s.charAt(i));
            }
        }
        if(stack.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    public boolean isValid1(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}

package algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wy
 * @date 2022/2/10 15:09
 */
public class Convert {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        Map<Integer, String> map = new HashMap<>();
        int x = 2 * numRows - 2;
        for (int i = 0; i < s.length(); i++) {
            int j = i % x;
            if (j < numRows) {
                map.put(j, map.getOrDefault(j, "") + s.charAt(i));
            } else {
                map.put(2 * numRows - j - 2, map.getOrDefault(2 * numRows - j - 2, "") + s.charAt(i));
            }
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            if (map.get(i) != null) {
                res.append(map.get(i));
            }
        }
        return res.toString();
    }
}

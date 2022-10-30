package base.debug;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 7991uxug@gmail.com
 * @date 2/2/23 12:32 AM
 */
public class Prac {
}
class Solution {
    public static String removeDuplicates(String s, int k) {
        Deque<Character> cs = new ArrayDeque<>();
        Deque<Integer> counts = new ArrayDeque<>();
        for (int i = 0; i< s.length(); i++) {
            char c = s.charAt(i);
            if (counts.isEmpty()) {
                cs.push(c);
                counts.push(1);
            } else if (counts.peek() < k) {
                if (c == cs.peek()) {
                    counts.push(counts.peek() + 1);
                } else {
                    counts.push(1);
                }
                cs.push(c);
            } else {
                for (int j = 0; j < k; j++) {
                    counts.poll();
                    cs.poll();
                }
            }
        }
        if (cs.isEmpty()) return "";
        char[] chars = new char[cs.size()];
        for (int i = cs.size() - 1; i >= 0; i--) {
            chars[i] = cs.poll();
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
    }
}

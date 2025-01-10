package org.tvd.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringJoiner;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lap2 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int F_LENGTH = 26;
    static public int firstUniqChar(String s) {
        int[] marked = new int[F_LENGTH];
        int[] priority = new int[F_LENGTH];
        Arrays.fill(marked, 0);
        Arrays.fill(priority, -1);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int k = chars[i] - 97;
            marked[k]++;
            if (priority[k] == -1) priority[k] = i;
        }
        int resIndex = -1, tmpPrio = Integer.MAX_VALUE;
        for (int i = 0; i < F_LENGTH; i++) {
            if (marked[i] == 1 && priority[i] < tmpPrio) {
                resIndex = priority[i];
                tmpPrio = priority[i];
            }
        }
        return resIndex;
    }

     public static String truncateSentence(String s, int k) {
        String[] datas = s.split(" ");

        StringJoiner joiner = new StringJoiner(" ");
        for (int i = 0; i < k; i++) {
            joiner.add(datas[i]);
        }
        return joiner.toString();
    }

    public static void reverseString(char[] s) {
        int k = s.length - 1;
        for (int i = 0; i < s.length; i++) {
            s[i] = s[k];
            k--;
        }   
    }

    public static String decodeStringHelper(String s) {
        
        Stack<Character> st = new Stack<>();
        Stack<Integer> opr = new Stack<>();

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int num = 0;
                while (Character.isDigit(chars[i])) {
                    num = num * 10 + (chars[i] - '0');
                    i++;
                }
                i--;
                opr.push(num);
            } else if (chars[i] == ']') {
                String tmp = "";
                while (st.peek() != '[') {
                    tmp = st.pop() + tmp;
                }
                st.pop();
                int num = opr.pop();
                for (int j = 0; j < num; j++) {
                    for (int k = 0; k < tmp.length(); k++) {
                        st.push(tmp.charAt(k));
                    }
                }
            } else {
                st.push(chars[i]);
            }
        }

        String target = "";
        for (Character character : st) {
            target += character;
        }
        return target;
    }

     public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }

        int count = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            if (nums[i] != nums[i - 1]) {
                count++;
                if (count == 3) return nums[i - 1];
            }
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) throws IOException {
        int[] nums = {2, 3, 1};

        System.out.println(thirdMax(nums));
    }
}

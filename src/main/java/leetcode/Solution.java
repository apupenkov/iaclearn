package leetcode;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (var str : strs) {
            if (str.isEmpty()) return "";
            while (str.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }

    public int romanToInt(String s) {
        int result = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; ++i) {
            int j = i + 1;
            if ((arr[i] == 'I' || arr[i] == 'X' || arr[i] == 'C') && i == arr.length - 1) {
                if (arr[i] == 'X') result += 10;
                else if (arr[i] == 'I') result += 1;
                else result += 100;
                break;
            }
            else if (arr[i] == 'C' && (arr[j] == 'D' || arr[j] == 'M')) {
                if (arr[j] == 'D') result += 400;
                else result += 900;
                ++i;
            }
            else if (arr[i] == 'D') result += 500;
            else if (arr[i] == 'M') result += 1000;
            else if (arr[i] == 'X' && (arr[j] == 'C' || arr[j] == 'L')) {
                if (arr[j] == 'C') result += 90;
                else result += 40;
                ++i;
            }
            else if (arr[i] == 'C') result += 100;
            else if (arr[i] == 'L') result += 50;
            else if (arr[i] == 'I' && (arr[j] == 'V' || arr[j] == 'X')) {
                if (arr[j] == 'V') result += 4;
                else result += 9;
                ++i;
            }
            else if (arr[i] == 'V') result += 5;
            else if (arr[i] == 'X') result += 10;
            else if (arr[i] == 'I') result += 1;
        }
        return result;
    }
}

import java.util.*;
import java.util.stream.*;

class Solution {
    public long smallestNumber(long num) {

        String s = String.valueOf(num);

        // Negative number
        if (num < 0) {
            return -Long.parseLong(
                    s.substring(1)
                     .chars()
                     .mapToObj(c -> String.valueOf((char) c))
                     .sorted(Comparator.reverseOrder())
                     .collect(Collectors.joining())
            );
        }

        // Positive number
        String result = s.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .sorted()
                .collect(Collectors.joining());

        // Check whether ALL digits are zero
        if (result.chars().allMatch(c -> c == '0')) {
            return 0;
        }

        // Find first non-zero digit
        int i = 0;
        while (result.charAt(i) == '0') {
            i++;
        }

        // Move first non-zero digit to front
        result = result.charAt(i)
                + result.substring(0, i)
                + result.substring(i + 1);

        return Long.parseLong(result);
    }
}
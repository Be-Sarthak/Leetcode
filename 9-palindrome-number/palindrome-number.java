class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // 1. Negative numbers are not palindromes (e.g., -121 reads as 121-)
        // 2. Numbers ending in 0 are not palindromes (e.g., 10), unless the number itself is 0
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedNum = 0;
        
        // Reverse only the second half of the number to prevent integer overflow
        while (x > reversedNum) {
            int remainder = x % 10;
            reversedNum = (reversedNum * 10) + remainder;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by reversedNum / 10
        // For example, for 12321, at the end of the loop we have x = 12, reversedNum = 123
        // So x == reversedNum / 10 clears the middle digit '3'
        return x == reversedNum || x == reversedNum / 10;
    }
}

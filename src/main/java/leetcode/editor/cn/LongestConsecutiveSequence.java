package leetcode.editor.cn;

import org.springframework.web.bind.annotation.PathVariable;

import java.util.Arrays;
import java.util.HashSet;

/**
题目名字---:最长连续序列
题目编号---:128	
解题时间---:2022-07-07 23:37:11
*/

public class LongestConsecutiveSequence{
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
        System.out.println(solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int count =1;
        for (int num : nums) {
            if (isSuffixNum(num,nums)) {
                count++;
            } else {
                hashSet.add(count);
                count = 1;
            }
        }
        return hashSet.stream().max(Integer::compareTo).get();
    }
    public boolean isSuffixNum(Integer num,int[] nums) {
        return Arrays.stream(nums).anyMatch(x -> x==num+1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
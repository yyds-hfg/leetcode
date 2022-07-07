package leetcode.editor.cn;

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
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        //排序并去重
        nums = Arrays.stream(nums).sorted().distinct().toArray();
        int count =1;
        int maxLength = count;
        for (int num : nums) {
            //判断是否存在后继元素
            if (isSuffixNum(num,nums)) {
                count++;
            } else {
                maxLength = Math.max(maxLength, count);
                count = 1;
            }
        }
        //
        return maxLength;
    }
    public boolean isSuffixNum(Integer num,int[] nums) {
        return Arrays.stream(nums).anyMatch(x -> x==num+1);
    }

    public int longestConsecutive2(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        //添加进HashSet--去重
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int currLength =1;
            while (hashSet.contains(temp+1)) {
                currLength++;
                temp++;
            }
            maxLength = Math.max(maxLength,currLength);
        }
        return maxLength;
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        //添加进HashSet--去重
        for (int num : nums) {
            hashSet.add(num);
        }
        int maxLength = 1;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int currLength =1;
            if (!hashSet.contains(temp-1)) {
                while (hashSet.contains(temp + 1)) {
                    currLength++; temp++;
                }
                maxLength = Math.max(maxLength,currLength);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
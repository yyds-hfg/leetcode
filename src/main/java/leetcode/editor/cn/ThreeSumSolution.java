package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *  三数之和
 * </p>
 *
 * @author: 韩福贵
 * @date: 2023-03-08
 */
public class ThreeSumSolution {
    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> list = new ThreeSumSolution().threeSum(nums);
        list.forEach(System.out::println);
    }
    /**
     * 双指针法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        // 先对数组进行排序
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                break;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 定义左右指针（索引位置）
            int lp = i + 1;
            int rp = n - 1;
            // 只要左右不重叠，就继续移动指针
            while (lp < rp) {
                int sum = nums[i] + nums[lp] + nums[rp];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[lp], nums[rp]));
                    lp++;
                    rp--;
                    while (lp < rp && nums[lp] == nums[lp - 1])
                        lp++;
                    while (lp < rp && nums[rp] == nums[rp + 1])
                        rp--;
                } else if (sum < 0)
                    lp++;
                else
                    rp--;
            }
        }
        return result;
    }
}

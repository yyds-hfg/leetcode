package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

/**
题目名字---:只出现一次的数字
题目编号---:136	
解题时间---:2022-07-06 21:05:34
*/

public class SingleNumber{
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();    
    }
    /**
     * @Description: 暴力解决 通过两次遍历 第一次遍历把每一个数的出现次数保存到hashmap中
     * 第二次遍历把遍历hashmap获取到出现一次的数字
     */
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        for (int num : nums) {
            if (hashMap.get(num)==1) {
                return num;
            }
        }
        //不存在返回-1
        return -1;
    }

    /**
     * @Description: 暴力法优化
     * 由于每一个数字都只出现了一次,所以可以在第二次出现的时候删除hashmap里面的数字
     * 若不存在该数字,就把该数字保存进Hashmap
     */
    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)) {
                hashMap.remove(num);
                continue;
            }
            hashMap.put(num,1);
        }
        return hashMap.keySet().iterator().next();
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @Description: set保存方式
     */
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum =0;  //保存数组的元素的总和的2倍
        for (int num : nums) {
            hashSet.add(num);
            sum +=num;
        }
        Integer setNum = 0;  //保存set元素的总和
        for (Integer num : hashSet) {
            setNum +=num;
        }
        return setNum*2-sum; //去重之后*2 就会多出原数组的那个唯一元素
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
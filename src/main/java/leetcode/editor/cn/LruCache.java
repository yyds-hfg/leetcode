package leetcode.editor.cn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
题目名字---:LRU 缓存
题目编号---:146	
解题时间---:2022-07-08 19:56:38
*/

public class LruCache{
    public static void main(String[] args) {
    }
    
//leetcode submit region begin(Prohibit modification and deletion)
class LRUCache extends LinkedHashMap<Integer,Integer> {

    private int capacity;

    public LRUCache(int capacity) {
        super(capacity,0.75f,true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
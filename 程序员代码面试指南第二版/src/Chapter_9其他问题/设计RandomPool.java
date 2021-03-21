package Chapter_9其他问题;

import java.util.HashMap;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/17 - 21:58
 * @ Description: Chapter_9
 * @ Version: 1.0
 */
public class 设计RandomPool<K> {

    // Pool 类
    public static class Pool<K> {
        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private int size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            this.size = 0;
        }

        // 插入 key 不重复
        private void insert(K key) {
            if (!keyIndexMap.containsKey(key)) {
                keyIndexMap.put(key, size);
                indexKeyMap.put(size++, key);
            }
        }

        // 删除 key
        public void delete(K key) {
            if (keyIndexMap.containsKey(key)) {
                int deleteIndex = keyIndexMap.get(key); // 得到需要删除 key 对应的位置
                int lastIndex = --size; // 得到最后一个的下标
                K lastKey = indexKeyMap.get(lastIndex); // 取得最后一个下标的 key
                keyIndexMap.put(lastKey, deleteIndex);
                indexKeyMap.put(deleteIndex, lastKey);
                indexKeyMap.remove(lastIndex);
                keyIndexMap.remove(key);
            }
        }

        private K getRandom() {
            if (size == 0) {
                return null;
            }
            int randomIndex = (int)(Math.random() * size);
            return indexKeyMap.get(randomIndex);
        }

    }

    public static void main(String[] args) {
        int sum = 10000000;
        int goodS = 0;
        int helloS = 0;
        int worldS = 0;
        int randomS = 0;
        Pool<String> pool = new Pool<>();
        pool.insert("good");
        pool.insert("hello");
        pool.insert("world");
        pool.insert("random");
        for (int i = 0; i < sum; ++i) {
            if (pool.getRandom().equals("good")) {
                goodS++;
            }
            if (pool.getRandom().equals("hello")) {
                helloS++;
            }
            if (pool.getRandom().equals("world")) {
                worldS++;
            }
            if (pool.getRandom().equals("random")) {
                randomS++;
            }
        }
        System.out.println("goods\t" + goodS);
        System.out.println("helloS\t" + helloS);
        System.out.println("worldS\t" + worldS);
        System.out.println("randomS\t" + randomS);

    }
}

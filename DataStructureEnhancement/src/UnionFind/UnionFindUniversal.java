package UnionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @ Author: MingHuiFan
 * @ Date: 2021/3/19 - 12:17
 * @ Description: UnionFind
 * @ Version: 1.0
 */
public class UnionFindUniversal<V> {

    /*
    将 V 类型数据包装成集合形式
     */
    private static class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    // 并查集
    public static class UnionFindSet<V> {
        HashMap<V, Element<V>> elementHashMap;
        HashMap<Element<V>, Element<V>> fatherMap;
        HashMap<Element<V>, Integer> sizeMap;

        // 遍历元素，将每个元素都包装成一个集合
        public UnionFindSet(List<V> list) {
            elementHashMap = new HashMap<>();
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V value : list) {
                Element<V> element = new Element<>(value);
                elementHashMap.put(value, element);
                fatherMap.put(element, element);
                sizeMap.put(element, 1);
            }
        }

        // 给一个元素寻找这个元素所在集合的代表元素
        public Element<V> findHead(Element<V> element) {
            Stack<Element<V>> path = new Stack<>(); // 用于存放元素
            while (element != fatherMap.get(element)) { // 如果该元素不属于
                path.push(element); // 如果不是代表元素入栈
                element = fatherMap.get(element);
            }
            while (!path.empty()) {
                fatherMap.put(path.pop(), element);
            }
            return element;
        }

        public boolean isSameSet(V a, V b) {
            // 判断ab是否在集合中
            if (elementHashMap.containsKey(a) && elementHashMap.containsKey(b)) {
                return findHead(elementHashMap.get(a)) == findHead(elementHashMap.get(b));
            }
            return false;
        }

        public void union(V a, V b) {
            if (elementHashMap.containsKey(a) && elementHashMap.containsKey(b)) {
                Element<V> aF = findHead(elementHashMap.get(a));
                Element<V> bF = findHead(elementHashMap.get(b));
                // 判断两个元素是否在同一集合
                if (aF != bF) {
                    Element<V> maxSet = sizeMap.get(aF) > sizeMap.get(bF) ? aF : bF;
                    Element<V> minSet = maxSet == aF ? bF : aF;
                    fatherMap.put(minSet, maxSet);  // 将小集合的父亲变为大集合，实现合并操作
                    sizeMap.put(maxSet, sizeMap.get(maxSet) + sizeMap.get(minSet));
                    sizeMap.remove(minSet);
                }
            }
        }
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        UnionFindSet<Integer> u1 = new UnionFindSet<>(list);
        u1.union(1, 3);
        u1.union(1, 4);
        System.out.println(u1.isSameSet(3,4));
        System.out.println(u1.isSameSet(1,2));
        System.out.println(u1.isSameSet(1,3));

    }
}

/* Out
true
false
true
 */
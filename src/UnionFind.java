/***
 * This Union find is made to be generic
 * and able to use for many other things that
 * may require a union find algorithm.
 */

public class UnionFind {
    Integer[] list;

    UnionFind(Integer[] list) {
        this.list = list;
    }

    public void union(Integer one, Integer two) {
        Integer root1 = find(one);
        Integer root2 = find(two);

        if(list[root1] < list[root2]) {
            list[root1] += list[root2];
            list[root2] = root1;
        }
        else {
            list[root2] += list[root1];
            list[root1] = root2;
        }

    }

    public Integer find(Integer toFind) {
        if(list[toFind] < 0) {
            return toFind;
        }
        else {
            Integer root = find(list[toFind]);
            list[toFind] = root;
            return root;
        }
    }

}

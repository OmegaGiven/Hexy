/***
 * This Union find is made to be generic
 * and able to use for many other things that
 * may require a union find algorithm.
 */

public class UnionFind {
    private Integer[] list;

    UnionFind(int size) {
        list = new Integer[size];
        for (int i = 0; i < size; i ++) {
            list[i] = -1;
        }
    }

    public void union(Hexagon one, Hexagon two) {
        Integer root1 = find(one.index);
        Integer root2 = find(two.index);

        if(list[root1].compareTo(list[root2]) < 0 ) {
            list[root1] += list[root2];
            one.addValue(list[root2]);
            list[root2] = root1;
            two.setValue(root1);
        }
        else {
            list[root2] += list[root1];
            two.addValue(list[root1]);
            list[root1] = root2;
            one.setValue(root2);
        }

    }

    public Integer find(Integer toFind) {
        if(list[toFind] < 0) {
            return toFind;
        }
        else {
            Integer root = find(list[toFind]);
            list[toFind] = (root);
            return root;
        }
    }

}

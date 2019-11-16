/***
 * This Union find is made to be generic
 * and able to use for many other things that
 * may require a union find algorithm.
 */

public class UnionFind {
    private Hexagon[] list;

    UnionFind(int size) {
        list = new Hexagon[size];
    }

    public void union(Integer one, Integer two) {
        Integer root1 = find(one);
        Integer root2 = find(two);

        if(list[root1].compareTo(list[root2]) < 0 ) {
            list[root1].addValue(root2);
            list[root2].setValue(root1);
        }
        else {
            list[root2].addValue(root1);
            list[root1].setValue(root2);
        }

    }

    public Integer find(Integer toFind) {
        if(list[toFind].getValue() < 0) {
            return toFind;
        }
        else {
            Integer root = find(list[toFind].getValue());
            list[toFind].setValue(root);
            return root;
        }
    }

}

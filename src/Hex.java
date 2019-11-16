import java.util.ArrayList;

public class Hex {
    private int size;
    private ArrayList<Hexagon> graph = new ArrayList<>();
    private ArrayList<Hexagon> up = new ArrayList<>();
    private ArrayList<Hexagon> down = new ArrayList<>();
    private ArrayList<Hexagon> left = new ArrayList<>();
    private ArrayList<Hexagon> right = new ArrayList<>();
    private UnionFind unionFind = new UnionFind(121);

    int[] neighbors = {-11, -10, -1, 1, 10, 11};



    public Hex(){
        this.size = 11;
    }
    public Hex(int size){
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public ArrayList<Hexagon> getGraph() {
        return graph;
    }

    public void addUp(Hexagon node) {
        up.add(node);
    }
    public void addDown(Hexagon node) {
        down.add(node);
    }
    public void addLeft(Hexagon node) {
        left.add(node);
    }
    public void addRight(Hexagon node) {
        right.add(node);
    }




    public void add(Hexagon node) {
        for (int i : neighbors) {
            if(node.getPlayer().equals(graph.get(node.index + i).getValue())) {

            }
        }
    }







    public boolean winner() {
        for (Hexagon up : up) {
            for(Hexagon down : down) {
                if(up.equals(down)) return true;
            }
        }
        for (Hexagon left : left) {
            for (Hexagon right : right) {
                if(right.equals(left)) return true;
            }
        }
        return false;
    }

}

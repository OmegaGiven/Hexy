import java.util.ArrayList;

public class Hex {
    private int size;
    private ArrayList<Hexagon> graph ;
    private ArrayList<Hexagon> up;
    private ArrayList<Hexagon> down;
    private ArrayList<Hexagon> left;
    private ArrayList<Hexagon> right;
    private UnionFind unionFind;




    public Hex(){
        this.size = 11;
        this.graph = new ArrayList<>();
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
        this.unionFind = new UnionFind(getSize() * getSize());

    }
    public Hex(int size){
        this.size = size;
        this.graph = new ArrayList<>();
        this.up = new ArrayList<>();
        this.down = new ArrayList<>();
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();
        this.unionFind = new UnionFind(getSize() * getSize());
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



    public void addBlank(Hexagon hex) {
        graph.add(hex);
    }

    public void change(Hexagon hex) {

        if(hex.index < size) {
            if (graph.get(hex.index).getPlayer() == 1) {
                addUp(graph.get(hex.index));
            }
        }
        else if(hex.index >= (size * size) - (size )) {
            if (graph.get(hex.index).getPlayer() == 1) {
                addDown(graph.get(hex.index));
            }
        }
        else if(hex.index % size == 0) {
            if (graph.get(hex.index).getPlayer() == 2) {
                addLeft(graph.get(hex.index));
            }
        }
        else if(hex.index % size == size - 1) {
            if (graph.get(hex.index).getPlayer() == 2) {
                addRight(graph.get(hex.index));
            }
        }
        int[] neighbors = {-size, -size + 1, -1, 1, size - 1, size};

        for (int i : neighbors) {
            if(hex.index + i >= 0 && hex.index + i < size * size &&
                    hex.index + i < graph.size() &&
                    graph.get(hex.index).getPlayer() != 0 &&
                    graph.get(hex.index).getPlayer().equals(
                            graph.get(hex.index + i).getPlayer())) {
                unionFind.union(hex, graph.get(hex.index + i));
            }
        }
    }







    public boolean winner() {
        for (Hexagon up : up) {
            for(Hexagon down : down) {
                int upper = unionFind.find(up.index);
                int downer = unionFind.find(down.index);
                if(upper == downer) return true;
            }
        }
        for (Hexagon left : left) {
            for (Hexagon right : right) {
                int righty = unionFind.find(right.index);
                int lefty = unionFind.find(left.index);
                if(righty == lefty) return true;
            }
        }
        return false;
    }

}

import java.util.ArrayList;

public class Hex {
    private int size;
    private ArrayList<Hexagon> graph = new ArrayList<>();
    private ArrayList<Hexagon> up = new ArrayList<>();
    private ArrayList<Hexagon> down = new ArrayList<>();
    private ArrayList<Hexagon> left = new ArrayList<>();
    private ArrayList<Hexagon> right = new ArrayList<>();
    private UnionFind unionFind = new UnionFind(121);

    int[] neighbors = {-size, -size + 1, -1, 1, size - 1, size};



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




    public void add(Integer index) {
        if(index < size)
            if(graph.get(index).getPlayer() == 1) {
                addUp(graph.get(index));
            }
        else if(index > size * size - size - 1)
            if(graph.get(index).getPlayer() == 1) {
                addDown(graph.get(index));
            }
        else if(index % size == 0)
            if(graph.get(index).getPlayer() == 2) {
                addLeft(graph.get(index));
            }
        else if(index % size == size - 1)
            if(graph.get(index).getPlayer() == 2) {
                addRight(graph.get(index));
            }
        for (int i : neighbors) {
            if(graph.get(index).getPlayer().equals(graph.get(index + i).getPlayer())) {
                unionFind.union(index, graph.get(index + i).index);
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

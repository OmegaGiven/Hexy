import java.util.ArrayList;

public class Hex {
    int size;
    ArrayList graph = new ArrayList();

    public Hex(){
        this.size = 11;
    }
    public Hex(int size){
        this.size = size;
    }
    public int getSize() {
        return size;
    }
    public ArrayList getGraph() {
        return graph;
    }

//    public boolean winner() {
//
//    }

}

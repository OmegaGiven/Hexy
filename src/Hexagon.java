import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Hexagon implements Comparable {
    private Integer player = 0;
    private Integer value = -1;
    int index;
    ImageView image;

    public void setPlayer(Integer player) {
        this.player = player;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void addValue(Integer value) {
        this.value += value;
    }

    public Integer getPlayer() {
        return player;
    }

    public Integer getValue() {
        return value;
    }

    boolean equals(Hexagon other) {
        return value.equals(other.value);
    }

    private int compare(Hexagon other) {
        if(value < other.value) {
            return -1;
        }
        else if(this.equals(other)) {
            return 0;
        }
        else return 1;
    }

    public int compareTo(Object other) {
        return this.compare((Hexagon) other);
    }
}

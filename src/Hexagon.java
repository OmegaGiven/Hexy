import javafx.scene.image.Image;

public class Hexagon implements Comparable {
    private Integer player;
    private Integer value;
    int index;
    Image image;

    Hexagon(Image image) {
        this.image = image;
        this.player = 0;
        this.value = -1;
        this.index = 0;

    }

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


    // just compares two Hexagon values and returns -1 if less than, 0 if equal and 1 if greater than.
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

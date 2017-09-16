import javafx.scene.control.Button;


public class CrdButton {
    Button bt;
    int x;
    int y;
    Integer value;

    public CrdButton(int x, int y, Integer value) {
        this.bt = new Button(value.toString());
        this.x=x;
        this.y=y;
        this.value=value;
    }

    public Button getBt() {
        return bt;
    }

    public void setBt(Button bt) {
        this.bt = bt;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}

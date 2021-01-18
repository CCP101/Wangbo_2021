package Shape;

public class Rect extends Shape{
    private int width;
    private int height;

    @Override
    public int getArea() {
        return width * height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

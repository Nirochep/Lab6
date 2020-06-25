package Stuff;

import java.io.Serializable;

/**
 * The type Coordinates.
 */
public class Coordinates implements Serializable {
    private float x;
    private Double y; //Максимальное значение поля: 289, Поле не может быть null

    /**
     * Gets x.
     *
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public Double getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(Double y) {
        this.y = y;
    }
}

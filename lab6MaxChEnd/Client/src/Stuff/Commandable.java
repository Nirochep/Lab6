package Stuff;


import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * The interface Commandable.
 */
public interface Commandable extends Serializable {
    /**
     * Execute.
     *
     * @param o the o
     * @throws FileNotFoundException the file not found exception
     */
    public String execute(Object o) throws FileNotFoundException;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName();
}
package Stuff;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * The type Person.
 */
public class Person implements Serializable {
    private java.util.Date birthday; //Поле не может быть null
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле не может быть null
    private Country nationality; //Поле не может быть null

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets eye color.
     *
     * @return the eye color
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * Sets eye color.
     *
     * @param eyeColor the eye color
     */
    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Gets hair color.
     *
     * @return the hair color
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Sets hair color.
     *
     * @param hairColor the hair color
     */
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Gets nationality.
     *
     * @return the nationality
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Sets nationality.
     *
     * @param nationality the nationality
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(birthday, person.birthday) &&
                eyeColor == person.eyeColor &&
                hairColor == person.hairColor &&
                nationality == person.nationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(birthday, eyeColor, hairColor, nationality);
    }
}

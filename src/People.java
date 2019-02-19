import java.util.*;

public abstract class People {
    /**
     * Attributes
     */
    public String name;
    public double salary;
    public String picturePath;
    public ArrayList<String> specializedGenres;
    public String profession;
    public String experience;

    /**
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return double
     */
    public double getSalary() {
        return salary;
    }

    /**
     *
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     *
     * @return String
     */
    public String getPicturePath() {
        return picturePath;
    }

    /**
     *
     * @param picturePath
     */
    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    /**
     *
     * @return String
     */
    public String getProfession() {
        return profession;
    }

    /**
     *
     * @param profession
     */
    public void setProfession(String profession) {
        this.profession = profession;
    }

    /**
     *
     * @return ArrayList<String>
     */
    public ArrayList<String> getSpecializedGenres() {
        return specializedGenres;
    }

    /**
     *
     * @param specializedGenres
     */
    public void setSpecializedGenres(ArrayList<String> specializedGenres) {
        this.specializedGenres = specializedGenres;
    }

    /**
     * @return
     */
    public String getExperience() {
        return experience;
    }

    /**
     * @param experience
     */
    public void setExperience(String experience) {
        this.experience = experience;
    }
}

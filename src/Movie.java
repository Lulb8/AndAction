import java.util.ArrayList;

public class Movie
{
    /** Attributes */
    public String name;
    public String genre;
    public double filmBudget;
    public int pubBudget;
    public int numberOfActors;
    public Actors actors;
    public Director director;
    public TechnicalCrew technicalCrew;
    public Scriptwriter scriptwriter;
    public int numberOfMonths;
    public int boxOffice;
    public int state; //état du film: 0 si le tournage n'a pas commencé, 1 si il est en tournage, 2 s'il est fini
    //public time releaseDate;

    @Override
    public String toString() {
        return "Le titre du film est : " + getName()
               // + "\nSon statut est : " + getState()
                + "\nLe genre du film est : " + getGenre()
                + "\nLe nombre d'acteurs du film est : " + getNumberOfActors()
                + "\nLe réalisateur du film est : " + getDirector()
                + "\nL'équipe du film est : " + getTechnicalCrew();
    }

    /**
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return String
     */
    public String getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     *
     * @return double
     */
    public double getFilmBudget() {
        return filmBudget;
    }

    /**
     *
     * @param filmBudget
     */
    public void setFilmBudget(double filmBudget) {
        this.filmBudget = filmBudget;
    }

    /**
     *
     * @return int
     */
    public int getNumberOfActors() {
        return numberOfActors;
    }

    /**
     *
     * @param numberOfActors
     */
    public void setNumberOfActors(int numberOfActors) {
        this.numberOfActors = numberOfActors;
    }

    /**
     * @return
     */
    public Actors getActors() {
        return actors;
    }

    /**
     * @param actors
     */
    public void setActors(Actors actors) {
        this.actors = actors;
    }

    /**
     *
     * @return Director
     */
    public Director getDirector() {
        return director;
    }

    /**
     *
     * @param director
     */
    public void setDirector(Director director) {
        this.director = director;
    }

    /**
     *
     * @return TechnicalCrew
     */
    public TechnicalCrew getTechnicalCrew() {
        return technicalCrew;
    }

    /**
     *
     * @param technicalCrew
     */
    public void setTechnicalCrew(TechnicalCrew technicalCrew) {
        this.technicalCrew = technicalCrew;
    }

    /**
     *
     * @return Scriptwriter
     */
    public Scriptwriter getScriptwriter() {
        return scriptwriter;
    }

    /**
     *
     * @param scriptwriter
     */
    public void setScriptwriter(Scriptwriter scriptwriter) {
        this.scriptwriter = scriptwriter;
    }

    /**
     *
     * @return int
     */
    public int getNumberOfMonths() {
        return numberOfMonths;
    }

    /**
     *
     * @param numberOfMonths
     */
    public void setNumberOfMonths(int numberOfMonths) {
        this.numberOfMonths = numberOfMonths;
    }

    /**
     *
     * @return int
     */
    public int getBoxOffice() {
        return boxOffice;
    }

    /**
     *
     * @param boxOffice
     */
    public void setBoxOffice(int boxOffice) {
        this.boxOffice = boxOffice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    /**
     *
     * @return time
     */
    /*public time getReleaseDate() {
        return releaseDate;
    }*/

    /**
     *
     * @param releaseDate
     */
    /*public void setReleaseDate(time releaseDate) {
        this.releaseDate = releaseDate;
    }
    */
}

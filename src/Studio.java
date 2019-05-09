public class Studio
{
    /** Attributes */
    public String name;
    public String logoPath;
    public int rank;
    public Actors actorsAvailable;
    public int budget;

    /** Associations */
    private Movie movie;
    private MenuBar menuBar;
    private People people;
    private Buildings buildings;

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
    public String getLogoPath() {
        return logoPath;
    }

    /**
     *
     * @param logoPath
     */
    public void setLogoPath(String logoPath) {
        this.logoPath = logoPath;
    }

    /**
     *
     * @return int
     */
    public int getRank() {
        return rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    public Actors getActorsAvailable() {
        return actorsAvailable;
    }

    public void setActorsAvailable(Actors actorsAvailable) {
        this.actorsAvailable = actorsAvailable;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
public class Studio
{
    /** Attributes */
    public String name;
    public String logoPath;
    public int rank;

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



}
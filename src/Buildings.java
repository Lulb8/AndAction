public abstract class Buildings
{
    /** Attributes */
    public String name;
    public String buildingPicturePath;
    public People people;


    /**
     * @return
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
     * @return
     */
    public String getBuildingPicturePath() {
        return buildingPicturePath;
    }

    /**
     * @param buildingPicturePath
     */
    public void setBuildingPicturePath(String buildingPicturePath) {
        this.buildingPicturePath = buildingPicturePath;
    }

    /**
     * @return
     */
    public People getPeople() {
        return people;
    }

    /**
     * @param people
     */
    public void setPeople(People people) {
        this.people = people;
    }
}


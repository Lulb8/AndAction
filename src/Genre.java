public class Genre extends People
{
    /** Attributes */
    public String physicalDescription;

    /**
     *
     * @return String
     */
    public String getPhysicalDescription() {
        return physicalDescription;
    }

    /**
     * @param physicalDescription
     */
    public void setPhysicalDescription(String physicalDescription) {
        this.physicalDescription = physicalDescription;
    }

    /**
     * @param name
     * @param physicalDescription
     * @return
     */
    public Genre createGenre(String name, String physicalDescription) {
        setName(name);
        setPhysicalDescription(physicalDescription);
        return this;
    }

    /**
     * @return
     */
    public String toString() {
        return this.getName()
                +" est décrit comme "+this.getPhysicalDescription()+"\n";
    }
}

public class Actor extends People
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
     * @param salary
     * @param physicalDescription
     * @return
     */
    public Actor createActor(String name, double salary, String physicalDescription) {
        setName(name);
        setSalary(salary);
        setPhysicalDescription(physicalDescription);
        return this;
    }

    /**
     * @return
     */
    public String toString() {
        return this.getName()
                +"(description : "+this.getPhysicalDescription()
                +", salaire : "+this.getSalary()+")\n";
    }
}

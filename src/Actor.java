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

    public Actor createActor(String name, double salary, String physicalDescription) {
        Actor a = new Actor();
        a.name=name;
        a.salary=salary;
        a.physicalDescription=physicalDescription;
        return a;
    }

}
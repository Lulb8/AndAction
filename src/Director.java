public class Director extends People{

    /**
     * @param name
     * @param salary
     * @return
     */
    public Director createDirector(String name, double salary) {
        setName(name);
        setSalary(salary);
        return this;
    }

    public String toString() {
        return this.getName()
                +" a pour salaire : "+this.getSalary()+"\n";
    }
}

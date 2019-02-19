public class Director extends People{

    /**
     * @param name
     * @param salary
     * @return
     */
    public Director createDirector(String name, double salary) {
        Director d = new Director();
        d.setName(name);
        d.setSalary(salary);
        return d;
    }
    public String toString() {
        return this.getName()
                +" a pour salaire : "+this.getSalary()+"\n";
    }
}

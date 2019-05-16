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
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", picturePath='" + picturePath + '\'' +
                ", specializedGenres=" + specializedGenres +
                ", profession='" + profession + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }

}

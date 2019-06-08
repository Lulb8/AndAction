public class TechnicalCrew extends People
{

    @Override
    public String toString() {
        return "TechnicalCrew{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", picturePath='" + picturePath + '\'' +
                ", specializedGenres=" + specializedGenres +
                ", profession='" + profession + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
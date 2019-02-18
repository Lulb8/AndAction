public class Scriptwriter extends People
{
public String theme;
//il faut créer une lite de theme que le joueur choisira
public String getTheme() {
            return theme;
        }
    public Scriptwriter createScriptwriter(String name, double salary, String theme) {
            Scriptwriter w = new Scriptwriter();
            w.salary=salary;
            w.theme=theme;
            w.name=name;
            return w;
        }

    }

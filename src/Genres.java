import java.util.ArrayList;
import java.util.List;


public class Genres {

        private ArrayList<Genre> genres = new ArrayList<Genre>();
        //public int nbActors=actors.size(); //nombre d'acteurs


        /**
         * @return
         */
        public ArrayList<Genre> getGenres() {
            return genres;
        }

        /**
         * @param genres
         */
        public void setGenres(ArrayList<Genre> genres) {

            this.genres = genres;
        }


    /*
    public void chooseActor(Actor actorChoosen) {
        if(actors.contains(actorChoosen)) {

            actors.remove(actorChoosen);
        }
    }
    */

        public void initializeActors() {
            Genre g1 = new Genre(), g2 = new Genre(), g3 = new Genre(), g4 = new Genre();
            g1.createGenre("Action","rousse");
            g2.createGenre("Romantique","grand");
            g3.createGenre("Horreur","brun");
            g4.createGenre("Fantastique","musclée");
            genres.add(g1);
            genres.add(g2);
            genres.add(g3);
            genres.add(g4);
        }

        @Override
        public String toString() {
            String string=new String();
            for (Genre g : this.getGenres()) {
                string += g.toString();
            }
            return string;
        }




    /*
    public void toString(ArrayList<Actor> actors) {
        for (Actor a : actors) {
            System.out.print(a);
        }
    }
    */

}


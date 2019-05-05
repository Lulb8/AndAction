public class PreProductionBuilding extends BuildingsMenu {

    private boolean inPrePBuilding;

    public void launchPreProd() {
        System.out.println("Bienvenue au bâtiment de la pré-production !");
        inPrePBuilding = true;
        while (inPrePBuilding) {
            System.out.println("1: Afficher l'état du film\n2: Lancer la répétition du film\n3: Lancer le tournage\n4: Sortir du bâtiment");
            int choice = this.checkNumber();
            this.selectChoice(choice);
        }
    }

    private void selectChoice (int choice) {
        switch (choice){
            case 1: //afficher l'état du film
                System.out.println("Situation actuelle du film : ");
                break;
            case 2: //lancer le répétition
                System.out.println("La répétition est lancée");
                break;
            case 3: //lancer le tournage
                System.out.println("Le tournage est lancé !");
                break;
            case 4: //quitter le bâtiment
                inPrePBuilding = false;
                System.out.println("Vous avez quitté le bâtiment de pré-production.");
                break;
            default:
                System.out.println("Veuillez entrer un caractère valable !");
                break;
        }
    }
}

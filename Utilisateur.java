import java.util.ArrayList;
public class Utilisateur {
    private String nom;
    private int numeroIdentification;
    private ArrayList<Livre> livresEmpruntes; // livresEmpruntes est une liste
    //d'objets de la classe Livre

    //creation des methodes
    /* Constructeur pour initialiser les attributs. */
    public Utilisateur(String nom, int numeroIdentification){
        this.nom = nom;
        this.numeroIdentification = numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();// a chaque fois qu'un nouvel utilisateur est crée,
        // une nouvelle instance d'arraylist est aussi créé

    }

    /* Méthode pour emprunter un livre.
     * il s'agira de prendre un livre et de l'ajouter à notre liste de livres
     * sachant que l'attribut livresEmpruntes sera la liste de livres en question
     * nous allons creer une méthode emprunterLivre qui prend en parametre un nouveau livre
     * ensuite nous allons appeler la méthode add sur l'attribut livresEmpruntes pour pouvoir ajouter un nouveau livre
     * cependant nous allons faire des verifications 
     */
    public void emprunterLivre(Livre instanceLivre){
        if (livresEmpruntes == null) {
            livresEmpruntes = new ArrayList<>(); // Initialisation de livresEmpruntes si ce n'est pas déjà fait
        }

        if (!livresEmpruntes.contains(instanceLivre)) { // Vérifie si le livre n'est pas déjà emprunté
        livresEmpruntes.add(instanceLivre); // Ajoute le livre à la liste d'emprunt
        } else {
        System.out.println("Ce livre est déjà emprunté par l'utilisateur.");
        }
    }

    /* Méthode pour retourner un livre. */
    public void retournerLivre(Livre instanceLivre){
        if (!livresEmpruntes.contains(instanceLivre)) {// Vérifie si le livre n'est pas déjà emprunté
            System.out.println("Ce livre n'apparait pas dans la liste");
        } else { //sinon la méthode supprime le livre en question
            livresEmpruntes.remove(instanceLivre);
        }

    }

    /* Méthode pour afficher les livres empruntés par l'utilisateur.*/
    public void afficherLivres(){
        System.out.println("Liste des livres empruntés : ");
        for (int i = 0; i < livresEmpruntes.size(); i++) {
            System.out.println(livresEmpruntes.get(i));
        }
    
    }
    public static void main(String[] args) {
        Utilisateur user1 = new Utilisateur("sira", 1);
        Livre livre1 = new Livre();
        livre1.setAnneePublication(2023);
        livre1.setISBN("nkifnhiof");
        livre1.setAuteur("sira");
        livre1.setTitre("ceci est un test");

        Livre livre2 = new Livre();
        livre2.setAnneePublication(2022);
        livre2.setISBN("nbhgkkd");
        livre2.setAuteur("Adja");
        livre2.setTitre("Mon tp");

        Livre livre3 = new Livre();

        user1.emprunterLivre(livre1);
        user1.emprunterLivre(livre2);
        user1.emprunterLivre(livre1);

       
        user1.retournerLivre(livre3);
        user1.retournerLivre(livre1);

        user1.afficherLivres();

        System.out.println( "livre1 = " + livre1.toString());
    

    // Création d'un nouvel utilisateur
    Utilisateur user2 = new Utilisateur("awa", 2);
    
    // Création de quelques livres
    Livre livre4 = new Livre();
    livre4.setAnneePublication(2023);
    livre4.setISBN("projet123");
    livre4.setAuteur("awa");
    livre4.setTitre("biblio");

    Livre livre5 = new Livre();
    livre5.setAnneePublication(2022);
    livre5.setISBN("lnfvh");
    livre5.setAuteur("awa");
    livre5.setTitre("user");

    // Emprunt de livres par le nouvel utilisateur
    user2.emprunterLivre(livre4);
    user2.emprunterLivre(livre5);

    // Retour de livres par le nouvel utilisateur
    user2.retournerLivre(livre4);

    // Affichage des livres empruntés par le nouvel utilisateur
    user2.afficherLivres();
} 

    }
    

public class Livre {
    // Attributs de la classe Livre
    private String titre; // Titre du livre
    private String auteur; // Nom de l'auteur du livre
    private int anneePublication; // Année de publication du livre
    private String ISBN; // Code ISBN du livre
    private int nombreCopies; // Nombre de copies disponibles du livre

    // Constructeur par défaut de la classe Livre
    public Livre(){};

    // Constructeur avec paramètres pour initialiser les attributs de la classe Livre
    public Livre(String titre, String auteur, int anneePublication, String ISBN, int nombreCopies) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
        this.nombreCopies = nombreCopies; // Initialisation du nombre de copies
    }

    // Méthodes get et set pour l'attribut titre
    public String getTitre(){
        return this.titre;
    }
    public void setTitre(String titre){
        this.titre = titre;
    }

    // Méthodes get et set pour l'attribut auteur
    public String getAuteur(){
        return this.auteur;
    }
    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    // Méthodes get et set pour l'attribut anneePublication
    public int getAnneePublication(){
        return this.anneePublication;
    }
    public void setAnneePublication(int anneePublication){
        this.anneePublication = anneePublication;
    }

    // Méthodes get et set pour l'attribut ISBN
    public String getISBN(){
        return this.ISBN;
    }
    public void setISBN(String ISBN){
        this.ISBN = ISBN;
    }

    // Méthodes get et set pour l'attribut nombreCopies
    public int getNombreCopies() {
        return this.nombreCopies;
    }

    public void setNombreCopies(int nombreCopies) {
        this.nombreCopies = nombreCopies;
    }

    // Méthode toString pour afficher les détails du livre
    public String toString(){
        return "Livre{" +
            "titre='" + titre + '\'' +
            ", auteur='" + auteur + '\'' +
            ", anneePublication=" + anneePublication +
            ", ISBN='" + ISBN + '\'' +
            ", nombreCopies=" + nombreCopies + // Inclure nombreCopies dans la représentation String
            '}';
    }

 
        public static void main(String[] args) {
            // Création de quelques instances de Livre
            Livre livre1 = new Livre("Constructeur", "Awa", 2021, "ISBN-1", 3);
            Livre livre2 = new Livre("Méthode", "Sira", 2020, "ISBN-2", 2);
    
            // Affichage des détails des livres
            System.out.println("Détails du livre 1 :");
            System.out.println(livre1);
    
            System.out.println("\nDétails du livre 2 :");
            System.out.println(livre2);
    
            // Modification du titre du livre 1
            livre1.setTitre("Nouveau Titre");
    
            // Affichage des détails mis à jour du livre 1
            System.out.println("\nDétails du livre 1 après modification :");
            System.out.println(livre1);
        
    }
    
}


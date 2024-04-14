import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    // Liste des livres dans la bibliothèque
    private ArrayList<Livre> listeLivres;
    // Détails des emprunts par utilisateur
    private HashMap<String, ArrayList<Livre>> empruntsUtilisateur;

    // Constructeur de la bibliothèque
    public Bibliotheque() {
        // Initialisation des listes de livres et d'emprunts
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateur = new HashMap<>();
    }

    // Méthode pour ajouter un livre à la bibliothèque
    public void ajouterLivre(Livre instanceLivre) {
        if (listeLivres.contains(instanceLivre)) {
            // Si le livre est déjà dans la bibliothèque, augmenter le nombre de copies
            System.out.println("Ce livre est déjà dans la bibliothèque. Nous ajoutons une copie.");
            instanceLivre.setNombreCopies(instanceLivre.getNombreCopies() + 1);
        } else {
            // Si le livre n'est pas dans la bibliothèque, l'ajouter
            listeLivres.add(instanceLivre);
            System.out.println("Nouveau livre ajouté à la bibliothèque.");
        }
    }

    // Méthode pour supprimer un livre de la bibliothèque
    public void supprimerLivre(Livre instanceLivre) {
        if (listeLivres.contains(instanceLivre)) {
            // Si le livre est dans la bibliothèque, le supprimer
            listeLivres.remove(instanceLivre);
            System.out.println("Le livre a été supprimé de la bibliothèque.");
        } else {
            // Si le livre n'est pas dans la bibliothèque, afficher un message d'erreur
            System.out.println("Ce livre n'existe pas dans la bibliothèque.");
        }
    }

    // Méthode pour rechercher un livre par titre, auteur ou ISBN
    public Livre rechercherLivre(String critere) {
        // Parcourir tous les livres de la bibliothèque
        for (Livre livre : listeLivres) {
            // Vérifier si le titre, l'auteur ou l'ISBN correspond au critère de recherche
            if (livre.getTitre().equalsIgnoreCase(critere) || livre.getAuteur().equalsIgnoreCase(critere) || livre.getISBN().equalsIgnoreCase(critere)) {
                // Si un livre correspond au critère, le retourner
                return livre;
            }
        }
        // Si aucun livre correspondant n'est trouvé, retourner null
        return null;
    }

    // Méthode pour enregistrer l'emprunt d'un livre par un utilisateur
    public void emprunterLivre(String utilisateur, Livre livre) {
        if (empruntsUtilisateur.containsKey(utilisateur)) {
            // Si l'utilisateur a déjà emprunté des livres, ajouter ce livre à sa liste d'emprunts
            empruntsUtilisateur.get(utilisateur).add(livre);
        } else {
            // Si c'est la première fois que l'utilisateur emprunte un livre, créer une nouvelle liste d'emprunts pour cet utilisateur
            ArrayList<Livre> emprunts = new ArrayList<>();
            emprunts.add(livre);
            empruntsUtilisateur.put(utilisateur, emprunts);
        }
        // Afficher un message pour indiquer que l'emprunt a été enregistré
        System.out.println("L'utilisateur " + utilisateur + " a emprunté le livre " + livre.getTitre());
    }

    // Méthode pour enregistrer le retour d'un livre par un utilisateur
    public void retournerLivre(String utilisateur, Livre livre) {
        if (empruntsUtilisateur.containsKey(utilisateur) && empruntsUtilisateur.get(utilisateur).contains(livre)) {
            // Si l'utilisateur a emprunté ce livre, le retirer de sa liste d'emprunts
            empruntsUtilisateur.get(utilisateur).remove(livre);
            // Afficher un message pour indiquer que le livre a été retourné avec succès
            System.out.println("L'utilisateur " + utilisateur + " a retourné le livre " + livre.getTitre());
        } else {
            // Si l'utilisateur n'a pas emprunté ce livre, afficher un message d'erreur
            System.out.println("Cet utilisateur n'a pas emprunté ce livre.");
        }
    }

    // Méthode pour vérifier si un utilisateur est éligible à emprunter un livre
    public boolean verifierEligibilite(String utilisateur, Livre livre) {
        // Vérifier si l'utilisateur a déjà emprunté ce livre
        return empruntsUtilisateur.containsKey(utilisateur) && empruntsUtilisateur.get(utilisateur).contains(livre);
    }

    // Méthode pour obtenir les détails des emprunts par utilisateur
    public HashMap<String, ArrayList<Livre>> getEmpruntsUtilisateur() {
        return this.empruntsUtilisateur;
    }

    public static void main(String[] args) {
        // Création d'une instance de la bibliothèque
        Bibliotheque bibliotheque = new Bibliotheque();

        // Création de quelques livres avec les noms et auteurs spécifiés
        Livre livre1 = new Livre("Constructeur", "Awa", 2021, "ISBN-1", 3);
        Livre livre2 = new Livre("Methode", "Sira", 2020, "ISBN-2", 2);

        // Ajout des livres à la bibliothèque
        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);

        // Recherche d'un livre par titre
        Livre livreTrouve = bibliotheque.rechercherLivre("Constructeur");
        if (livreTrouve != null) {
            System.out.println("Livre trouvé : " + livreTrouve);
        } else {
            System.out.println("Le livre n'a pas été trouvé.");
        }

        // Création d'un utilisateur
        String utilisateur = "awaFall";

        // Emprunt d'un livre par l'utilisateur
        bibliotheque.emprunterLivre(utilisateur, livre1);

        // Affichage des livres empruntés par l'utilisateur
        ArrayList<Livre> livresEmpruntes = bibliotheque.getEmpruntsUtilisateur().get(utilisateur);
        if (livresEmpruntes != null && !livresEmpruntes.isEmpty()) {
            System.out.println("Livres empruntés par l'utilisateur :");
            for (Livre livre : livresEmpruntes) {
                System.out.println(livre);
            }
        } else {
            System.out.println("L'utilisateur n'a pas emprunté de livres.");
        }
    }
}

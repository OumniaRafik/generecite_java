package org.example;

import metier.IMetier;
import metier.MetierProduitImpl;
import metier.Produit;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IMetier<Produit> metier = new MetierProduitImpl();
        boolean running = true;

        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consommer la ligne suivante

            switch (choice) {
                case 1:
                    System.out.println("\nListe des produits:");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit);
                    }
                    break;
                case 2:
                    System.out.print("Entrez l'id du produit à rechercher: ");
                    long idRechercher = scanner.nextLong();
                    scanner.nextLine();
                    Produit produit = metier.findById(idRechercher);
                    if (produit != null) {
                        System.out.println("Produit trouvé: " + produit);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;
                case 3:
                    System.out.print("Entrez l'id du produit: ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le nom du produit: ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque du produit: ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix du produit: ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description du produit: ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine();

                    Produit nouveauProduit = new Produit(id, nom, marque, prix, description, stock);
                    metier.add(nouveauProduit);
                    System.out.println("Produit ajouté: " + nouveauProduit);
                    break;
                case 4:
                    System.out.print("Entrez l'id du produit à supprimer: ");
                    long idSupprimer = scanner.nextLong();
                    scanner.nextLine();
                    metier.delete(idSupprimer);
                    System.out.println("Produit supprimé (si existait).");
                    break;
                case 5:
                    running = false;
                    System.out.println("Au revoir!");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}

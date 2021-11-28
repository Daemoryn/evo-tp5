import models.Product;
import models.Repository;
import models.User;

import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

public class Program {
    private static final Logger logger = Logger.getLogger(Program.class.getName());

    public static void main(String[] args) {
        boolean stop = false;
        String entry = "";
        Scanner sc = new Scanner(System.in);

        User u1 = new User(UUID.fromString("b0ef2a54-488b-4ee4-8e62-db81cf1a8792"), "Alexandre", 28, "alex@gmail.com", "123456");
        Repository r1 = new Repository();
        Product p1 = new Product(UUID.fromString("8806c56a-e7d9-4f51-978a-96f0d3ceb5fa"), "Voiture Tesla", "43800", "1999-09-27");
        Product p2 = new Product(UUID.fromString("101c2d79-0e0c-487e-b265-76da0dd9db40"), "Chapeau", "2", "1998-04-23");

        try {
            r1.addProduct(p1);
            r1.addProduct(p2);
        } catch (Exception e) {
            logger.severe("Erreur pendant l'initialisation du dépot : " + e);
        }

        System.out.println("Bonjour " + u1.getName() + " !");
        while (!stop) {
            System.out.println("1 : Afficher les produits dans le depot");
            System.out.println("2 : Aller chercher un produit via son ID");
            System.out.println("3 : Ajouter un nouveau produit");
            System.out.println("4 : Supprimer un produit via son ID");
            System.out.println("5 : Modifier les informations d'un produit via son ID");
            System.out.println("0 : Quitter");
            System.out.print("Choix : ");
            try {
                entry = sc.nextLine();
                logger.info("L'utilisateur à entré pour le choix : " + entry);
            } catch (Exception e) {
                logger.severe("Erreur pendant le scan de l'input : " + e);
            }
            switch (entry) {
                case "0" -> {
                    stop = true;
                    logger.info("Arrêt du programme");
                }
                case "1" -> {
                    try {
                        System.out.println(r1);
                    } catch (Exception e) {
                        logger.severe("Erreur pendant l'initialisation du dépot : " + e);
                    }
                }
                case "2" -> {
                    System.out.println("Voici le depot : ");
                    System.out.println(r1);
                    System.out.println("Saisissez l'ID du produit à afficher : ");
                    try {
                        String StrUuid = sc.next();
                        logger.info("L'utilisateur à entré pour l'uuid : " + StrUuid);
                        System.out.println(r1.getProductById(UUID.fromString(StrUuid)));
                    } catch (Exception e) {
                        logger.severe("Erreur pendant l'affichage du produit : " + e);
                    }
                }
                case "3" -> {
                    try {
                        System.out.println("Saisissez le nom du produit à créer : ");
                        String name = sc.next();
                        logger.info("L'utilisateur à entré pour le nom : " + name);
                        System.out.println("Saisissez le prix du produit à créer : ");
                        String price = sc.next();
                        logger.info("L'utilisateur à entré pour le prix : " + price);
                        System.out.println("Saisissez la date d'expiration du produit à créer (YYYY-MM-DD) : ");
                        String date = sc.next();
                        logger.info("L'utilisateur à entré pour la date d'expiration : " + date);
                        UUID uuid = UUID.randomUUID();
                        r1.addProduct(new Product(uuid, name, price, date));
                        logger.info("Voici le produit crée : " + r1.getProductById(uuid));
                    } catch (Exception e) {
                        logger.severe("Erreur pendant la création du produit : " + e);
                    }
                }
                case "4" -> {
                    try {
                        System.out.println("Voici le depot : ");
                        System.out.println(r1);
                        System.out.println("Saisissez l'id du produit à supprimer : ");
                        String StrUuid = sc.next();
                        logger.info("L'utilisateur à entré pour l'uuid : " + StrUuid);
                        r1.deleteProductById(UUID.fromString(StrUuid));
                        logger.info("Suppression effectuée, voici le depot : " + r1);
                    } catch (Exception e) {
                        logger.severe("Erreur pendant la suppression du produit : " + e);
                    }
                }
                case "5" -> {
                    try {
                        System.out.println("Voici le depot : ");
                        System.out.println(r1);
                        System.out.println("Saisissez l'ID du produit à modifier : ");
                        String StrUuid = sc.nextLine();
                        logger.info("L'utilisateur à entré pour l'uuid : " + StrUuid);
                        System.out.println("Saisissez le nom du produit. (Saisissez une entrée vide pour passer) Nom = " + r1.getProductById(UUID.fromString(StrUuid)).getName() + " : ");
                        String name = sc.nextLine();
                        logger.info("L'utilisateur à entré pour le nom : " + name);
                        System.out.println("Saisissez le prix du produit. Prix = " + r1.getProductById(UUID.fromString(StrUuid)).getPrice() + " : ");
                        String price = sc.nextLine();
                        logger.info("L'utilisateur à entré pour le prix : " + price);
                        System.out.println("Saisissez la date du produit. Date d'expiration = " + r1.getProductById(UUID.fromString(StrUuid)).getExpirationDate() + " : ");
                        String date = sc.nextLine();
                        logger.info("L'utilisateur à entré pour la date d'expiration : " + date);
                        r1.updateProduct(UUID.fromString(StrUuid), name, price, date);
                        logger.info("Modification effectuée, voici le produit modifié : " + r1.getProductById(UUID.fromString(StrUuid)));
                    } catch (Exception e) {
                        logger.severe("Erreur pendant la modification du produit : " + e);
                    }
                }
                default -> System.out.println("Veuillez saisir un numéro du menu");
            }
        }
    }
}

import java.util.Random;
import java.util.Scanner;

/**
 * Classe calculant la moyenne de nombres aléatoire entre deux bornes
 */
public class CalculateurMoyenne {

    /**
     * La plus petite valeur pouvant être générée (inclusive)
     */
    private int minimum;

    /**
     * La plus grande valeur pouvant être générée (inclusive)
     */
    private int maximum;

    /**
     * Le nombre de valeurs à générer
     */
    private int nombreValeurs;

    /**
     * Fonction principale
     * @param args les arguments du programmes (inutilisés)
     */
    // Remarquez le static ici - en effet, mais ne peut pas être appelé sur une instance, aucun objet n'a encore
    // été instancié.
    public static void main(String[] args) {
        // Nouvelle instance du calculateur
        CalculateurMoyenne calculateur = new CalculateurMoyenne();

        // Appel de méthodes publiques
        calculateur.demanderParametres();
        float moyenne = calculateur.calculerMoyenne();

        // %.2f (dans la fonction format) permet d'afficher un nombre float avec 2 nombres seulement après la virgule.
        System.out.println(String.format("La moyenne des nombres est %.2f.", moyenne));
    }

    /**
     * Demande à l'utilisateur les 3 paramètres du système
     */
    public void demanderParametres() {
        Scanner scanner = new Scanner(System.in);

        minimum = lireEntier("Quelle est la valeur minimale a generer ?", scanner);
        maximum = lireEntier("Quelle est la valeur maximale a generer ?", scanner);
        nombreValeurs = lireEntierPositif("Combien de valeurs faut-il generer ?", scanner);

        scanner.close();
    }

    /**
     * Génère les nombres selon les paramètres fixés et calcule leur moyenne.
     * @return la valeur moyenne des nombres générés
     */
    public float calculerMoyenne() {
        // Si minimum est plus grand que maximum, on les inverse : le résultat sera le même, mais on évite une erreur
        if(maximum < minimum) {
            int temp = maximum;
            maximum = minimum;
            minimum = temp;
        }

        float somme = 0.0f;
        Random generateur = new Random(1);      // Rend l'exécution constante (toujours les mêmes valeurs
        // aléatoires générés - très utile pour le deboguage)

        // On sait ici combien de fois il faut générer un nombre
        for(int i = 0; i < nombreValeurs; i++) {
            somme += generateur.nextInt(minimum, maximum + 1);  // On veut inclure la valeur maximale
        }

        float moyenne = somme / nombreValeurs;

        return moyenne;
    }

    /**
     * Demande à l'utilisateur un entier positif avec un message personnalisé. L'entier est lue dans la console. Si
     * l'entrée est invalide, il est redemandé jusqu'à ce que l'entrée soit valide. Ici l'entier est strictement
     * positif (valeur 0 exclue).
     * @param message Le message demandant un entier positif
     * @param scanner Le scanner permettant de lire la console
     * @return l'entier positif entré par l'utilisateur.
     */
    private int lireEntierPositif(String message, Scanner scanner) {
        boolean entierValide = false;
        int valeur = 0;

        // On ne sait pas combien d'exécution il y a à faire.
        while (!entierValide) {
            System.out.println(message);
            String valeurLu = scanner.next();       // On lit en String pour récupérer tous les caractères

            try {
                // Tentative de conversion. Peut déclencher un NumberFormatException si le format n'est pas valide
                valeur = Integer.parseInt(valeurLu);

                // Respect de la condition de positivité.
                if(valeur <= 0) {
                    System.out.println("L'entier doit être positif");
                } else {
                    entierValide = true;
                }
            } catch (NumberFormatException exception) {
                System.out.println("Format de l'entier invalide."); // Message d'erreur et retour au début de la boucle
            }
        }

        return valeur;
    }

    /**
     * Demande à l'utilisateur un entier avec un message personnalisé. L'entier est lue dans la console. Si
     * l'entrée est invalide, il est redemandé jusqu'à ce que l'entrée soit valide.
     * @param message Le message demandant un entier positif
     * @param scanner Le scanner permettant de lire la console
     * @return l'entier entré par l'utilisateur.
     */
    private int lireEntier(String message, Scanner scanner) {
        boolean entierValide = false;
        int valeur = 0;

        while (!entierValide) {
            System.out.println(message);
            String valeurLu = scanner.next();

            try {
                valeur = Integer.parseInt(valeurLu);
                entierValide = true;
            } catch (NumberFormatException exception) {
                System.out.println("Format de l'entier invalide.");
            }
        }

        return valeur;
    }


}

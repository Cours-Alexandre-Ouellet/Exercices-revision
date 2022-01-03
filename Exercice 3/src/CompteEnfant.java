import java.util.ArrayList;

/**
 * Utilisateur enfant
 */
public class CompteEnfant extends Compte {

    /**
     * Nombre maximale de champs d'intérêts
     */
    private final static int MAX_CHAMP_INTERET = 3;

    /**
     * Compte de la mère de cet enfant
     */
    // On ne peut pas changer de mère
    private final CompteMere compteMere;

    /**
     * Le genre de l'enfant
     */
    // Ici, pendant l'utilisation on pourrait réacffecter le genre
    private String genre;

    /**
     * Région dans laquelle l'enfant cherche
     */
    // On peut déménager
    private String region;

    /**
     * Liste des champs d'intérêt
     */
    // On peut ajouter / supprimer, mais pas réaffecter la liste
    private final ArrayList<String> champsInteret;

    /**
     * Liste des rendez-vous prévus ou passez
     */
    private final ArrayList<CompteEnfant> rendezVous;

    /**
     * Liste des comptes aimés par la mère pour cet enfant.
     */
    private final ArrayList<CompteEnfant> comptesAimes;

    /**
     * Crée un nouveau compte enfant.
     *
     * @param anneeNaissance année de naissance de l'utilisateur
     * @param nom            nom de l'utilisateur
     * @param compteMere     compte de la mère
     * @param genre          genre de l'utilisateur
     * @param region         région dans laquelle l'utilisateur recherche
     */
    public CompteEnfant(int anneeNaissance, String nom, CompteMere compteMere, String genre, String region) {
        super(anneeNaissance, nom);
        this.compteMere = compteMere;
        this.genre = genre;
        this.region = region;

        champsInteret = new ArrayList<>();
        rendezVous = new ArrayList<>();
        comptesAimes = new ArrayList<>();
    }

    @Override
    public void consulterRendezVous() {
        System.out.println("Liste des rendez-vous.");

        for (int i = 0; i < rendezVous.size(); i++) {
            System.out.println(rendezVous.get(i).getNom());
        }
    }

    public void ajouterChampInteret(String champInteret) {

    }

    public ArrayList<CompteEnfant> getRendezVous() {
        return rendezVous;
    }
}

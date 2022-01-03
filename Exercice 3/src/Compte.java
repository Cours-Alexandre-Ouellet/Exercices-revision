/**
 * Classe de base pour les comptes des utilisateurs
 */
public abstract class Compte {

    /**
     * Année de naissance de l'utilisateur
     */
    // Ne peut pas être modifié après la création
    protected final int anneeNaissance;

    /**
     * Nom de l'utilisateur
     */
    // Ne peut pas être modifié après la création
    protected final String nom;

    /**
     * Crée un nouveau compte.
     *
     * @param anneeNaissance l'année de naissance de l'utilisateur
     * @param nom            le nom de l'utilisateur
     */
    public Compte(int anneeNaissance, String nom) {
        this.anneeNaissance = anneeNaissance;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    /**
     * Affiche la liste des rendez-vous
     */
    // Mère et enfant on un affichage différent
    public abstract void consulterRendezVous();


}

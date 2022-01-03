import java.util.ArrayList;
import java.util.List;

/**
 * Utilisateur mère
 */
public class CompteMere extends Compte {

    /**
     * Liste des enfants inscrits pour cette mère
     */
    // On peut ajouter / supprimer, mais pas réaffecter la liste
    private final ArrayList<CompteEnfant> enfants;

    /**
     * Crée un nouveau compte de mère.
     *
     * @param anneeNaissance année de naissance de l'utilisatrice
     * @param nom            le nom de l'utilisatrice
     */
    public CompteMere(int anneeNaissance, String nom) {
        super(anneeNaissance, nom);

        enfants = new ArrayList<>();
    }

    public void aimerCandidats(CompteEnfant enfantSelectionne, CompteEnfant profilAime) {

    }

    public void planifierRendezVous(CompteEnfant enfantSelectionne, CompteEnfant profilInvite) {

    }

    @Override
    public void consulterRendezVous() {
        for (int i = 0; i < enfants.size(); i++) {
            CompteEnfant enfant = enfants.get(i);
            System.out.println("Rendez-vous pour " + enfant.getNom());

            for (int j = 0; j < enfant.getRendezVous().size(); i++) {
                System.out.println(enfant.getRendezVous().get(j).getNom());
            }
        }
    }
}

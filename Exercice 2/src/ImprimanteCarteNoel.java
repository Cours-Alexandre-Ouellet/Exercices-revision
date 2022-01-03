/**
 * Imprime des cartes de Noël personnalisée et calcule le coût d'une telle impression.
 */
public class ImprimanteCarteNoel {

    /**
     * Liste des noms pour lesquels imprimer des cartes de Noël
     */
    private final String[] noms;

    /**
     * Chaîne du message pour être utilisée dans la fonction String.format
     */
    // %s permet d'afficher une chaîne de caractères
    private final static String MESSAGE = "Joyeux Noel %s !";

    /**
     * Coût d'impression d'un caractère
     */
    private final static float COUT_CARACTERES = 0.08f;

    /**
     * Coût de base pour l'impression d'une carte
     */
    private final static float COUT_CARTE = 1.5f;

    /**
     * Taux de taxes en vigueur
     */
    private final static float TAUX_TAXE = 0.15f;

    /**
     * Méthode principale
     * @param args paramètres du système (inutilisés)
     */
    public static void main(String[] args) {
        String[] noms = new String[] {
                "Aline", "Bertrand", "Charlene", "Damien", "Erika", "Franky", "Helene", "Ivan", "Juliette",
                "Karl", "Liliane", "Michel"
        };

        ImprimanteCarteNoel imprimante = new ImprimanteCarteNoel(noms);
        imprimante.imprimerMessages();

        float coutImpression = imprimante.calculerCoutImpression();

        System.out.println(String.format("Le cout total de l'impression est de %.2f $.", coutImpression));
    }

    /**
     * Crée une nouvelle imprimante à cartes de Noël
     * @param noms le noms devant apparaître sur les cartes
     */
    public ImprimanteCarteNoel(String[] noms) {
        this.noms = noms;
    }

    /**
     * Affiche les message pour chaque carte de Noël
     */
    public void imprimerMessages() {
        for(int i = 0; i < noms.length; i++) {
            System.out.println(String.format(MESSAGE, noms[i]));
        }
    }

    /**
     * Calcule le coût d'impression total des cartes en fonction des noms.
     * @return le coût d'impression total, incluant les taxes
     */
    public float calculerCoutImpression() {
        float cout = 0.0f;

        // Coût de base par carte - 1 carte par nom
        cout = noms.length * COUT_CARTE;

        // Cout par lettre
        for(int i = 0; i < noms.length; i++) {
            cout += noms[i].length() * COUT_CARACTERES;
        }

        // Ajout des taxes
        cout *= (1f + TAUX_TAXE);

        return cout;
    }

}

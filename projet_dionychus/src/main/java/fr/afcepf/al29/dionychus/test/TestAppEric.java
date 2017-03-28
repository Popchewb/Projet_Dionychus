package fr.afcepf.al29.dionychus.test;

/**
 * Classe de tests de qualité.
 *
 * @author ecala
 *
 */
public final class TestAppEric {
    /**
     * Constructeur par défaut.
     */
    private TestAppEric() {
        super();
    }

    /**
     * Méthode main.
     * @param args to set.
     */
    public static void main(String[] args) {
        // ApplicationContext context = new
        // ClassPathXmlApplicationContext("Beans.xml");
        // BusinessInventaireImpl buInventaire = new BusinessInventaireImpl();
        // Article vin = buInventaire.getVinById(1);
        // System.out.println(vin);
        // List<Commentaire> commentaires =
        // buInventaire.getAllByVin(vin.getIdArticle());
        // for (Commentaire commentaire : commentaires) {
        // System.out.println(commentaire);
        // }
        // List<Vin> vins = buInventaire.getAllVin();
        // for (Vin vin2 : vins) {
        // System.out.println(vin2);
        // System.out.println(vin2.getDescription());
        // }
        // List<Accessoire> accessoires = buInventaire.getAllAccessoire();
        // for (Accessoire accessoire : accessoires) {
        // System.out.println(accessoire + accessoire.getDescription());
        // }
        // List<TypeVin> typesVin = buInventaire.getAllTypeVin();
        // for (TypeVin typeVin : typesVin) {
        // System.out.println(typeVin);
        // }
        // System.out.println(buInventaire.getAccessoireById(8));
        // RegionDaoItf regionDao = (RegionDaoItf)
        // context.getBean("regionJDBCtemplate");
        // Region region = new Region(null, "testRegion");
        // region = regionDao.addRegionWithKey(region);
        // System.out.println(region);
        // CommandeClientDaoItf ccDao = (CommandeClientDaoItf)
        // context.getBean("commandeClientJDBCtemplate");
        // LigneCommandeDaoItf lcDao = (LigneCommandeDaoItf)
        // context.getBean("ligneCommandeJDBCtemplate");
        // Promotion promo = new Promotion(1, null, null, null, null, null);
        // Utilisateur user = new Utilisateur(5, null, null, null, null, null,
        // null, null, null, null, null, null, null, null);
        // StatutCommande sc = new StatutCommande(1, null);
        // CommandeClient cc = new CommandeClient(new Date(0), user, promo);
        // cc.setStatutCommande(sc);
        // cc = ccDao.addCommandeClient(cc);
        // System.out.println(cc.getIdCommande());
        // CommandeClient cc = ccDao.getCommandeClientById(1);
        // BusinessCommandeClient ccBu = new BusinessCommandeClient();
        // List<LigneCommande> lc = ccBu.getAllLigneCommandeByIdCommande(1);
        // Double total = 0.0;
        // for (LigneCommande ligneCommande : lc) {
        // total += ligneCommande.getArticle().getPrix() *
        // ligneCommande.getQuantite();
        // }
        // System.out.println(total + "€");
        // CommandeClient panier = new CommandeClient();
        // Calendar c = Calendar.getInstance();
        // java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
        // Promotion prom = new Promotion();
        // BusinessCommandeClient proxy = new BusinessCommandeClient();
        // StatutCommande stat = proxy.getStatutCommandeById(1);
        // panier.setDateCreation(date);
        // panier.setStatutCommande(stat);
        // panier.setPromotion(prom);
        // panier = proxy.addPanier(panier);
        // System.out.println(panier);
        // BusinessCompteImpl proxy = new BusinessCompteImpl();
        // System.out.println(proxy.getUserByEmail("cbravo@gmail.fr"));
    }
}

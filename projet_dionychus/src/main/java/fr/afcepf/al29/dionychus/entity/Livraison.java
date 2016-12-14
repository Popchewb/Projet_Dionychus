package fr.afcepf.al29.dionychus.entity;

public class Livraison {
	private Integer idLivraison;
	private Double tarification;
	private TypeLivraison typeLivraison;
	private CommandeClient commandeClient;
	public Livraison() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Livraison(Integer idLivraison, Double tarification, TypeLivraison typeLivraison,
			CommandeClient commandeClient) {
		super();
		this.idLivraison = idLivraison;
		this.tarification = tarification;
		this.typeLivraison = typeLivraison;
		this.commandeClient = commandeClient;
	}
	public Integer getIdLivraison() {
		return idLivraison;
	}
	public void setIdLivraison(Integer idLivraison) {
		this.idLivraison = idLivraison;
	}
	public Double getTarification() {
		return tarification;
	}
	public void setTarification(Double tarification) {
		this.tarification = tarification;
	}
	public TypeLivraison getTypeLivraison() {
		return typeLivraison;
	}
	public void setTypeLivraison(TypeLivraison typeLivraison) {
		this.typeLivraison = typeLivraison;
	}
	public CommandeClient getCommandeClient() {
		return commandeClient;
	}
	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}
	@Override
	public String toString() {
		return "Livraison [idLivraison=" + idLivraison + ", tarification=" + tarification + ", typeLivraison="
				+ typeLivraison + ", commandeClient=" + commandeClient + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commandeClient == null) ? 0 : commandeClient.hashCode());
		result = prime * result + ((idLivraison == null) ? 0 : idLivraison.hashCode());
		result = prime * result + ((tarification == null) ? 0 : tarification.hashCode());
		result = prime * result + ((typeLivraison == null) ? 0 : typeLivraison.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livraison other = (Livraison) obj;
		if (commandeClient == null) {
			if (other.commandeClient != null)
				return false;
		} else if (!commandeClient.equals(other.commandeClient))
			return false;
		if (idLivraison == null) {
			if (other.idLivraison != null)
				return false;
		} else if (!idLivraison.equals(other.idLivraison))
			return false;
		if (tarification == null) {
			if (other.tarification != null)
				return false;
		} else if (!tarification.equals(other.tarification))
			return false;
		if (typeLivraison == null) {
			if (other.typeLivraison != null)
				return false;
		} else if (!typeLivraison.equals(other.typeLivraison))
			return false;
		return true;
	}
	
	
	
	
}

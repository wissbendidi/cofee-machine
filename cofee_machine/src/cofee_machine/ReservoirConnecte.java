package cofee_machine;

public class ReservoirConnecte extends Reservoir
{

	private String adresse;
	
	
	public ReservoirConnecte(Ingredient ingredient, double capacite, String adresse)
	{
		super(ingredient, capacite);
		this.adresse=adresse;
	}
	
	
	@Override
	public void recuperer(double quantite) throws RecuperationIngredientException 
	{
        super.recuperer(quantite);
        if (this.getNiveau() / this.getCapacite() < 0.1) 
        {
            mailTo("Le reservoir est presque vide : " + this.getNiveau() + " " + this.getIngredient().getNom() + " restants.");
        }
    }

    public void mailTo(String message) {
        // Code pour envoyer un mail à l'adresse spécifiée
        System.out.println("Mail envoyé à l'adresse " + adresse + " : " + message);
    }

}

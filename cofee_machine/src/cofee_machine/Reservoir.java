package cofee_machine;
import java.util.*;

public class Reservoir 
{
	private Ingredient Ingredient;
	private double capacite;
	private double niveau;
	
	
	
	public Reservoir(Ingredient Ingredient, double capacite)
	{
		this.Ingredient= Ingredient;
		this.capacite=capacite;
		this.niveau=capacite;
	}
	
	
	public Ingredient getIngredient()
	{
		return Ingredient;
	}
	
	public double getNiveau()
	{
		return niveau; 
	}
	
	public double getCapacite()
	{
		return capacite;
	}
	
	public void remplir()
	{
		this.niveau=capacite;
	}
	
	
	public synchronized void recuperer(double quantite) throws RecuperationIngredientException 
	{
	    if (quantite <= 0) 
	    {
	        throw new IllegalArgumentException("La quantité doit être positive !");
	    }

	    if (quantite > niveau) 
	    {
	        throw new RecuperationIngredientException("Impossible de récupérer " + quantite + ". Quantité disponible : " + niveau);
	    }

	    this.niveau-=quantite;
	}

	
	
		
		
}
	
	

	
		




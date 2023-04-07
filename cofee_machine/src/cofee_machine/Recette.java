package cofee_machine;

import java.util.*;

public abstract class Recette implements Chauffable
{
	 	private String nom;
	    private Ingredient[] ingredients;
	    private double[] quantites;
	    private double prix;
	    
	    

	    public Recette(String nom, Ingredient[] ingredients, double[] quantites, double prix)
	    {
	        this.nom = nom;
	        this.ingredients = ingredients;
	        this.quantites = quantites;
	        this.prix = prix;
	    }
	    
	    

	    public String getNom() 
	    {
	        return nom;
	    }
	    
	    
	    
	    public Ingredient getIngredient(int i)
	    {
	    	return this.ingredients[i];
	    }

	    
	    
	    public Ingredient[] getIngredients() 
	    {
	        return ingredients;
	    }
	    
	    

	    public double[] getQuantites() 
	    {
	        return quantites;
	    }
	    
	    
	    public double getQuantites(int i)
	    {
	    	return this.quantites[i];
	    }


	    
	    
	    public double getPrix() 
	    {
	        return prix;
	    }
	    
	    
	 

	    
	    
	    public boolean estChauffable() 
	    {
	        return true;
	    }
	    
	    
	    
		public boolean testerSystemeRechauffement() throws DefaillanceException {
	        if (!estChauffable()) {
	            return true; // l'ingrédient n'a pas besoin de chauffage, donc il passe le test
	        }
	        // simuler une panne dans 1 cas sur 100
	        Random random = new Random();
	        if (random.nextInt(100) == 0) {
	            throw new DefaillanceException("Défaillance du système de chauffage.");
	        }
	        return true;
	    }
		
}

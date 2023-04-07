package cofee_machine;
import java.util.*;


public abstract class Ingredient implements Chauffable
{
	public String nom;
	
	
	public Ingredient(String nom)
	{
		this.nom=nom;
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	
	
	public String toString()
	{
		return nom;
	}
	
	
	@Override 
	public boolean equals(Object o)
	{
		if(o==null) return false;
		if(!( o instanceof Ingredient)) return false;
		Ingredient N=(Ingredient)o;
		return (N.nom).equals(nom);
	}
	
	public boolean estChauffable()
	{
		return true;
	}
	
	
	
	public boolean testerSystemeRechauffement() throws DefaillanceException 
	{
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

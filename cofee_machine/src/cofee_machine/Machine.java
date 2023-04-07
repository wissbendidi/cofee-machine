package cofee_machine;
//On importe ces classes pour pouvoir les utiliser 
import cofee_machine.Ingredient; 
import cofee_machine.Reservoir;
import cofee_machine.Recette;
import java.util.*;

public class Machine 
{
	private static int compteur = 0;
    private int id;
    private List<Reservoir> reservoirs;
    private List<Recette> recettes;
    private double credit;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Chauffable> chauffables;
    
    
    
    public Machine() 
    {
        this.id = ++compteur;
        this.reservoirs = new ArrayList<>();
        this.recettes = new ArrayList<>();
        this.credit = 0;
        ingredients = new ArrayList<Ingredient>();
        
        chauffables = new ArrayList<Chauffable>(); // initialisation du tableau des chauffables
    }

    
    
    public void ajouterReservoir(Reservoir r) 
    {
        this.reservoirs.add(r);
    }
    
    

    public void ajouterRecette(Recette r) 
    {
        this.recettes.add(r);
        if (r instanceof Chauffable) 
        { 
        	// si la recette est chauffable, on l'ajoute au tableau des chauffables
            chauffables.add((Chauffable) r);
        }
    }
    

    public void ajouterCredit(double d) 
    {
        this.credit += d;
    }
    

    public void rendreLaMonnaie() 
    {
        this.credit = 0;
    }
    
    public void remplir()
    {
    	for (Reservoir r : reservoirs) 
    	{
    		r.remplir();
    	}
    }
    
    
    
 // méthode pour ajouter un ingrédient
    public void ajouterIngredient(Ingredient i) {
        ingredients.add(i);
        if (i instanceof Chauffable) { // si l'ingrédient est chauffable, on l'ajoute au tableau des chauffables
            chauffables.add((Chauffable) i);
        }
    }
    
  
    
    
    
    
    
    private Reservoir trouverReservoir(Ingredient i)
    {
    	for(Reservoir r : reservoirs)
    	{
    		if(r.getIngredient().equals(i))
    			return r;
    	}
    	return null;
    }
    
    
    
    
    
    
    
    
    public boolean checkup()
    {
    	for (Recette r : recettes)
    	{
    		for(int i=0; i<recettes.size(); i++)
    		{
    			if(trouverReservoir(r.getIngredient(i))==null)
    			{
    				return false;
    			}
        		System.out.println(r.getIngredient(i) + " OK");

    		}
    	}
    	return true;
    }
    
    
    
    
    
    
    
    public boolean commander(int ri) throws RecuperationIngredientException
    {
    	if(ri<1 || ri>recettes.size())
    	{
    		System.out.println("Recette inexistante ");
    		return false;
    	}
    	
    	
    	//On accéde à l'élément d'index ri - 1 de la liste recettes
    	Recette recette = recettes.get(ri - 1);
    	
    	if (!checkup())
    	{
    		System.out.println("Impossible de réaliser cette recette" + recette.getNom());
    		return false;
    	}
    	
    	
    	
    	double prix =recette.getPrix();
    	if(credit<prix)
    	{
    		System.out.println("Crédit insuffisant ");
    		return false;
    	}
    	
    	
    	
    	System.out.println("Préparation de la recette : " + recette.getNom());
    	
    	
    	
    	 for (Ingredient ingr : recette.getIngredients()) {
    	        Reservoir res = trouverReservoir(ingr);
    	        if (res == null) {
    	            System.out.println("Erreur : réservoir manquant pour l'ingrédient " + ingr.getNom());
    	            return false;
    	        }
    	        
    	        for(int i=0; i<recettes.size(); i++)
    	        {
    	        	 if (res.getNiveau() < recette.getQuantites(i)) 
    	        	 {
    	        		 
    	    	            System.out.println("Erreur : quantité insuffisante dans le réservoir pour l'ingrédient " + ingr.getNom());
    	    	            return false;
    	    	     }
    	        	 res.recuperer(recette.getQuantites(i));
    	    	     System.out.println("Prélèvement de " + recette.getQuantites(i) + " cl d'" + ingr.getNom() + " du réservoir ");
    	        }
    	        
    	    }

    	    System.out.println("Préparation en cours...");
    	    try {
    	        Thread.sleep(5000); // attente de 5 secondes pour simuler la préparation
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }

    	    System.out.println("Recette prête !");
    	    credit -= prix;
    	    System.out.println("Crédit restant : " + credit);
    	    return true;

    	
    }
    
    
    
 // méthode pour tester le système de chauffage
    private boolean testRechauffement() 
    {
        for (Chauffable c : chauffables) 
        {
            try 
            {
                c.testerSystemeRechauffement(); // on teste chaque chauffable
            } 
            catch (DefaillanceException e) 
            {
                System.out.println("Défaillance détectée pour le chauffable " + c);
                return false; // s'il y a une défaillance, on arrête le test et on retourne false
            }
        }
        return true; // si on a testé tous les chauffables sans problème, on retourne true
    
      
        
            
        

    }

    

}

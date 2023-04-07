package cofee_machine;
import java.util.*;

public class Robinet extends Reservoir
{
	private static final double INFINITY= Double.POSITIVE_INFINITY;
	private boolean isOpen;
	
	public Robinet(Ingredient ingredient)
	{
		super(ingredient, INFINITY);
		this.isOpen=false;
		
	}
	
	public void ouvrir()
	{
		this.isOpen=true;
	}
	
	public void fermer()
	{
		this.isOpen=false;
	}
	
	public boolean est_ouvert()
	{
		return isOpen;
	}
	
	
	public void recuperer(double quantite) throws RecuperationIngredientException 
	{
        if (isOpen) {
            if (new Random().nextInt(500) == 0) {
                System.out.println("Attention : problème de fonctionnement du robinet, vérifiez qu'il est bien ouvert.");
                return;
            }
            super.recuperer(quantite);
        } else {
            System.out.println("Erreur : le robinet est fermé, ouvrez-le d'abord.");
        }
    }
	
	
}

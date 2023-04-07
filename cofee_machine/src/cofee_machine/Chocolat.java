package cofee_machine;
import java.util.*;

public class Chocolat extends Ingredient implements Chauffable
{
	public Chocolat()
	{
		super("Chocolat");
	}

	 @Override
	    public boolean testerSystemeRechauffement() 
	 {
	        // Simuler une panne dans 1 cas sur 100
	        Random rand = new Random();
	        int randomNum = rand.nextInt(100);
	        if (randomNum == 0) {
	            return false; // panne détectée
	        } else {
	            return true; // pas de panne détectée
	        }
	    }

	
	

}

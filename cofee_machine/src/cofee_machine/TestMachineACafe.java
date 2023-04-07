package cofee_machine;

public class TestMachineACafe 
{
	public static void main(String[] args) throws RecuperationIngredientException
	{
//Ici on teste les classes d'ingredients qui héritent d'Ingredient, 
//On teste aussi Ingredient
		Cafe c1= new Cafe();
		Chocolat c2= new Chocolat();
		Eau c3= new Eau();
		Lait c4= new Lait();
		Cafe c5= new Cafe();
		System.out.println(c1.equals(c4));
		System.out.println(c1.equals(c5));
		
//On teste la classe Reservoir
		Reservoir reservoir = new Reservoir(c1, 1);
		System.out.println("Capacite du réservoir :"+ reservoir.getCapacite() + "L");
		System.out.println("Niveau du réservoir :" + reservoir.getNiveau()+ "L");
		reservoir.remplir();
		System.out.println("Niveau du réservoir après remplissage :"+ reservoir.getNiveau()+"L");
		
		reservoir.recuperer(0.5);
		System.out.println("Niveau du réservoir après récupération de 0.5L :"+ reservoir.getNiveau()+"L");

		
//On teste la classe Robinet qui hérite de la classe Reservoir		
		Robinet robinet= new Robinet(c3);
		System.out.println("Capacite du robinet :"+ robinet.getCapacite() + "L");
		System.out.println("Niveau du robinet :" + robinet.getNiveau()+ "L");
		
		robinet.ouvrir();
        System.out.println("Le robinet est ouvert : " + robinet.est_ouvert());
 
        robinet.recuperer(0.5);
        System.out.println("Niveau du robinet après récupération de 0.5 L : " + robinet.getNiveau() + " L");
        
        robinet.fermer();
        System.out.println("Le robinet est ouvert :" + robinet.est_ouvert());
        robinet.recuperer(0.5);
        
        System.out.println();
        
        
//On teste la classe Recette, or elle est abstraite, c'est pourquoi on a implementé une sous-classe concrète d'une classe abstraite
// On teste alors la classe RecetteCafe qui hérite les mêmes methodes que Recette...
        double[] quantites1= { 0.25,0.015};
        double prix1= 1.5;
        String nom1= "Café au lait";
        Ingredient[] ingredient= {c1,c4};
        RecetteCafe recettecafe1 = new RecetteCafe(nom1, prix1, ingredient,quantites1);
        System.out.println("Les ingredients du " +nom1+" sont");
        for (Ingredient ingredient1 : recettecafe1.getIngredients())
        {
        	System.out.println(ingredient1.getNom());
        }
        
        System.out.println();
        
        double[] quantites2= { 0.5,0.15};
        double prix2= 2.0;
        String nom2= "Chocolat chaud";
        Ingredient[] ingredient2= {c2,c3};
        RecetteCafe recettecafe2 = new RecetteCafe(nom2, prix2, ingredient2,quantites2);
        System.out.println("Les ingredients du " +nom2 +" sont");
        for (Ingredient ingredients : recettecafe2.getIngredients())
        {
        	System.out.println(ingredients.getNom());
        }
        
        
        
        
        
 //On teste la classe Machine maintenant... 
        Machine machine=new Machine();
        Reservoir reservoir1 = new Reservoir(c1, 1.0);
        Reservoir reservoir2 = new Reservoir(c4, 2.5);
        Reservoir reservoir3 = new Reservoir(c2, 3.1);
        Reservoir reservoir4 = new Reservoir(c3, 5.1);

        machine.ajouterReservoir(reservoir1);
        machine.ajouterReservoir(reservoir2);
        machine.ajouterReservoir(reservoir3);
        machine.ajouterReservoir(reservoir4);

        machine.ajouterRecette(recettecafe1);
        machine.ajouterRecette(recettecafe2);
        machine.ajouterCredit(4.5);
        reservoir1.remplir();
        reservoir2.remplir();
        System.out.println("Les ingredients dispo "+ machine.checkup());
        
        
        int ri=1;
        boolean res= machine.commander(ri);
        
        if (res) {
            System.out.println("Recette réalisée avec succès !");
        } else {
            System.out.println("Echec de la réalisation de la recette...");
        }
        
        String adresse= "WissBendidi";
        ReservoirConnecte rc= new ReservoirConnecte(c1, 1.0, adresse);
        rc.recuperer(0.5);
        rc.mailTo("this is an automatic message, do not answer :)");
        
       
	
	}
}

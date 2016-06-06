package vue;
import modele.Grille;

public class Vue {
	public static void afficherGrille(Grille g)
	{
		
		int i,j;
		
		for(i=0;i<Grille.cote;i++)
	    {
			System.out.print("\t");
	    	for(j=0;j<Grille.cote;j++)
	    	{
	    		
	    		System.out.print(g.getTab()[j][i].getEtat());
	    		if(Character.isUpperCase(g.getTab()[j][i].getEtat()))
	    			System.out.print("<");
	    		System.out.print("\t");
	    	}
	    	System.out.print("\n");
	    }
	}
}

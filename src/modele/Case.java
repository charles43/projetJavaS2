package modele;


public class Case {
	private char etat;
	private int x;
	private int y;
	Case(char etat, int x, int y)
	{
		this.etat = etat;
		this.x=x;
		this.y=y;
	}
	
	public char getEtat()
	{
		return etat;
	}
	public void setEtat(char nouvelEtat)
	{
		etat=nouvelEtat;
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	public void casesTouchees(Grille g, char nouvelleCouleur, Joueur proprietaire)
	{
		int i,j;
		for(i=x-1;i<=x+1;i++)
		{
			for(j=y-1;j<=y+1;j++)
			{
				if(i>=0 && i<=Grille.cote-1 && j>=0 && j<=Grille.cote-1)
				{
					Case laCase=g.getTab()[i][j];
					if(laCase.etat==nouvelleCouleur)
					{
						proprietaire.ajouterPossession(laCase,g);
					}
				}
			}
		}
	}
	
	public int nbCasesTouchees(Grille g, char nouvelleCouleur, Joueur proprietaire)
	{
		int i,j,nb=0;
		
		for(i=x-1;i<=x+1;i++)
		{
			for(j=y-1;j<=y+1;j++)
			{
				if(i>=0 && i<=Grille.cote-1 && j>=0 && j<=Grille.cote-1)
				{
					Case laCase=g.getTab()[i][j];
					if(laCase.etat==Character.toLowerCase(nouvelleCouleur))
					{
						nb++;
					}
				}
			}
		}
		return nb;
	}
}
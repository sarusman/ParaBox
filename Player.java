public class Player{
	public static int playerX;
	public static int playerY;

	public Player(){
		playerX=1;
		playerY=1;
	}
	public Player(Matrice mat){
		int[] pos=findPatrik(mat);
		playerX=pos[0];
		playerY=pos[1];
	}

	public int[] findPatrik(Matrice mat){
		int[] poss=new int[2];
		for (int i=0; i<mat.lines; i++){
			for (int j=0; j<mat.columns; j++){
				if (mat.matrice[i][j]=='A'){
					poss[0]=i;
					poss[1]=j;
					return poss;
				}
			}
		}
		return poss;
	}
}
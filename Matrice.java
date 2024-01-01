import java.lang.*;
import java.io.*;
import java.util.*;

public class Matrice {
	public static char[][] matrice;
	public int lines;
	public int columns;

	public Matrice(){
		this.matrice=new char[0][0];
	}


	public Matrice(String file){
		BufferedReader reader;
		int[] sizeFf=sizeF(file);
		this.lines=sizeFf[0]+1;
		this.columns=sizeFf[1];
		System.out.println(lines);
		System.out.println(columns);
		this.matrice=new char[lines][columns];

	    File files = new File(file);
	    Scanner scanner;
	    try {
	        scanner = new Scanner(files);
	        int nb=0;
		    while (scanner.hasNextLine()) {
		    	String lin=scanner.nextLine();
		    	for (int i=0; i<lin.length(); i++){
		    		matrice[nb][i]=lin.charAt(i);
		    	}
		    	nb++;
		    }
		    scanner.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }

	}

	public int[] sizeF(String filename) {
		int[] tab=new int[2];
	    File file = new File(filename);
	    Scanner scanner;
	    try {
	        scanner = new Scanner(file);
		    int number=0;
		    if (scanner.hasNextLine()) {
		        tab[1]=scanner.nextLine().length();
		    }
		    while (scanner.hasNextLine()) {
		    	number++;
		    	scanner.nextLine();
		    }
		    tab[0]=number;
		    scanner.close();
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    }
	    return tab;
	}
	public void affMat(){
        for (int i=0; i<lines; i++){
            System.out.println(matrice[i]);
        }
	}


	public boolean movePatrik(int posX, int posY, Direction dir){
		if (dir==Direction.NORD && matrice[posX-1][posY]!='#'){
			matrice[posX][posY]=' ';
			matrice[posX-1][posY]='A';
		}else if (dir==Direction.EST&& matrice[posX][posY+1]!='#'){
			matrice[posX][posY]=' ';
			matrice[posX][posY+1]='A';
		}else if (dir==Direction.OUEST&& matrice[posX][posY-1]!='#'){
			matrice[posX][posY]=' ';
			matrice[posX][posY-1]='A';
		}else if (dir==Direction.SUD&& matrice[posX+1][posY]!='#'){
			matrice[posX][posY]=' ';
			matrice[posX+1][posY]='A';
		}else{
			return false;
		}
		return true;
	}

















}
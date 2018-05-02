import java.util.Scanner;
import java.util.Random;

public class Battleship {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		System.out.println("****Welcome to the game of BattleShip****\n");
		System.out.println("Right now, the sea is empty\n");
		//System.out.println(String.valueOf("0"));

		//Inserting the values into the grid
		String[][] grid = new String[12][14];
		for (int i=0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if ((i > 0 && i < 11) || (j > 1 && j < 12)) {
					if (j == 1 || j == 12) {
						grid[i][j] = "|";
					}else {
						if (i>0 && j>1 && i<11 && j<12) {
							grid[i][j] = " ";
						}else {
							grid[i][j] = "0";
						}
					}
				}else {
					grid[i][j] = " ";
				}
				
				//Having the numerics 0-9 on top and bottom
				if(i==0 || i==11){
					int count = 0;
					for (int j1 = 2; j1 < (grid[i].length) - 2; j1++) {
						if(count < 10) {
							grid[i][j1] = Integer.toString(count);
							count++;
						}
					}
				}
				
				//Having the numerics 0-9 on left and right
				if(j==0 || j==13){
					int count = 0;
					for (int i1 = 1; i1 < (grid.length) - 1; i1++) {
						if(count < 10) {
							grid[i1][j] = String.valueOf(count);
							count++;
						}
					}
				}
				
			}
		}
		
		//Displaying the grid
		for (String[] x : grid)
		{
		   for (String y : x)
		   {
		        System.out.print(y + " ");
		   }
		   System.out.println();
		}
		
        //Code asking the user to enter in the coordinates for where to place a ship
		
		System.out.println("\nDEPLOY YOUR SHIPS:");
		for (int number = 1; number < 6; number++) {
			System.out.println("\n");
			System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			System.out.print("Enter X coordinate for your ship: ");
	        int x = input.nextInt();
	        System.out.print("Enter Y coordinate for your ship: ");
	        int y = input.nextInt();
			if(((x+1)<12 && (y+2)<12 && (x+1)>0 && (y+2)>0)) {
				if (grid[x+1][y+2] != "@") {
					grid[x+1][y+2] = "@";
					System.out.println("The ship is introduced into the sea");
				}else {
					System.out.println("There is already a specific ship in that location. Please re-enter coordinates.");
					number--;
				}
			}else {
				System.out.println("The ship shall be outside the sea. Please re-enter coordinates.");
				number--;
			}
			
//			//Displaying the grid
//			for (String[] x1 : grid){
//			   for (String y1 : x1)
//			   {
//			        System.out.print(y1 + " ");
//			   }
//			   System.out.println();
//			}
//			System.out.println("\n");	
	    }
		
		//Displaying the grid
//		for (String[] x1 : grid){
//		   for (String y1 : x1)
//		   {
//		        System.out.print(y1 + " ");
//		   }
//		   System.out.println();
//		}
//		System.out.println("\n");
		
		//Code where the computer randomly inserts ships in the sea.
		
		System.out.println("\nComputer is deploying ships");
		for (int number = 1; number < 6; number++) {
			
			//System.out.println();
			//System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			//System.out.print("Enter X coordinate for your ship: ");
	        
			Random rand = new Random();
			
			int x = rand.nextInt(9)+1;
	        //System.out.print("Enter Y coordinate for your ship: ");
	        
	        int y = rand.nextInt(9)+1;
	        
			if(((x+1)<12 && (y+2)<12)) {
				if (grid[x+1][y+2] != "#") {
					grid[x+1][y+2] = "#";
					System.out.println("" + number + "ship DEPLOYED");
				}else {
					//System.out.println("There is already a specific ship in that location. Please re-enter coordinates.");
					number--;
				}
			}else {
				//System.out.println("The ship shall be outside the sea. Please re-enter coordinates.");
				number--;
			}
			
			//Displaying the grid
//			for (String[] x1 : grid){
//			   for (String y1 : x1)
//			   {
//			        System.out.print(y1 + " ");
//			   }
//			   System.out.println();
//			}
//			System.out.println("\n");	
		}
		
		//Displaying the grid
		System.out.println("\n");
		for (String[] x1 : grid){
		   for (String y1 : x1)
		   {
		        System.out.print(y1 + " ");
		   }
		   System.out.println();
		}
		System.out.println("\n");	
		
		//////////////////////////////////////////////////////////////////////////////////////////
		//Battle starts
		int user_guess = 0;
		int comp_guess = 0;
		
		//User guessing the ship
		for (int number = 1; number < 11; number++) {
			System.out.println("YOUR TURN");
			//System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			
			System.out.print("Enter X coordinate: ");
			int x = input.nextInt();
	        System.out.print("Enter Y coordinate: ");
	        int y = input.nextInt();
			
	        if(((x+1)<12 && (y+2)<12 && (x+1)>0 && (y+2)>0)) {
				if (grid[x+1][y+2] != "#") {                        //Correct guess
					grid[x+1][y+2] = "!";
					System.out.println("Boom! You sunk the ship!");
				}else {                                             //Own ship guess
					if (grid[x+1][y+2] != "@") {
						grid[x+1][y+2] = "x";
						System.out.println("Oh no, you sunk your own ship :(");
						number--;
					}
				}
			}else {                                                 //Wrong guess
				System.out.println("Sorry, you missed");
				grid[x+1][y+2] = "-";;
			}
	        
			//Code to calculate user_guess not crossing 5.
	        /////////////////////////////////////////////
	        
			//Computer guessing the ship
			
			Random rand = new Random();
			
			int xC = rand.nextInt(9)+1;
	        //System.out.print("Enter Y coordinate for your ship: ");
	        
	        int yC = rand.nextInt(9)+1;
	        
			if(((xC+1)<12 && (yC+2)<12)) {
				if (grid[xC+1][yC+2] != "#") {
					grid[xC+1][yC+2] = "#";
					System.out.println("" + number + "ship DEPLOYED");
				}else {
					//System.out.println("There is already a specific ship in that location. Please re-enter coordinates.");
					number--;
				}
			}else {
				//System.out.println("The ship shall be outside the sea. Please re-enter coordinates.");
				number--;
			}
		}
		
	}
}












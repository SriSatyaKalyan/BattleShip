import java.util.Scanner;
import java.util.Random;

public class Battleship {
	
	//This below line makes sure that it is OK even when the Scanner input leak is never closed.
	@SuppressWarnings("resource")
	
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
			//System.out.println("\n");
			System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			System.out.print("Enter X coordinate for your ship: ");
	        int x = input.nextInt();
	        System.out.print("Enter Y coordinate for your ship: ");
	        int y = input.nextInt();
			if(((x+1)<12 && (y+2)<12 && (x+1)>0 && (y+2)>0)) {
				if (grid[x+1][y+2] != "@") {
					grid[x+1][y+2] = "@";
					System.out.println("The ship is introduced into the sea\n");
				}else {
					System.out.println("There is already a specific ship in that location. Please re-enter coordinates.\n");
					number--;
				}
			}else {
				System.out.println("The ship shall be outside the sea. Please re-enter coordinates.\n");
				number--;
			}
			
	    }
		
		//Code where the computer randomly inserts ships in the sea.
		System.out.println("\nComputer is deploying ships");
		for (int number = 1; number < 6; number++) {

			Random rand = new Random();
			int x = rand.nextInt(9)+1;
	        //System.out.print("Enter Y coordinate for your ship: ");
	        int y = rand.nextInt(9)+1;
	        //System.out.println(x + " " + y);
	    
			if(((x+1)<12 && (y+2)<12)) {
				if (grid[x+1][y+2] != "#" && grid[x+1][y+2] != "@") {
					grid[x+1][y+2] = "#";
					System.out.println("Ship " + number + " DEPLOYED");
				}else {
					number--;
				}
			}else {
				number--;
			}
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
		
		//Battle starts
		System.out.println("BattleShip Game Starts");
		int comp_ships = 5;
		int user_ships = 5;
		
		//User guessing the ship
		while (true) {
			System.out.print("-------------------------------------\n");
			System.out.println("YOUR TURN ");
			//System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			
			//System.out.println("USER's " + number + " try");
			System.out.print("Enter X coordinate: ");
			int x = input.nextInt();
	        System.out.print("Enter Y coordinate: ");
	        int y = input.nextInt();
			
	        if(((x+1)<12 && (y+2)<12 && (x+1)>0 && (y+2)>0 && x>0 && y>0)) {
				if (grid[x+1][y+2] == "#") {                        //Correct guess
					grid[x+1][y+2] = "!";
					System.out.println("Boom! You sunk the COMPs ship!\n");
					//user_guess += 1;
					comp_ships -= 1;
				}else if(grid[x+1][y+2] == "@") {                    //Own ship guess
						grid[x+1][y+2] = "x";
						System.out.println("Oh no, you sunk your own ship :(\n");
						user_ships -= 1;
				}else if (grid[x+1][y+2] == "-") {
					System.out.println("The ships are not moving. Don't guess the wrong co-ordinate twice.\n");
				}else if (grid[x+1][y+2] == "!") {
					System.out.println("You/COMP have sunk the ship already.\n");
				}else if (grid[x+1][y+2] == "x") {
					System.out.println("How many times will you sink your own ship? Play wisely.\n");
				}else {                                                 //Wrong guess
				System.out.println("Sorry, you missed\n");
				grid[x+1][y+2] = "-";;
				}
	        }else {
	        	System.out.println("Enter valid numbers. You wasted a chance\n");
	        }
	        
			//Code to calculate user_guess not crossing 5.
	        
	        if (user_ships == 0) {
	        	System.out.println("COMP won the Battle");
	        	break;
	        }

			//Computer guessing the ship
			
			System.out.println("COMP's TURN ");
			//System.out.println("USER's " + number + " try");
			Random rand = new Random();
			int xC = rand.nextInt(9)+1;
	        int yC = rand.nextInt(9)+1;
	        System.out.println(xC + " " + yC);
			
	        if(((xC+1)<12 && (yC+2)<12)) {
				//System.out.println("You entered the Computers loop");
				if (grid[xC+1][yC+2] == "@") {                //Correct guess
					grid[xC+1][yC+2] = "x";
					System.out.println("Boom! COMP sunk the USERs ship!\n");
					//comp_guess += 1;
					user_ships -= 1;
				}else if (grid[xC+1][yC+2] == "#") {          //Own ship guess
						grid[xC+1][yC+2] = "!";
						System.out.println("Oh no, COMP sunk it's own ship :)\n");
						comp_ships -= 1;
				}else if (grid[xC+1][yC+2] == "+") {
					System.out.println("COMP guessed the wrong co-ordinate twice.\n");
				}else if (grid[xC+1][yC+2] == "x") {
					System.out.println("You/COMP have sunk the ship already.\n");
				}else if (grid[xC+1][yC+2] == "!") {
					System.out.println("COMP has tried to sink it's already sunk ship.\n");
				}else {                                       //Wrong guess
					System.out.println("COMP missed.\n");
					grid[xC+1][yC+2] = "+";
				}
	        }
			
			//Code to calculate comp_guess not crossing 5.
	        if (comp_ships == 0) {
	        	System.out.println("USER won the Battle");
	        	break;
	        }				 
		}
		
		System.out.print("-------------------------------------\n");
		System.out.println("THE game ENDed");
		
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
		System.out.println("Your ships: " + user_ships + " | Computer ships: " + comp_ships);
		System.out.println("-------------------------------------");
		
	}
}
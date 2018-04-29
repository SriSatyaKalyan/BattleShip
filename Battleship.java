import java.util.Scanner;

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
		System.out.println("\n");
		for (int number = 1; number<6; number++) {
			System.out.print("Enter the coordinates of the ship numbered " + number + "\n");
			System.out.print("Enter X coordinate for your ship: ");
	        int x = input.nextInt();
	        System.out.print("Enter Y coordinate for your ship: ");
	        int y = input.nextInt();
			if(((x+1)<12 && (y+2)<12)) {
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
			
			//Displaying the grid
			for (String[] x1 : grid){
			   for (String y1 : x1)
			   {
			        System.out.print(y1 + " ");
			   }
			   System.out.println();
			}
			System.out.println("\n");
			
	    }

	}
}












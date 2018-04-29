import java.util.Arrays;

public class Battleship {
	
	public static void main(String[] args) {
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
					for (int j1 = 2; j1 < (grid[i].length) - 2; j1++) {
						for (int count = 0; count < 10; count++) {
							grid[i][j1] = Integer.toString(count);
							//Facing issues here as the whole loop is running the 
							//count till 9 and then entering the value
						}
					}
				}
				
				//Having the numerics 0-9 on left and right
				if(j==0 || j==13){
					for (int i1 = 1; i1 < (grid.length) - 1; i1++) {
						for (int count = 0; count < 10; count++) {
							grid[i1][j] = String.valueOf(count);
							//Facing issues here as the whole loop is running the 
							//count till 9 and then entering the value
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
		
	}
}
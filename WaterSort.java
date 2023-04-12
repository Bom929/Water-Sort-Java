import java.util.Scanner;
import java.util.Random;
class WaterSort {
	Character top = null;
	// create constants for colors
	static Character red= new Character('r');
	static Character blue = new Character('b');
	static Character yellow= new Character('g');
	// Bottles declaration
	
	
	public static void showAll( StackAsMyArrayList bottles[])
	{
		for (int i = 0; i<=4; i++)
		 {
			 System.out.println("Bottle "+ i+ ": " + bottles[i]);
			 
		 }
	}
	
	public static boolean solved(StackAsMyArrayList bottles[])
	{
		boolean test = false;
		int tel = 0;
		int uni = 0;
		
		for (int i = 0;i < 5;i++)
		{
			if (bottles[i].checkStackUniform() == true && bottles[i].getStackSize() == 4)
			{
				uni++;
				//test = true;
			}
			else if(bottles[i].getStackSize() == 0)
			{
				tel++;
				
				//test = true;
			}
			if (uni == 3 && tel ==2)
			{
				test = true;
			}
			//tel++;
		}
		
		return test;
		
	}
	
    public static void main(String args[])
    {
		boolean test = false;
		boolean bol = false;
		Scanner myObj = new Scanner(System.in);
		Integer in1, in2;
		
		 int moves = 0;// number of moves to mix the water
		 int source = 0; // number of bottle to pour FROM
		 int target = 0; // number of bottle to pour TO
		 int max = 4; // total number of items allowed per bottle
		 Random randomNum = new Random();
		 // Bottles declaration
		 StackAsMyArrayList bottles[] = new StackAsMyArrayList[5];
		 //You can do this with a for also
		 bottles[0] = new StackAsMyArrayList<Character>();
		 bottles[1] = new StackAsMyArrayList<Character>();
		 bottles[2] = new StackAsMyArrayList<Character>();
		 bottles[3] = new StackAsMyArrayList<Character>();
		 bottles[4] = new StackAsMyArrayList<Character>();
		 
		 //////STRATEGY #1
		 while (moves<4) // 4 moves per 3 colors = 12 moves required
        {
          // get source bottle
          target = randomNum.nextInt(max+1);
          while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(blue);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(red);
		  target = randomNum.nextInt(max+1);
		  while (bottles[target].getStackSize() == 4)// target is full
             {
               target = randomNum.nextInt(max);
             }
          bottles[target].push(yellow);
          showAll(bottles);
          // increment valid moves
          moves++;
        }
		
		 ///// STRATEGY #2
		 
		 
		 // Fill 3 bottles with specific colors
		 // need not be uniform colours - just easy to do it with a for
		/* for (int i = 0; i<4; i++)
		 {
			 bottles[0].push(red);
			 bottles[1].push(blue);
			 bottles[2].push(yellow);
			
		 }
		 // show all bottles
		 showAll(bottles);
		 
		 // Creating initial problem for player to solve with random numbers
		
	    int moves = 0;
		int max = 4;
		Random randomNum = new Random();
	    while (moves<=100) // use 100 valid moves to mix bottles
	    {
		  // get source bottle
          source = randomNum.nextInt(max);
		  while (bottles[source].getStackSize() ==0)// source is empty
		  {
			  source = randomNum.nextInt(max);
		  }
	      System.out.println(source);
		  // get target bottle
		  target =  randomNum.nextInt(max);
		  while (bottles[target].getStackSize() == 4)// target is full
		  {
			  target = randomNum.nextInt(max);
		  }
	      System.out.println(target);
		  // pour from source to target
		  bottles[target].push(bottles[source].pop());
		  
		  //show bottles
		  showAll(bottles);
		 
		  // increment valid moves
    	  moves++;
		}
		*/
		System.out.println("Bottles to sort");
		moves = 0; 
		while (test == false)
		{
			bol = true;
			showAll(bottles);
			
			System.out.println("Bottle to be moved from:");
			in1 = myObj.nextInt();
			
			
			System.out.println("Bottle to be move to:");
			in2 = myObj.nextInt();
			
			if (in1 <= 4 && in1 >= 0 )
			{
				System.out.println("Not a valid bottle to move from, pick a valid one:");
				in1 = myObj.nextInt();
			}
			else if  (in2 <= 4 && in2 >= 0)
			{
				System.out.println("Not a valid bottle to move to, pick a valid one:");
				in2 = myObj.nextInt();
			}
			
			
			if (bottles[in2].getStackSize() != max)
			{
				bottles[in2].push(bottles[in1].pop());
				if (bottles[in2].peek() == bottles[in1].peek())
				{
					bol = false;
					while (bottles[in2].peek() == bottles[in1].peek() || bol != true)
					{
						if (bottles[in2].getStackSize() != max)
						{
							bottles[in2].push(bottles[in1].pop());
						}
						else
						{
							bol = true;
						}
					}
				}
			}
			else if (bottles[in2].getStackSize() == max)
			{
				System.out.println("The bottle of you choice is full please pick a new on:");
				in2 = myObj.nextInt();
			}
			
			while (bottles[in2].peek() == bottles[in1].peek())
			{
				bottles[in2].push(bottles[in1].pop());
			}
						
			test = solved(bottles);
			moves++;
			
		}
		
		if (test == true)
		{
			showAll(bottles);
			System.out.println("You solved the puzzle in : " + moves + " moves");
		}

    }
}

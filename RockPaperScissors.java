import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

	/**
	 * main
	 */
	public static void main(String[] args){
		
		// variables
		int playerScore = 0;
		int pcScore = 0;
		String playerItem;
		String randItem;

					
		System.out.println("How many rounds?");
		Scanner input = new Scanner(System.in);
		int rounds = input.nextInt();
		int counter = rounds;
		
		// dynamic method dispatch
		ItemOperation operation = null;
		
		while(rounds > 0){
			
			rounds --;				
			
			System.out.println("Make your choice for round - " + (counter - rounds));
			playerItem = input.next(); // read user input
			
			//generate random item
			randItem = getRandomItem(); 
				
			// polymorphical call
			switch(playerItem)
			{
			case "rock":
				operation = new Rock(randItem);
				operation.attack();
				break;
			case "paper":
				operation = new Paper(randItem);
				operation.attack();
				break;
			case "scissor":
				operation = new Scissor(randItem);
				operation.attack();
				break;
			default:
				System.out.println("This round will not count! Pick either rock, paper or scissor.");
				rounds ++;
				break;				
			}
			
			// check for the results and increment
			if (operation == null){
				continue;
			}
			else if (operation.attack() == "You win!"){
				playerScore ++;
			}
			else if (operation.attack() == "Your opponent wins!"){
				pcScore ++;
			}
							
			// print round score
			System.out.println("You chose " + playerItem 
								+ ", your opponent chose " + randItem
								+ ". " + operation.attack());
			// set object to null
			operation = null;
		}// end of while
		
		// print final score
		System.out.println("Result: You won " + playerScore
							+ " times, your opponent won " + pcScore 
							+ " times. Thus, " 
							+ (playerScore == pcScore ? "Its a tie!": (playerScore > pcScore ? "You Win! Congratulations!!": "Your opponent won! Better luck next time!!")));
		
		// dispose
		input.close();
	}
	
	// random item generate method
	static String getRandomItem()
	{
		Random r = new Random();
		int index = r.nextInt(3);
		if (index == 0)
			return "rock";
		else if (index == 1)
			return "paper";
		else
			return "scissor";
	}
}

// super class - not a great class name though :-)
abstract class ItemOperation{	
	String randItem;
	abstract String attack();	
}

// the rock class
class Rock extends ItemOperation{
	
	Rock(String randItem)
	{
		this.randItem = randItem;
	}
	
	String attack(){
		String result;
		if(randItem == "scissor"){
			result = "You win!";
		}
		else if(randItem == "rock"){
			result = "Its a tie!"; 
		}
		else{
			result = "Your opponent wins!";
		}
		return result;
	}	
}

// the paper class
class Paper extends ItemOperation{
	
	Paper(String randItem)
	{
		this.randItem = randItem;
	}
	
	String attack(){
		String result;
		if(randItem == "rock"){
			result = "You win!";
		}
		else if(randItem == "paper"){
			result = "Its a tie!"; 
		}
		else{
			result = "Your opponent wins!";
		}
		return result;
	}	
}

// the scissor class
class Scissor extends ItemOperation{
	
	Scissor(String randItem)
	{
		this.randItem = randItem;
	}
	
	String attack(){
		String result;
		if(randItem == "paper"){
			result = "You win!";
		}
		else if(randItem == "scissor"){
			result = "Its a tie!"; 
		}
		else{
			result = "Your opponent wins!";
		}
		return result;
	}	
}

import java.util.Random;
import java.util.Scanner;

// main class
public class RockPaperScissors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			// variables
			int playerScore = 0;
			int pcScore = 0;
			String result = null;
			String playerItem;			
			
			System.out.println("How many rounds?");
			Scanner input = new Scanner(System.in);
			int rounds = input.nextInt();
			int counter = rounds;
			
			while(rounds > 0){
				
				rounds --;				
				
				System.out.println("Make your choice for round - " + (counter - rounds));
				playerItem = input.next(); // read user input
				
				//generate random item
				Items randItem = getRandomItem(); 
					
				// call
				switch(playerItem){
				case "rock":
					result = randItem.attack(new Rock("Rock"));
					break;
				case "paper":
					result = randItem.attack(new Paper("Paper"));
					break;
				case "scissor":
					result = randItem.attack(new Scissor("Scissor"));
					break;
				default:
					System.out.println("This round will not count! Pick either rock, paper or scissor.");
					rounds ++;
					break;				
				}
				
				// check for the results and increment
				if (result == ""){
					continue;
				}
				else if (result == "You win!"){
					playerScore ++;
				}
				else if (result == "Your opponent wins!"){
					pcScore ++;
				}
								
				// print round score
				System.out.println("You chose " + playerItem 
									+ ", your opponent chose " + randItem.getName()
									+ ". " + result);
				
				result = "";
			}// end of while
			
			// print final score
			System.out.println("Result: You won " + playerScore
								+ " times, your opponent won " + pcScore 
								+ " times. Thus, " 
								+ (playerScore == pcScore ? "Its a tie!": (playerScore > pcScore ? "You Win! Congratulations!!": "Your opponent won! Better luck next time!!")));
			
			// dispose
			input.close();
			
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// random item generate method
	static Items getRandomItem()
	{
		Random r = new Random();
		int index = r.nextInt(3);
		
		if (index == 0){
			Rock rock = new Rock("Rock");
			return rock;
		}
		else if (index == 1){
			Paper paper = new Paper("Paper");
			return paper;
		}
		else{
			Scissor scissor = new Scissor("Scissor");
			return scissor;
		}
	}
}

// super class
abstract class Items{	
	String name;
	abstract String getName();
	abstract String attack(Scissor s);
	abstract String attack(Rock r);
	abstract String attack(Paper p);
}

// the rock class
class Rock extends Items{
	Rock(String name){
		this.name = name;
	}
	String getName(){
		return name;
	}
	String attack(Scissor s){
		return "Your opponent wins!";
	}
	String attack(Rock r){
		return "Its a tie!";
	}
	String attack(Paper p){
		return "You win!";
	}
}

// the paper class
class Paper extends Items{
	Paper(String name){
		this.name = name;
	}
	String getName(){
		return name;
	}
	String attack(Scissor s){
		return "You win!";
	}
	String attack(Rock r){
		return "Your opponent wins!";
	}
	String attack(Paper p){
		return "Its a tie!";
	}
}

// the scissor class
class Scissor extends Items{	
	Scissor(String name){
		this.name = name;
	}
	String getName(){
		return name;
	}
	String attack(Scissor s){
		return "Its a tie!";
	}
	String attack(Rock r){
		return "You win!";
	}
	String attack(Paper p){
		return "Your opponent wins!";
	}	
}
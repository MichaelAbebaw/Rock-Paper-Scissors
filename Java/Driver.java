package DynamicProgramming;

import java.util.Random;
import java.util.Scanner;

/**
 * Program entry point
 */
public class Driver {

    public static void main(String[] args) throws Exception{

        int playerScore = 0;
        int pcScore = 0;
        String result;
        String playerItem;
        String randomItem;

        System.out.println("How many rounds?");
        Scanner input = new Scanner(System.in);
        int rounds = input.nextInt();
        int counter = rounds;

        Dynamic dObject = new Dynamic();

        while(rounds > 0){

            rounds --;

            System.out.println("Make your choice for round - " + (counter - rounds));
            playerItem = input.next(); // read user input

            //generate random item
            randomItem = getRandomItem();

            // polymorphic call
            switch(playerItem)
            {
                case "rock":
                    result = dObject.attack(new Rock(randomItem));
                    break;
                case "paper":
                    result = dObject.attack(new Paper(randomItem));
                    break;
                case "scissor":
                    result = dObject.attack(new Scissor(randomItem));
                    break;
                default:
                    System.out.println("This round will not count! Pick either rock, paper or scissor.");
                    rounds ++;
                    result = "";
                    break;
            }

            // check for the results and increment
            if (result.equals("")){
                continue;
            }
            else if (result.equals("You win!")){
                playerScore ++;
            }
            else if ( result.equals("Your opponent wins!") ){
                pcScore ++;
            }

            // print round score
            System.out.println("You chose " + playerItem
                    + ", your opponent chose " + randomItem
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

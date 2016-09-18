package DynamicProgramming;

/**
 * Scissor class
 */
public class Scissor extends Operation{

    private String item;

    Scissor(String item)
    {
        this.item = item;
    }

    String attack()
    {
        String result;
        if(item == "paper"){
            result = "You win!";
        }
        else if(item == "scissor"){
            result = "Its a tie!";
        }
        else{
            result = "Your opponent wins!";
        }
        return result;
    }

}

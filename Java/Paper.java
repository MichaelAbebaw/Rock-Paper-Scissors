package DynamicProgramming;

/**
 * Paper class
 */
public class Paper extends Operation{

    private String item;

    Paper(String item)
    {
        this.item = item;
    }

    String attack()
    {
        String result;

        if(item == "rock"){
            result = "You win!";
        }
        else if(item == "paper"){
            result = "Its a tie!";
        }
        else{
            result = "Your opponent wins!";
        }
        return result;
    }
}

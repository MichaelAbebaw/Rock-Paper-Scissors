package DynamicProgramming;

/**
 * Rock class
  */
class Rock extends Operation{

    private String item;

    Rock(String item)
    {
        this.item = item;
    }

    String attack()
    {
        String result;
        if(item == "scissor"){
            result = "You win!";
        }
        else if(item == "rock"){
            result = "Its a tie!";
        }
        else{
            result = "Your opponent wins!";
        }
        return result;
    }
}
package DynamicProgramming;

/**
 * Dynamic Polymorphism
 */
public class Dynamic {

    public String attack(Operation operation){

        if (operation instanceof Rock){
           return  ((Rock) operation).attack();
        }
        else if (operation instanceof Paper){
           return  ((Paper) operation).attack();
        }
        else{
           return  ((Scissor) operation).attack();
        }
    }
}

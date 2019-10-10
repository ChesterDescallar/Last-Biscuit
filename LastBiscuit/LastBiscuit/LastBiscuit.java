/* A program that allows the user to play Last Biscuit a simple variation of the Game of Nim
There should be two players for this game, taking turns to take a number of biscuit in a barrel
there are rules to how many they can take per barrel and the player who takes the last biscuit wins

I have attempted the LEVEL 3 of the coursework.
By: Chester Descallar 978050
 */

import java.util.Scanner;
public class LastBiscuit
{
    public static void main(String[] args)
    {
        /* Game constants to be used throughout the program */
        final String GET_BISCUIT = "From barrel1 (one), barrel2 (two), or both (both)? ";
        final String TAKEN_PLAYER_ONE = "Biscuits taken by player 1: ";
        final String TAKEN_PLAYER_TWO = "Biscuits taken by player 2: ";
        final String BARREL_ONE_LEFT = "Biscuits Left - Barrel 1: ";
        final String BARREL_TWO_LEFT = "Biscuits Left - Barrel 2: ";
        final String WINNER_ONE = "Winner is player 1";
        final String WINNER_TWO = "Winner is player 2";

        /*error constants that will be used throughout the program */
        final String INVALID_INPUT = "Invalid input. Try another integer. ";
        final String BARREL_LIMIT = "Too big to subtract for this barrel. Try again. ";
        final String INCORRECT_OPTION = "Incorrect option. Please try again.";


        Scanner userInput = new Scanner(System.in);


        /* Declaring the barrel variables which is how many biscuits are in each barrel */
        int biscuitBagOne = 6;
        int biscuitBagTwo = 8;

        /* Declaring the win variables which will be used to compare who has more which will be the winner */
        int playerOneTries = 0;
        int playerTwoTries = 0;

        System.out.println(BARREL_ONE_LEFT + biscuitBagOne);
        System.out.println(BARREL_TWO_LEFT + biscuitBagTwo);

        do
            {

            /*Player One's turn
            Gets input from the user to see how many biscuits they want to take and from where */

            /* Declaring the loop variables that is used for error handling */
            int validationRunning = 0;
            int validationRunningTwo = 0;
            int biscuitsTaken = 0;


            /* While loop that keeps running until the user has inputted a correct integer (above 0 or less than
            the amount of biscuits in barrel 1 or barrel 2 whichever has a higher amount of biscuit)
             */
            while (validationRunning == 0)
            {
                System.out.print(TAKEN_PLAYER_ONE);

                /*checks if the user input is an integer, if not keep asking until they input an integer*/
                while (!userInput.hasNextInt())
                {
                    System.out.println(INVALID_INPUT);
                    userInput.nextLine();
                }
                int takeBiscuits = userInput.nextInt();
                userInput.nextLine();
                /*checks the range for the user input (above 0 or less than the highest amount of biscuits
                  either in barrel 1 or barrel 2
                 */
                if (((takeBiscuits < 1) || (takeBiscuits > biscuitBagOne && takeBiscuits > biscuitBagTwo)))
                {
                    System.out.println(INVALID_INPUT);
                }
                else
                {
                    biscuitsTaken = takeBiscuits;
                    validationRunning ++; //ends the loop to continue with the program
                }

            }

            /* While loop that keeps running until the user has inputted a correct option (between 'one', 'two'
               or 'both'). If the input is not any of the three, keep asking the user for an input.
             */
            while (validationRunningTwo== 0)
            {
                System.out.print(GET_BISCUIT);
                String playerOneOption = userInput.nextLine();
                /*Accepts the user input "one" and ignores the case that the user will be using when inputting to
                allow input like "ONE", "one", "oNe", etc.
                (this is similar for the other .equalIgnoreCase statements below)
                 */
                if (playerOneOption.equalsIgnoreCase("one"))
                {
                    /* Checks if the user input is higher than the amount of biscuit in the barrel,
                    if it is, give the user an error and ask them to input another barrel (this is the same case
                    for the other conditional statements below)
                     */
                    if(biscuitsTaken > biscuitBagOne)
                    {
                        System.out.println(BARREL_LIMIT);
                    }
                    /*if not, subtract the user input (biscuits to be taken) from the barrel and end the loop */
                    else
                    {
                        biscuitBagOne -= biscuitsTaken;
                        validationRunningTwo++; //ends the loop to continue with the program
                    }


                }
                /*Just like above but with user input "two", taking away from barrel 2 instead. */
                else if (playerOneOption.equalsIgnoreCase("two"))
                {
                    if(biscuitsTaken > biscuitBagTwo)
                    {
                        System.out.println(BARREL_LIMIT);
                    }
                    else
                    {
                        biscuitBagTwo -= biscuitsTaken;
                        validationRunningTwo++;
                    }

                }
                /*Just like above but with user input "both", taking away from both barrels */
                else if (playerOneOption.equalsIgnoreCase("both"))
                {
                    if((biscuitsTaken > biscuitBagOne) || (biscuitsTaken > biscuitBagTwo))
                    {
                        System.out.println(BARREL_LIMIT);
                    }
                    else
                    {
                        biscuitBagOne -= biscuitsTaken;
                        biscuitBagTwo -= biscuitsTaken;
                        validationRunningTwo++;
                    }

                }
                else
                {
                    System.out.println(INCORRECT_OPTION);
                }
            }

            playerOneTries++;
            System.out.println(BARREL_ONE_LEFT + biscuitBagOne);
            System.out.println(BARREL_TWO_LEFT + biscuitBagTwo);

            /* Checks who won the game by a conditional statement that checks that both barrels are 0
            and compares the amount of tries each player has. Player 1 will only win if he has higher tries than player 2
            otherwise e.g. if it is equal, player 2 will win.
             */
            if ((biscuitBagOne == 0) && (biscuitBagTwo == 0)) {
                if (playerOneTries > playerTwoTries)
                {
                    System.out.println(WINNER_ONE);
                }
                else
                {
                    System.out.println(WINNER_TWO);
                }
            }


            /* Player Two's turn to get some biscuits
             Gets input from the user to see how many biscuits they want to take and from where */

            /* Player Two's turn is a complete replica of player 1 but with slight different variable names */

            else
            {
                /* Declaring the loop variables that is used for error handling just like before */
                int secondValidationRunning = 0;
                int secondValidationRunningTwo = 0;
                int secondBiscuitsTaken = 0;

                while (secondValidationRunning == 0)
                {
                    System.out.print(TAKEN_PLAYER_TWO);
                    while (!userInput.hasNextInt())
                    {
                        System.out.println(INVALID_INPUT);
                        userInput.nextLine();
                    }
                    int takeBiscuitsTwo = userInput.nextInt();
                    userInput.nextLine();
                    if (((takeBiscuitsTwo < 1) || (takeBiscuitsTwo > biscuitBagOne && takeBiscuitsTwo > biscuitBagTwo)))
                    {
                        System.out.println(INVALID_INPUT);
                    }
                    else
                    {
                        secondBiscuitsTaken = takeBiscuitsTwo;
                        secondValidationRunning++;
                    }

                }

                /* Same lines of code as before with a different variable name for the loop */
                while (secondValidationRunningTwo == 0)
                {
                    System.out.print(GET_BISCUIT);
                    String playerTwoOption = userInput.nextLine();
                    /* Conditional statements to only accept "one", "two" or "both" as an option for player 2
                    just like for player 1
                     */
                    if (playerTwoOption.equalsIgnoreCase("one"))
                    {
                        if(secondBiscuitsTaken > biscuitBagOne)
                        {
                            System.out.println(BARREL_LIMIT);
                        }
                        else
                        {
                            biscuitBagOne -= secondBiscuitsTaken;
                            secondValidationRunningTwo++;
                        }

                    }

                    else if (playerTwoOption.equalsIgnoreCase("two"))
                    {
                        if(secondBiscuitsTaken > biscuitBagTwo)
                        {
                            System.out.println(BARREL_LIMIT);
                        }
                        else
                        {
                            biscuitBagTwo -= secondBiscuitsTaken;
                            secondValidationRunningTwo++;
                        }

                    }

                    else if (playerTwoOption.equalsIgnoreCase("both"))
                    {
                        if((secondBiscuitsTaken > biscuitBagOne) || (secondBiscuitsTaken > biscuitBagTwo))
                        {
                            System.out.println(BARREL_LIMIT);
                        }
                        else
                        {
                            biscuitBagOne -= secondBiscuitsTaken;
                            biscuitBagTwo -= secondBiscuitsTaken;
                            secondValidationRunningTwo++;
                        }

                    }

                    else
                    {
                        System.out.println(INCORRECT_OPTION);
                    }

                }

                /*Same win condition as before.  Player 1 will only win if he has higher tries than player 2
            otherwise e.g. if it is equal, player 2 will win. */
                playerTwoTries++;
                System.out.println(BARREL_ONE_LEFT + biscuitBagOne);
                System.out.println(BARREL_TWO_LEFT + biscuitBagTwo);
                if ((biscuitBagOne == 0) && (biscuitBagTwo == 0))
                {
                    if (playerOneTries > playerTwoTries)
                    {
                        System.out.println(WINNER_ONE);
                    }
                    else
                    {
                        System.out.println(WINNER_TWO);
                    }
                }



            }
        } while ((biscuitBagOne != 0) || (biscuitBagTwo != 0)) ; //Loop ends when both bags have 0 biscuits left



    }
}









import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Class for StuckInTheMud
 */
public class StuckInTheMud {

    /**
     * The players variable is used to store a circular linked list of Player objects
     */
    private static CircularLinkedList<Player> players = new CircularLinkedList<>();

    /**
     * The number of dice in the game
     */
    private static int numDice = 0;

    /**
     * Entry point of the program; presents a menu to the player; implements the game.
     * @param args parameter list of main
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Congrats on playing Stuck in the Mud!");
            System.out.println("Select 1 to play the game or 2 to exit: ");
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    getPlayerInfo(scanner);
                    getNumDice(scanner);
                    playGame();
                    break;
                case "2":
                    System.out.println("You quit the game. Goodbye.");
                    return;
                default:
                    System.out.println("I didn't understand your input. Quitting the game.");
                    return;
        }
            scanner.close();
        } catch (InterruptedException e) {
            System.out.println("An InterruptedException occurred.");
        }

    }

    /**
     * Reads players names from the user and adds them to a list of players
     * @param scanner reads the information from the user
     */
    private static void getPlayerInfo(Scanner scanner) {
        boolean done = false;
        int playerNum = 1;
        while (!done) {
            System.out.format("Enter player %s's name or \"done\" to quit adding players:\n", playerNum);
            String input = scanner.nextLine();
            if (!input.equals("done")) {
                Player player = new Player(input);
                players.add(player);
                playerNum++;
            } else {
                if (players.getSize() > 0) {
                    done = true;
                    System.out.println("Completed adding players.");
                } else {
                    System.out.println("You must have at least one player.");
                }
            }
        }
    }

    /**
     * Reads the number of dice from the user
     * @param scanner reads the information from the user
     */
    private static void getNumDice(Scanner scanner) {
        System.out.println("Enter number of dice: ");
        String input = scanner.nextLine();
        try {
            int strToInt = Integer.parseInt(input);
            numDice = strToInt;
            System.out.format("You have chosen %d dice.\n", numDice);
        }
        catch (Exception ex){
            System.out.println("Invalid input. Quitting the game.\n");

        }
    }

    /**
     * Selects a random player; determines if game is over; displays winner and score
     * @throws InterruptedException throws InterruptedException error
     */
    private static void playGame() throws InterruptedException {
        Random random = new Random();
        int startingPosition = random.nextInt(players.getSize());
        Iterator<Player> iterator = players.iterator();
        Player currentPlayer = null;
        for (int i = 0; i <= startingPosition; i++) {
            currentPlayer = iterator.next();
        }
        boolean isGameOver = false;
        while(!isGameOver) {
            isGameOver = playTurn(currentPlayer);
            if(isGameOver){
                System.out.format("The winner is %s with a score of %d!\n", currentPlayer.getName(), currentPlayer.getScore());
            }
            else{
                currentPlayer = iterator.next();
            }
        }
    }

    /**
     * Simulates a player's turn with the dice.
     * @param player defines each player
     * @return returns a boolean value of a win or loss
     * @throws InterruptedException throws InterruptedException error
     */
    public static boolean playTurn(Player player) throws InterruptedException {
        LinkedList<Integer> diceValues = new LinkedList<>();
        Random random = new Random();
        int diceAvailable = numDice;
        while (diceAvailable > 0) {
            if (diceValues.getSize() == 0) {
                //this is first roll, add random values to linked list
                for (int i = 0; i < numDice; i++) {
                    int diceValue = random.nextInt(6) + 1;
                    if (diceValue == 2 || diceValue == 5) {
                        diceAvailable--;
                    }
                    diceValues.add(diceValue);
                }
                //calculate score for roll
                int sum = 0;
                Iterator<Integer> diceIterator = diceValues.iterator();
                while(diceIterator.hasNext()){
                    Integer diceVal = diceIterator.next();
                    if(diceVal != 2 && diceVal != 5){
                        sum += diceVal;
                    }
                }
                //add roll score to round score
                System.out.format("%s rolled %s\n", player.getName(), diceValues.toString());
                player.setRoundTotal(player.getRoundTotal() + sum);
                Thread.sleep(1000);
            } else {
                //this is not the first roll, replace non 2 and 5 values with new random values
                Iterator<Integer> iter = diceValues.iterator();
                for (int i = 0; i < diceValues.getSize(); i++) {
                    ListNode<Integer> current = diceValues.nodeAt(i);
                    if (current.data != 2 && current.data != 5) {
                        int diceValue = random.nextInt(6) + 1;
                        current.data = diceValue;
                        if(diceValue == 2 || diceValue == 5)
                        {
                            diceAvailable--;
                        }
                    }
                }
                //calculate score for roll
                int sum = 0;
                Iterator<Integer> diceIterator = diceValues.iterator();
                while(diceIterator.hasNext()){
                    Integer diceVal = diceIterator.next();
                    if(diceVal != 2 && diceVal != 5){
                        sum += diceVal;
                    }
                }
                //add roll score to round score
                System.out.format("%s rolled %s\n", player.getName(), diceValues.toString());
                player.setRoundTotal(player.getRoundTotal() + sum);
                Thread.sleep(800);
            }
        }
        //add round total to total score
        player.setScore(player.getScore() + player.getRoundTotal());
        System.out.format("%s earned %d this round, totaling %d\n", player.getName(), player.getRoundTotal(), player.getScore());
        player.setRoundTotal(0);
        return player.getScore() >= 100;
    }

}

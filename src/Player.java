/**
 * Public class Player
 */
public class Player {

    /**
     * Private instance variable
     */
    private String name;
    /**
     * Private instance variable
     */
    private int score;
    /**
     * Private instance variable
     */
    private int roundTotal;

    /**
     * Constructor
     */
    public Player() {
        name = null;
        score = 0;
        roundTotal = 0;
    }

    /**
     * Constructor
     * @param name parameter name
     */
    public Player(String name) {
        this.name = name;
        score = 0;
        roundTotal = 0;
    }

    /**
     * method/accessor
     * @return returns a String value name
     */
    public String getName() {
        return name;
    }

    /**
     * method/mutator
     * @param name value is assigned to the name attribute of the Player object
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * method/mutator
     * @return returns an integer value score
     */
    public int getScore() {
        return score;
    }

    /**
     * method/mutator
     * @param score value is assigned to the score attribute of the Player object
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * method/accessor
     * @return returns an integer value roundTotal
     */
    public int getRoundTotal() {
        return roundTotal;
    }

    /**
     * method/accessor that takes in an integer parameter roundTotal and does not return any value
     * @param roundTotal assigns the value of roundTotal to the attribute of the Player object
     */
    public void setRoundTotal(int roundTotal) {
        this.roundTotal = roundTotal;
    }

    /**
     * Add the current roundTotal value to the score attribute of the Player object then resets roundTotal to zero
     */
    public void addRoundTotalToScore() {
        score += roundTotal;
        roundTotal = 0;
    }
}

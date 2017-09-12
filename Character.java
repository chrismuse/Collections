/**
 * @author Yashveer Singh
 * @version 1.0
 */
public class Character implements Comparable<Character> {
    private String name; // name of person
    private int combatSkill; // combat ability of person
    private int intelligenceLevel; // intelligence level of person
    private boolean hasSpecialPower; // boolean representing whether
        //character has unusual powers
    private int numDragons; // int representing the number of
        //dragons that character has
    private String message; // a message that will appear when you find
        //the character

    /**
     * Constructor
     * @param name - String
     * @param combatSkill - int
     * @param intelligenceLevel - int
     * @param hasSpecialPower - boolean
     * @param numDragons - int
     * @param message - String
     */
    public Character(String name, int combatSkill, int intelligenceLevel,
        boolean hasSpecialPower, int numDragons, String message) {
        this.name = name;
        this.combatSkill = combatSkill;
        this.intelligenceLevel = intelligenceLevel;
        this.hasSpecialPower = hasSpecialPower;
        this.numDragons = numDragons;
        this.message = message;
    }

    /**
     * @return A character's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return A character's combatSkill
     */
    public int getCombatSkill() {
        return combatSkill;
    }

    /**
     * @return A character's intelligenceLevel
     */
    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    /**
     * @return A character's hasSpecialPower
     */
    public boolean getHasSpecialPower() {
        return hasSpecialPower;
    }

    /**
     * @return A character's numDragons
     */
    public int getNumDragons() {
        return numDragons;
    }

    /**
     * @return A character's message
     */
    public String getMessage() {
        return message;
    }

    //setters

    /**
     * set A character's name
     * @param name - new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set A character's combatSkill4
     * @param combatSkill - new combatSkill
     */
    public void setCombatSkill(int combatSkill) {
        this.combatSkill = combatSkill;
    }

    /**
     * sets A character's intelligenceLevel
     * @param intelligenceLevel - new intelligenceLevel
     */
    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    /**
     * sets A character's hasSpecialPower
     * @param hasSpecialPower - new hasSpecialPower
     */
    public void setHasSpecialPower(boolean hasSpecialPower) {
        this.hasSpecialPower = hasSpecialPower;
    }

    /**
     * sets A character's numDragons
     * @param numDragons - new numDragons
     */
    public void setNumDragons(int numDragons) {
        this.numDragons = numDragons;
    }

    /**
     * sets A character's message
     * @param message - new message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    //compareTo
    /**
     * compareTo method
     * @param c - a Character to compare to
     * @return int
     */
    public int compareTo(Character c) {
        int superSkill = combatSkill + intelligenceLevel;
        int otherSkill = c.getCombatSkill() + c.getIntelligenceLevel();
        if (superSkill > otherSkill) {
            return 1;
        } else if (superSkill < otherSkill) {
            return -1;
        }
        return 0;
    }

    /**
     * Should return a string in the format used in the below example.
     *
     * Name: Jon; Combat Skill: 4; Intel: 7; Special Power: no; Dragons: 0
     *
     * If hasSpecialPower is false, "Special Power: " should say no
     * afterward. If hasSpecialPower is true, "SpecialPower: "
     * should say yes afterward.
     * @return a String representation of the Character
     */
    public String toString() {
        String power = "";
        if (hasSpecialPower) {
            power = "yes";
        } else {
            power = "no";
        }
        return String.format("Name: %s; Combat Skill: %d; Intel: %d; Special"
            + " Power: %s; Dragons: %d", name, combatSkill, intelligenceLevel,
            power, numDragons);
    }

    /**
     * @param o - another Object
     * @return whether two character are equal(based on names)
     */
    public boolean equals(Object o) {
        if (o instanceof Character) {
            return name.equals(((Character) o).getName());
        }
        return false;
    }
}
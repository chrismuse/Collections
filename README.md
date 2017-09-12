# Collections
Implemented a generic, Iterable ComparableCollection class that manipulates and interacts with the TeamWrapper and Character classes.

Assignment:

Introduction
This assignment will involve Collections, generics, iterators, and the Comparable interface.

Description
Winter is here. The Long Night has arrived. The cold winds blow from the north. Westeros is faced with the impending invasion of the sinister White Walkers. You are trying to build a team to take north of the Wall in order to fight them. However, in order to save Westeros, you have to know about Collections. After all, how can you keep track of your team without Collections?

This assignment will have you implement a generic ComparableCollection that can only take in Comparable objects. We have provided a generic interface CollectionInterface that contains the methods you must implement in your ComparableCollection. It is your job to build a concrete implementation that allows for your ComparableCollection to only handle objects that are Comparable. Additionally, your ComparableCollection must be Iterable. You will then have to implement a TeamWrapper class. This will use your ComparableCollection to allow you to build your team and manipulate it. You will also have to implement a Character class that represents the people you might add to your team. Character must be Comparable.

Provided Files and Solution Description
You will have to modify the files Character.java, ComparableCollection.java, and TeamWrapper.java.

CollectionInterface.java
DO NOT MODIFY THIS FILE. This interface contains the following methods. Refer to the javadocs for a more detailed description of each method.

void add(T elem)
void addAll(T[] elems)
boolean remove(T elem)
boolean removeAll(T[] elem)
boolean contains(T elem)
T get(int index)
int size()
int capacity()
void clear()
boolean isEmpty()
String toString()
ComparableCollection.java
YOU MAY NOT USE ARRAYLIST IN THIS CLASS.
Implements CollectionInterface and Iterable.
Your collection must be backed by an array. This array should be a private instance field.
You will also have to use generics to modify the class header in order to allow the Collection to only take in objects that are Comparable. Your ComparableCollection MUST BE GENERIC. Do not have it only accept Characters.
You do not need to implement the remove method when creating your iterator.
Character.java
A class representing the people you will attempt to recruit. This class MUST BE COMPARABLE. Characters can only be compared to other Characters. Characters should be compared by the sum of combatSkill and intelligenceLevel. Character has the following instance fields:

private String name: name of person
private int combatSkill: combat ability of person
private int intelligenceLevel: intelligence level of person
private boolean hasSpecialPower: boolean representing whether character has unusual powers
private int numDragons: int representing the number of dragons that character has
private String message: a message that will appear when you find the character
You only need to implement one constructor that takes in and sets all the instance fields. You will need to implement getters and setters for all of the instance fields. In addition to getters and setters, you must implement the following:

public String toString(): A method header for your toString method is provided. You must fill out the body. Details are in the javadocs inside the Character class.
Properly overridden equals method. Two Characters are equal if their names are equal.
TeamWrapper.java
This is a Wrapper that will be used to build your team. You will have a main team and a reserve team. This class has two private instance fields that have been provided. They have been instantiated for you in a constructor. One is a ComparableCollection that represents your main team. You will also have a reserve team represented by another ComparableCollection. Your main team is what you will bring to the fight, and your reserve team has your backup fighters if any of your main team die prematurely, which knowing George R.R. Martin is a real possibility. Your main team can have no more than 10 fighters, and your reserve can have no more than 5. You should be able to move fighters from your reserve to your main team and vice versa. You will have to implement the following methods.

public boolean checkTeamCapacity(): returns true if there is space left on your main team
public boolean checkReserveCapacity(): returns true if there is space left on your reserve team
public void addToTeam(Character c): adds a Character that is passed in to the team
public void addToReserve(Character c): adds a Character that is passed in to the reserve team
public boolean removeFromTeam(Character c): attempts to remove a Character that is passed in from the team. Returns true if successful, false otherwise.
public boolean removeFromReserve(Character c): attempts to remove a Character that is passed in from the reserve team. Returns true if successful, false otherwise.
public boolean moveToReserve(Character c): removes a Character that is passed in from the team, and adds it to the reserve if it was sucessfully removed
public boolean promoteToTeam(Character c): removes a Character that is passed in from the reserve team, and adds it to the team if it was successfully removed
public int teamSize(): return the number of members currently on your team
public int reserveSize(): return the number of members currently on your reserve
public Character getFromTeam(int index): returns the Character at a specified index on your team
public Character getFromReserve(int index): returns the Character at a specified index on your reserve team
See the provided javadocs for more details on these methods.

Note: You should not be able to add the same Character to both your team and reserve team.
The following methods are provided, DO NOT MODIFY THEM.

public String teamToString()
public String reserveToString()
BuildTeam.java
DO NOT MODIFY THIS. This will take you through a simulation of traveling Westeros looking for Characters to add to your team. Simply follow the on screen instructions. If your TestWrapper.java is working as it should, BuildTeam.java should run smoothly.

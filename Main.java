// author name - Oghenefejiro Isaacs Anigboro
import java.util.*;
class Main {
  private static boolean hasEnded=false;
  private static int playTimes=0;
  private static ArrayList<Integer> numbers = new ArrayList<Integer>();
  private static int userInput = 0;
  
  public static void main(String[] args) {
    Scanner sam = new Scanner(System.in);
    String[] row1 = {"1", "2", "3"};
    String[] row2 = {"4", "5", "6"};
    String[] row3 = {"7", "8", "9"};
    int player = 1;
    String whichPlayer = ""; 
    System.out.println("Welcome to my X and O game");
    System.out.println("Each number represents a spot like a normal X and O game");
    System.out.println("Enter a number to play on that spot");
    System.out.println("Like usual, X goes first"); 
    
    while(!hasEnded){
      if(player == 1){
        whichPlayer = "X";
      } else {
        whichPlayer = "O";
      }
      printMethod(row1, row2, row3);
      System.out.println("Now enter a number, its your turn player " + whichPlayer );
      isNumUsed(sam);
      changeNum(row1, row2, row3, whichPlayer);
      winDecider(row1, row2, row3, whichPlayer);
      if(player == 1){
        player = 2;
      } else {
        player = 1;
      }
    }
  }

  public static void changeNum(String[] st1, String[] st2, String[] st3, String whichPlayer){
    for(int i = 0; i < st1.length; i++){
      if(!(st1[i].equals("X") || st1[i].equals("O"))){
        if(Main.userInput == Integer.parseInt(st1[i])){
          st1[i] = whichPlayer;
        }
      }
    }
    for(int i = 0; i < st2.length; i++){
      if(!(st2[i].equals("X") || st2[i].equals("O"))){
        if(Main.userInput == Integer.parseInt(st2[i])){
          st2[i] = whichPlayer;
        }
      }
    }
    for(int i = 0; i < st3.length; i++){
      if(!(st3[i].equals("X") || st3[i].equals("O"))){
        if(Main.userInput == Integer.parseInt(st3[i])){
          st3[i] = whichPlayer;
        }
      }
    }
  }
  
  public static void isNumUsed(Scanner sam){
    boolean numExist = true; 
    int counter = 0;
    while(numExist){
      numExist = false;
      isValidNum(sam);
      while(Main.userInput > 9 || Main.userInput < 0){
        System.out.println("Please enter one of the numbers on the screen");
        isValidNum(sam);
      }
      if(Main.numbers.size() > 0){
        for(int i = 0; i < Main.numbers.size(); i++){
          if(Main.numbers.get(i) == Main.userInput){
            numExist = true;
            System.out.println("This number is not on the screen \nEnter another number");
          }
        }
        if(!numExist){
          Main.numbers.add(Main.userInput);
        }
      } else {
        Main.numbers.add(Main.userInput);
      }
      if(counter > 0){
        System.out.println("Please enter a number on the screen");
      }
    }

  }
  
  public static void isValidNum(Scanner sam){
    while(!sam.hasNextInt()){
      System.out.println("Please enter a number");
      sam.next();
    }
    Main.userInput = sam.nextInt();
  }
  
  public static void winDecider(String[] s1, String[] s2, String[] s3, String whichPlayer){
    Main.playTimes++;
    if(s1[0].equals(s2[0]) && s1[0].equals(s3[0])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s1[1].equals(s2[1]) && s1[1].equals(s3[1])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s1[2].equals(s2[2]) && s1[2].equals(s3[2])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s1[1].equals(s1[2]) && s1[1].equals(s1[0])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s2[1].equals(s2[2]) && s2[1].equals(s2[0])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s3[1].equals(s3[2]) && s3[1].equals(s3[0])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s1[0].equals(s2[1]) && s1[0].equals(s3[2])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(s1[2].equals(s2[1]) && s1[2].equals(s3[0])){
      winDeciderDuplCode(s1,s2,s3,whichPlayer);
    } else if(Main.playTimes > 8) {
      System.out.println("Game ends a draw");
      Main.hasEnded = true;
    }
  }

  public static void winDeciderDuplCode(String[] s1, String[] s2, String[] s3, String whichPlayer){
    Main.hasEnded = true;
    System.out.println("Game over, player " + whichPlayer + " wins");
    printMethod(s1,s2,s3);
  }
  
  public static void printMethod(String[] st1, String[] st2, String[] st3){
    System.out.println("\n");
    for(int i = 0; i < st1.length; i++){
      System.out.print(st1[i] + "  ");
    }
    System.out.print("\n");
    for(int i = 0; i < st1.length; i++){
      System.out.print(st2[i] + "  ");
    }
    System.out.print("\n");
    for(int i = 0; i < st1.length; i++){
      System.out.print(st3[i] + "  ");
    }
    System.out.println("\n");
  }
}
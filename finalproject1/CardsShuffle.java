//Name: Leonardo Moodley
//Teacher: Mrs. McCaffery 
//Subject: ICS3UI
//Date: November 10, 2020
//Description: The program randomizes suits and ranks of the cards.
package finalproject1;
import java.util.Random;

import finalproject1.Card;

import java.util.Arrays;
public class CardsShuffle {
	
	public static Card[] GetCards() {		
    {
    	//declaring and initializing variables and objects required
       int[] arr = new int[52];
       String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
       String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
       Card[] cards = new Card[52];
       
       //for loop prints the original deck.
       for (int i = 0; i < 52; i++)
       {
              arr[i] = i;
       }//end for loop  
       
       //Randomizes and prints the rank and suit of the deck
        RandomShuffle(arr, 52);
        PrintShuffle(arr,suits,ranks,cards);
    
        return cards;
      
    }//end GetCards()
      
    }//end GetCards()
			
	/*
	 * Method Name: PrintShuffle
	 * Description: Prints the randomized rank and suit of an array of fifty two cards.
	 * Parameters: int[] arr, String[] suits, String[] ranks, Card[] cards
	 * Returns: n/a
	 */
	public static void PrintShuffle(int[] arr, String[] suits, String[] ranks, Card[] cards) {
		
		//for loop that prints random number the suits and ranks recieve
		for (int i = 0; i < 52; i++) {
	        String suit = suits[arr[i] / 13];
	        String rank = ranks[arr[i] % 13];
	        cards[i] = new Card(suit,rank);
	       
	      }//end for loop
	}//end method PrintShuffle()

	/*
	 * Method Name: RandomShuffle
	 * Description: Randomizes the deck, suit, and the rank of card.
	 * Parameters: int card[], int n
	 * Returns: n/a
	 */
   public static void RandomShuffle(int card[], int n)
    {
        
        Random rand = new Random();
        
        //for loop that prints a random number between zero and fifty two.
        for (int i = 0; i < n; i++)
        {
            // selecting a random position for r.
            int r = i + rand.nextInt(52 - i);
            
             //swapping the elements at position i and r.
             int temp = card[r];
             card[r] = card[i];
             card[i] = temp;
             
        }//end for loop
    }//end method RandomShuffle()

   
}//end CardsShuffle
            


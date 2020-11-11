//Name: Leonardo Moodley
//Teacher: Mrs. McCaffery 
//Subject: ICS3UI
//Date: November 10, 2020
//Description: The program prints the suit and rank of each card.


package finalproject1;

public class Card
{
	public static Cards[] personCards = new Cards[4];
	public String suit;
	public String rank;
	public int value;

	/*
	 * Method Name: Card
	 * Description: Determines the value of the card based on a switch case statement
	 * Parameters: String newSuit, String newRank
	 * Returns: n/a
	 */

	public Card(String newSuit, String newRank)
	{
		//declaring and initializing variables required
		suit = newSuit;
		rank = newRank;
		String str = rank; 
			
		//Switch case statement for what value the card will have by the name of the card.
		switch(str) 
		{ 
		case "Ace": 	
			value = 11;
			break;
		case "2": 
			value = 2;
			break; 
		case "3": 
			value = 3;
			break; 
		case "4": 
			value = 4;
			break; 
		case "5": 
			value = 5;
			break; 
		case "6": 
			value = 6;
			break; 
		case "7": 
			value = 7;
			break; 
		case "8": 
			value = 8;
			break; 
		case "9": 
			value = 9;
			break; 
		case "10": 
			value = 10;
			break; 
		case "12": 
			value = 12;
			break;
		case "Jack": 
			value = 10;
			break;
		case "Queen": 
			value = 10;
			break; 
		case "King": 
			value = 10;
			break; 
		default: 
			System.out.println("no match"); 
		}//end switch case statement	
	}//end method Card()
	
	/*
	 * Method Name: getCard
	 * Description: returns the rank and suit of the card
	 * Parameters: 
	 * Returns: n/a
	 */
	public String getCard()
	{   
		return rank + " " + getSuit(suit);

	}//end method getCard()
	

	/*
	 * Method Name: getSuit
	 * Description: Makes the original suits into unicodes of actual spades, diamends, clubs, and hearts.
	 * Parameters: String suit
	 * Returns: n/a
	 */
	public String getSuit(String suit)
	{   
		//Converts suits into images by converting them to Unicode.
	    StringBuilder suits = new StringBuilder();
	    suits.append("");
		 switch (suit.toUpperCase()) {
         	case "SPADES":
         		suits.append((char)'\u2660');
         		break;
			case "DIAMONDS":
				suits.append((char)'\u2666'); 
				break;
			case "CLUBS":
				suits.append((char)'\u2663'); 
				break;
			case "HEARTS":
				suits.append((char)'\u2764'); 
				break;
     }//end switch case statement

		return suits.toString();
		

	}//end method getDiscription()
}//end Program
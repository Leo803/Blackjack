//Name: Leonardo Moodley
//Teacher: Mrs. McCaffery 
//Subject: ICS3UI
//Date: November 10, 2020
//Description: The program calculates and prints the value of the cards depending on the users hitting or standing.
package finalproject1;

import finalproject1.Card;

public class Cards {
	
	//declaring and initializing variables required
	public String Name;
	public Card Card1;
	public Card Card2;
	public Card Card3;
	public Card Card4;
	public Card Card5;
	public Card Card6;
	public Card Card7;
	public Card Card8;
	public Card Card9;
	public Card Card10;
	public Card Card11;
	public double Bet;
	public boolean doubledown;
	public boolean checkifAce;
	
	public Cards(String newname,  Card newcard1, Card newcard2, Card newcard3 , Card newcard4, Card newcard5, 
			Card newcard6, Card newcard7 , Card newcard8, Card newcard9, Card newcard10 , Card newcard11, double newBet
			)
	{
		//declaring and initializing variables required
		checkifAce = false;
		doubledown = false;
		Name = newname;
		Card1 = newcard1;
		Card2 = newcard2;
		Card3 = newcard3;
		Card4 = newcard4;
		Card5 = newcard5;
		Card6 = newcard6;
		Card7 = newcard7;
		Card8 = newcard8;
		Card9 = newcard9;
		Card10 = newcard10;
		Card11 = newcard11;
		Bet = newBet;
		checkifAce();		
		
	}//end Cards
	
	/*
	 * Method Name: checkifAce
	 * Description: Calculates and prints value of ace depending on if the value of cards are above or below 11.
	 * Parameters: 
	 * Returns: even
	 */
	
	public boolean checkifAce() {
		if (Card1 != null  && Card1.rank == "Ace") {
			if(getValue() > 11) {
				Card1.value = 1;				
			}//end if statement where Card value is above 11
			else { 
				Card1.value = 11;
			}//end else statement where Card value is above 11
			
		}//end if statement if Card1 is not equal to null and rank is ace.
		
		if (Card2 != null  && Card2.rank == "Ace") {
			if(getValue() > 11) {
				Card2.value = 1;				
			}
			else { 
				Card2.value = 11;
			}
		}//end if statement if Card2 is not equal to null and rank is ace.
		
		if (Card3 != null  && Card3.rank == "Ace") {
			if(getValue() > 11) {
				Card3.value = 1;				
			}//end if statement where Card value is above 11
			else { 
				Card3.value = 11;
			}//end else statement where Card value is above 11
		}//end if statement if Card3 is not equal to null and rank is ace.
		
		if (Card4 != null  && Card4.rank == "Ace") {
			if(getValue() > 11) {
				Card4.value = 1;				
			}//end if statement where Card value is above 11
			else { 
				Card4.value = 11;
				
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card4 is not equal to null and rank is ace.
		
		if (Card5 != null  && Card5.rank == "Ace") {
			if(getValue() > 11) {
				Card5.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card5.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card5 is not equal to null and rank is ace.
		
		if (Card6 != null  && Card6.rank == "Ace") {
			if(getValue() > 11) {
				Card6.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card6.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card6 is not equal to null and rank is ace.
		
		if (Card7 != null  && Card7.rank == "Ace") {
			if(getValue() > 11) {
				Card7.value = 1;				
			}//end if statement where Card value is above 11
			else { 
				Card7.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card7 is not equal to null and rank is ace.
		
		if (Card8 != null  && Card8.rank == "Ace") {
			if(getValue() > 11) {
				Card8.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card8.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card8 is not equal to null and rank is ace.
		
		if (Card9 != null  && Card9.rank == "Ace") {
			if(getValue() > 11) {
				Card9.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card9.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card9 is not equal to null and rank is ace.
		
		if (Card10 != null  && Card10.rank == "Ace") {
			if(getValue() > 11) {
				Card10.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card10.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card10 is not equal to null and rank is ace.
		
		if (Card11 != null  && Card11.rank == "Ace") {
			if(getValue() > 11) {
				Card11.value = 1;				
			}//end if statement where Card value is above 11
			
			else { 
				Card11.value = 11;
			}//end if statement if Card3 is not equal to null and rank is ace.
			
		}//end if statement if Card11 is not equal to null and rank is ace.
		return checkifAce;
		
	}

	/*
	 * Method Name: PrintShuffle
	 * Description: Calculates and prints value of ace depending on if the value of cards are above or below 11.
	 * Parameters: 
	 * Returns: even
	 */
	
	public int getValue()
	{   		
		if(Card3 != null && Card4 == null && Card5 == null && Card6 == null && Card7 == null && Card8 == null) { 
		
			return Card1.value + Card2.value + Card3.value;
		
		}//end if statement for when Card3 is added to value of the deck
		else if(Card4 != null && Card5 == null && Card6 == null && Card7 == null && Card8 == null) { 
			
			return Card1.value + Card2.value + Card3.value + Card4.value;
		
		}//end if else statement for when Card3 and Card4 is added to value of the deck
		else if(Card5 != null && Card6 == null && Card7 == null && Card8 == null) { 
			
			return Card1.value + Card2.value + Card3.value + Card4.value + Card5.value;
	
		}//end if else statement for when Card3, Card4, and Card5 is added to value of the deck
		

		else if( Card6 != null && Card7 == null && Card8 == null) { 
			
			return Card1.value + Card2.value + Card3.value + Card4.value + Card5.value + Card6.value;
		
		}//end if else statement for when Card3, Card4, Card5, and Card6 is added to value of the deck

		else if(Card7 != null && Card8 == null) { 
			
			return Card1.value + Card2.value + Card3.value + Card4.value + Card5.value + Card6.value + Card7.value;
		
		}//end if else statement for when Card3, Card4, Card5, Card6, Card7 is added to value of the deck
		else if(Card8 != null) { 
			
			return Card1.value + Card2.value + Card3.value + Card4.value + Card5.value + Card6.value + Card7.value + Card8.value;
		
		}//end if else statement for when Card3, Card4, Card5, Card6, Card7, and Card8 is added to value of the deck
		else  {
			return Card1.value + Card2.value;
		
		}//else statement for adding the original Card1 and Card2
	}//end method getValue()
 
}//end Cards


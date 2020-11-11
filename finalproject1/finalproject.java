//Name: Leonardo Moodley
//Teacher: Mrs. McCaffery 
//Subject: ICS3UI
//Date: November 10, 2020
//Description: The main program that runs the game of Blackjack with three users and an dealer(Computer).

package finalproject1;
import java.util.Random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import MethodsArrays.Product;
import finalproject1.Card;

public class finalproject {

	static String taskValue = "Retail" ;

	// number of product objects.
	public static Names[] users = new Names[0];
	public static Cards[] personCards = new Cards[4];

	public static void main(String[] args) {

		//declaring and initializing variables and objects required
		Scanner in = new Scanner(System.in);	  
		String code, description = null;
		String dealer = "Dealer";
		String name1 = "";
		String name2 = "";
		String name3 = "";
		int numOfProducts = 1;
		int num = 0;
		Card[] cards = CardsShuffle.GetCards();
		users = new Names[numOfProducts];

		boolean done = false;
		Scanner sc = new Scanner(System.in);

		//While loop to play again when done is false
		while(!done) {

			//displays menu for wanting to play Blackjack or exit the game.
			displayMenu(personCards, dealer, name1, name2, name3, numOfProducts, num, cards, users);

			String choice;
			System.out.print("Do you still want to play again ? (Y/N): ");
			choice = sc.next();
			if(choice.equalsIgnoreCase("y")) {
				done = false;
			} else {
				done = true;
				System.out.println("Thanks for playing the game.");

			}//end else statement
		}//end while statement
	}//end main

	public static void displayMenu(Cards[] personCards, String dealer, String name1, String name2, String name3, int numOfProducts, int num, Card[] cards, Names[] users) {
		Scanner myInput = new Scanner(System.in);
		System.out.println("\nWelcome to the game of Blackjack Press:");
		System.out.println("\t 1. To play game");
		System.out.println("\t 2. Exit the game");
		System.out.println("Please select an option:");

		int exit1 = 0;

		// While loop with switch case statements dependent on int inp1 and calculates and prints arrays or statements. 
		while (exit1 == 0) {
			int inp1 = myInput.nextInt();			
			switch (inp1) {		

			//Switch Case Statement with for loop intilizing, calculating, and printing added item dependent on user response.
			case 1 :				
				//Calculates and prints the game of Blackjack for the users and dealer and determines a winner of the game.
				System.out.println("Play game");
				checkDealing(personCards, dealer, name1, name2, name3, numOfProducts, num, cards, users);
				int winner = checkWinner(personCards); 

				if (personCards[winner].doubledown) {
					System.out.println(getTotalBets(personCards) + personCards[winner].Bet + "\n");
				}//end if statement for if the winner double downed.
				else {
					System.out.println(getTotalBets(personCards) + "\n");
				}//end else statement for if no one double downed.

				System.out.println("\nDo you wanna play again?:");
				System.out.println("\t 1. To play game");
				System.out.println("\t 2. Exit the game");

				break;	

				//Case statement for if the user decides to exit the game.
			case 2 :
				System.out.println("You have exited the game.");

				exit1 = 1;
				break;	


			default:
				System.out.println("The program cannot recognize the input you selected. Please try again. ");

			}//end switch case statement.
		}//end while loop
	}//end method displayMenu

	/*
	 * Method Name: checkDealing
	 * Description: Runs the game of Blackjack.
	 * Parameters:  Cards[] personCards, String dealer, String name1, String name2, String name3, int numOfProducts, int num, Card[] cards, Names[] users
	 * Returns: n/a
	 */

	public static int checkDealing(Cards[] personCards, String dealer, String name1, String name2, String name3, int numOfProducts, int num, Card[] cards, Names[] users) {
		Scanner in = new Scanner(System.in);	  

		//Program requests name of first user, and their bet.
		System.out.println("\nWelcome, You are playing a game of Blackjack with three people and a dealer!\nThe rules of the game are to get the closest to 21 or score 21."
				+ "\nIf you score above 21 then you busted ");
		System.out.print("Whats your name? " + ": ");
		name1 = in.next();	
		System.out.print("Whats your bet? " + ": ");

		double Bet = in.nextDouble();



		// Initializing and calculating random positions between zero and forty-five for Cards.
		int random_int = (int)(Math.random() * (45 - 0 ) + 0);
		int random_int1 = (int)(Math.random() * (45 - 0) + 0);
		int random_int2 = (int)(Math.random() * (45 - 0) + 0);
		int random_int3 = (int)(Math.random() * (45 - 0 ) + 0);
		int random_int4 = (int)(Math.random() * (45 - 0) + 0);
		int random_int5 = (int)(Math.random() * (45 - 0) + 0);
		int random_int6 = (int)(Math.random() * (45 - 0) + 0);
		int random_int7 = (int)(Math.random() * (45 - 0) + 0);


		//Calculates and prints two random cards in deck for name1, assigns name1's seat, and shows the value of the two cards for name1.
		Cards personCard = new Cards(name1,cards[random_int],cards[random_int1],null,null,null,null, null, null, null, null, null, Bet);		
		personCards[0] = personCard;
		personCard.checkifAce();
		System.out.print("\n" + personCards[0].Name + " is siting at seat 1\n\n" );
		System.out.println("Welcome," + personCards[0].Name +  " Lets play Blackjack!");			
		System.out.print(personCards[0].Name + " Here is your cards " + personCards[0].Card1.getCard() + " and " +  personCards[0].Card2.getCard()+ "\n\n");
		System.out.println("Here is the value of your cards: " + personCards[0].getValue());


		//Program requests user two's name, assigns the seat of user two, calculates and prints two random cards, and the value of the cards.
		System.out.print("\nEnter name for user 2 " + ": ");
		name2 = in.next();	
		System.out.print("Whats your bet? " + ": ");
		Bet = in.nextDouble();
		personCard = new Cards(name2,cards[random_int2],cards[random_int3],null,null,null, null, null, null, null, null, null, Bet); 
		personCards[1] = personCard; 
		personCard.checkifAce();	 
		System.out.print("\n" + personCards[1].Name + " is siting at seat 2\n\n");
		System.out.print(personCards[1].Name + " Here is your cards: " + personCards[1].Card1.getCard() + " and "+ personCards[1].Card2.getCard() + "\n\n");
		System.out.println("Here is the value of your card: " + personCards[1].getValue());

		//Program requests user three's name, assigns the seat of user three, calculates and prints two random cards, and the value of the cards.
		System.out.print("\nEnter name for user 3 " + ": ");
		name3 = in.next();	
		System.out.print("Whats your bet? " + ": ");
		Bet = in.nextDouble();
		personCard = new Cards(name3,cards[random_int4],cards[random_int5], null,null,null, null, null, null, null, null, null, Bet); 
		personCards[2] = personCard;
		personCard.checkifAce();
		System.out.print("\n" + personCards[2].Name + " is siting at seat 3\n\n" );
		System.out.print(personCards[2].Name + " Here is your cards " + personCards[2].Card1.getCard() + " and " + personCards[2].Card2.getCard());
		System.out.println("\n\nHere is the value of your cards: " + personCards[2].getValue() + "\n\n");

		//Program states dealer, assigns the seat of dealer, and calculates and prints one random card and an Hidden Card.
		personCard = new Cards(dealer,cards[random_int6],cards[random_int7], null,null,null, null, null, null, null, null, null, Bet); 
		personCards[3] = personCard;
		personCard.checkifAce(); 
		System.out.print("\n" + personCards[3].Name + " is siting at seat 4\n\n" );
		System.out.print(personCards[3].Name + " Here is your cards " + personCards[3].Card1.getCard() + " and Hidden Card\n\n");

		int i = 0;
		// initializes arrayLists to calculate and print the total value of Product users.  
		users[i] = new Names(name1, name2, name3, dealer); 


		//For loop that
		for( i = 0; i < personCards.length; i++)
		{ 
			//Random numbers for Cards of users
			int random_int0 = (int)(Math.random() * (45 - 0 ) + 0);
			int random_int11 = (int)(Math.random() * (45 - 0) + 0);
			int random_int22 = (int)(Math.random() * (45 - 0) + 0);
			int random_int33 = (int)(Math.random() * (45 - 0 ) + 0);
			int random_int44 = (int)(Math.random() * (45 - 0) + 0);
			int random_int55 = (int)(Math.random() * (45 - 0) + 0);
			int random_int66 = (int)(Math.random() * (45 - 0) + 0);
			int random_int77 = (int)(Math.random() * (45 - 0) + 0);

			//Random numbers for Cards of dealer
			int random_int00 = (int)(Math.random() * (45 - 0 ) + 0);
			int random_int111 = (int)(Math.random() * (45 - 0) + 0);
			int random_int222 = (int)(Math.random() * (45 - 0) + 0);
			int random_int333 = (int)(Math.random() * (45 - 0 ) + 0);
			int random_int444 = (int)(Math.random() * (45 - 0) + 0);
			int random_int555 = (int)(Math.random() * (45 - 0) + 0);
			int random_int666 = (int)(Math.random() * (45 - 0) + 0);
			int random_int777 = (int)(Math.random() * (45 - 0) + 0);


			if (i == 0) {
				System.out.print("\n" + personCards[3].Name + " Cards are " + personCards[3].Card1.getCard() + " and Hidden Card\n\n");
				System.out.println(personCards[0].Name + " Here is the value of your cards: " + personCards[0].getValue() + "\n");
			}//End if statement that displays dealer cards and after user one's cards and card value before they hit or stand.

			else if (i==1) {
				System.out.print("\n" + personCards[3].Name + " Cards are " + personCards[3].Card1.getCard() + " and Hidden Card\n\n");
				System.out.println(personCards[0].Name + " card value is: " + personCards[0].getValue() + "\n");
				System.out.println(personCards[1].Name + " Here is the value of your cards: " + personCards[1].getValue() + "\n" );
			}//End if else statement that displays dealer cards, user one's cards and card value, and user two's cards and card value before they hit or stand.

			else if (i==2)  {
				System.out.print("\n\n" + personCards[3].Name + " Cards are " + personCards[3].Card1.getCard() + " and Hidden Card\n\n");
				System.out.println(personCards[0].Name + " Card value is: " + personCards[0].getValue() + "\n");
				System.out.println(personCards[1].Name + " Card value is: " + personCards[1].getValue() + "\n" );

				System.out.println(personCards[2].Name  + " Here is the value of your cards: " + personCards[2].getValue() + "\n");
			}//End if else statement that displays dealer cards, user one's cards and card value, user two's cards and card value, and user three's cards and card value before they hit or stand.

			else if (i==3)  {
				System.out.print("\nHere is " + personCards[3].Name + " cards " + personCards[3].Card1.getCard() + " and " + personCards[3].Card2.getCard());

				System.out.println("\n" +personCards[3].Name  + " Here is the value of your cards: " + personCards[3].getValue() + "\n");
			}//End if else statement that displays dealers cards and their hidden card and the value of the two cards.

			if (i <= 2) {

				//if statement that calculates if the value is less than twenty one.
				if (personCards[i] != null && personCards[i].getValue() < 21) {
					System.out.print(personCards[i].Name + " 1. Stand 2. Hit 3.Double Down : ");
					int check1 = in.nextInt();				

					if (check1 == 1) {
						if(i==2) {
							continue;
						}//end if statement
						continue;
					}//end if statement for when user stands.

					//if else statement for when user typed two to Hit
					else if (check1 == 2) { 

						//User receives third card, third card gets added to the total value, and the new value of cards is printed.
						personCards[i].Card3 = cards[random_int0];
						personCard.checkifAce();
						System.out.println("\nYour hand " + personCards[i].Card3.getCard());
						System.out.println("\nYour hand value is at " + personCards[i].getValue());

						//if statement for when user hits blackjack
						if (personCards[i].getValue() == 21) {
							System.out.println("\n" + personCards[i].Name + " has Blackjack!");
							continue;								
						}//end if statement

						//If else statement for when user busts.
						else if (personCards[i].getValue() > 21) {
							System.out.println("You Busted!");
							continue;
						}//end if statement

						//if statement for when user is below twenty one
						if (personCards[i].getValue() <= 21) {
							System.out.print(personCards[i].Name + " 1. Stand 2. Hit: ");
							int check2 = in.nextInt();

							//If statement for when user stands.
							if (check2 == 1) {
								continue;
							}//end if statement

							//if else statement for when user hits.
							else if(check2 == 2) {

								//User receives fourth card, fourth card gets added to the total value, and the new value of cards is printed.
								personCards[i].Card4 = cards[random_int11];
								personCard.checkifAce();
								System.out.println("\nYour hand " + personCards[i].Card4.getCard());
								System.out.println("\nYour hand value is at " + personCards[i].getValue());

								//if statement for when user gets twenty one.
								if (personCards[i].getValue() == 21) {
									continue;								
								}//end if statement

								//if else statement for when user busts
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit: ");
								int check3 = in.nextInt();	

								//if statement for when user stands.
								if (check3 == 1) {
									continue;
								}//end if statement

								//if statement for when user hits
								else if(check3 == 2) {

									//User receives fifth card, fifth card gets added to the total value, and the new value of cards is printed.
									personCards[i].Card5 = cards[random_int22];
									personCard.checkifAce();
									System.out.println("\nYour hand " + personCards[i].Card5.getCard());
									System.out.println("\nYour hand value is at " + personCards[i].getValue());
								}//end if else statement.

								//if statement for when user gets twenty one.
								if (personCards[i].getValue() == 21) {
									continue;								
								}//end if statement

								//if else statement for when user busts.
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement.

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit: ");
								int check4 = in.nextInt();	

								//if statement for when user hits.
								if (check4 == 1) {
									continue;
								}//end if statement

								//end if else statement for when user hits.
								else if(check4 == 2) {

									//User receives six card, six card gets added to the total value, and the new value of cards is printed.
									personCards[i].Card6 = cards[random_int33];
									personCard.checkifAce();
									System.out.println("\nYour hand " + personCards[i].Card6.getCard());
									System.out.println("\nYour hand value is at " + personCards[i].getValue());
								}//end if else statement

								//If statement for when user has twenty one.
								if (personCards[i].getValue() == 21) {
									continue;								
								}//end if statement

								//if else statement for when user busts.
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit: ");
								int check5 = in.nextInt();	

								//if statement for when user stands.
								if (check5 == 1) {
									continue;
								}//end if statement

								//if else statement for when user hits.
								else if(check5 == 2) {

									//User receives seventh card, seventh card gets added to the total value, and the new value of cards is printed.
									personCards[i].Card7 = cards[random_int44];
									personCard.checkifAce();
									System.out.println("\nYour hand " + personCards[i].Card7.getCard());
									System.out.println("\nYour hand value is at " + personCards[i].getValue());
								}//end if else statement

								//if statement for when user has twenty one
								if (personCards[i].getValue() == 21) {
									continue;								
								}//end if statement

								//if statement for when user busts
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
								int check8 = in.nextInt();

								//if statement for when user stands.
								if (check8 == 1) {
									continue;
								}//end if statement

								//if statement for when user hits.
								else if(check8 == 2) {

									//User receives eighth card, eighth card gets added to the total value, and the new value of cards is printed.
									personCards[i].Card8 = cards[random_int55];
									personCard.checkifAce();
									System.out.println("\nYour hand " + personCards[i].Card8.getCard());
									System.out.println("\nYour hand value is at " + personCards[i].getValue());
								}//end if else statement

							}//end if else statement.
						}//end if statement
					}//end if else statement

					//if else statement for when user double down.
					else if (check1==3) {

						//Calculates and prints the bet multiplied by two, user receives third card, and it gets added to the total value of cards.
						System.out.println(personCards[i].Bet * 2);
						personCards[i].doubledown = true;
						personCards[i].Card3 = cards[random_int0];
						personCard.checkifAce();
						System.out.println("\nYour hand " + personCards[i].Card3.getCard());
						System.out.println("\nYour hand value is at " + personCards[i].getValue());
					}//end if else statement

					//if else statement for when user busts.
					else if (personCards[i].getValue() > 21) {
						System.out.println("You Busted!");
						continue;

					}//end if else statement
				}//end if statement
			}//end if statement

			//if else statement for when it is dealers turn
			else if (i == 3) {

				//if statement for when card values are less than twenty one
				if (personCards[i] != null && personCards[i].getValue() < 21) {

					System.out.print(personCards[i].Name + " 1. Stand 2. Hit : ");

					//if statement for when dealers cards are in between seventeen and twenty one.
					if (personCards[i].getValue() >= 17 && personCards[i].getValue() <=21 ) {
						break;								
					}//end if statement

					//if else statement for when dealers cards value are twenty one
					else if ( personCards[i].getValue() == 21) {
						System.out.println("\n" + personCards[i].Name + " Has Blackjack!");
						break;		
					}//end if else statement

					int check1 = 2;	

					//if stand continue
					if (check1 == 1) {
						if(i==2) {
							break;
						}
						continue;
					}

					//if else statement for when dealer hits
					else if (check1 == 2) {

						//Dealer receives third card, it is added to the card value of dealer, and the new card value is printed.
						personCards[i].Card3 = cards[random_int66];
						personCard.checkifAce();
						System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card3.getCard());
						System.out.println("\n\n" + personCards[i].Name +  " hand value is at " + personCards[i].getValue());

						//if statement for when dealers card value is in between seventeen and twenty one
						if (personCards[i].getValue() >= 17 && personCards[i].getValue() <=21 ) {
							break;								
						}//end if statement

						//if else statement for when dealers card value is twenty one.
						else if ( personCards[i].getValue() == 21) {
							System.out.println("\n" + personCards[i].Name + " Has Blackjack!");
							break;		
						}//end if else statement

						//if else statement for when dealer busts
						else if (personCards[i].getValue() > 21) {
							System.out.println("You Busted!");
							continue;
						}//end if else statement

						//if statement for when cards are less than or equal to sixteen
						if (personCards[i].getValue() <= 16) {

							System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
							int check2 = 2;	

							//if statement for when dealer stands
							if (check2 == 1) {
								continue;
							}//end if statement

							//if else statement for when dealer hits
							else if(check2 == 2) {

								//Dealer receives fourth card, it is added to the card value of dealer, and the new card value is printed.
								personCards[i].Card4 = cards[random_int77];
								personCard.checkifAce();
								System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card4.getCard());
								System.out.println("\n\n" + personCards[i].Name + " hand value is at " + personCards[i].getValue());

								//if statement for when dealer is between seventeen and twenty one.
								if (personCards[i].getValue() >= 17 && personCards[i].getValue() <= 21 ) {
									break;								
								}//end if statement

								//if else statement for when dealer busts
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
								int check3 = 2;	

								//if statement for when dealer stands.
								if (check3 == 1) {
									continue;
								}//end if statement

								//if else statement for when dealer hits
								else if(check3 == 2) {

									//Dealer receives fifth card, it is added to the card value of dealer, and the new card value is printed.
									personCards[i].Card5 = cards[random_int111];
									personCard.checkifAce();
									System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card5.getCard());
									System.out.println("\n\n" + personCards[i].Name +  " hand value is at " + personCards[i].getValue());
								}//end if else statement

								//if statement for when dealers card values are inbetween seventeen and twenty one.
								if (personCards[i].getValue() >= 17 && personCards[i].getValue() <=21 ) {
									break;								
								}//end if statement

								//if else statement for when dealer busts.
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
								int check4 = 2;

								//if statement for if dealer stands. 
								if (check4 == 1) {
									continue;
								}//end if statement

								//if else statement for if dealer hits
								else if(check4 == 2) {

									//Dealer receives sixth card, it is added to the card value of dealer, and the new card value is printed.
									personCards[i].Card6 = cards[random_int222];
									personCard.checkifAce();
									System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card6.getCard());
									System.out.println("\n\n" + personCards[i].Name +  " hand value is at " + personCards[i].getValue());
								}//end if else statement

								//if statement for if dealer is between seventeen and twenty one.
								if (personCards[i].getValue() >= 17 && personCards[i].getValue() <=21 ) {
									break;								
								}//end if statement

								//if else statement for if dealer busts.
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//if statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
								int check5 = 2;

								//if statement for if dealer stands.
								if (check5 == 1) {
									continue;
								}//if statement

								//if statement for if dealer hits.
								else if(check5 == 2) {

									//Dealer receives seventh card, it is added to the card value of dealer, and the new card value is printed.
									personCards[i].Card7 = cards[random_int333];
									personCard.checkifAce();
									System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card7.getCard());
									System.out.println("\n\n" + personCards[i].Name +  " hand value is at " + personCards[i].getValue());
								}//end if else statement

								//if statement for when dealer is between seventeen and twenty one
								if (personCards[i].getValue() >= 17 && personCards[i].getValue() <=21 ) {
									break;								
								}//end if statement

								//if else statement for when dealer busts
								else if (personCards[i].getValue() > 21) {
									System.out.println("You Busted!");
									continue;
								}//end if else statement

								System.out.print(personCards[i].Name + " 1. Stand 2. Hit");
								int check8 = 2;	

								//if statement for when dealer stands
								if (check8 == 1) {
									continue;
								}//end if statement

								//if else statement for when dealer hits
								else if(check8 == 2) {

									//Dealer receives eighth card, it is added to the card value of dealer, and the new card value is printed.
									personCards[i].Card8 = cards[random_int333];
									personCard.checkifAce();
									System.out.println("\n\n" + personCards[i].Name + " hand " + personCards[i].Card8.getCard());
									System.out.println("\n\n" + personCards[i].Name +  " hand value is at " + personCards[i].getValue());

								}//end if else statement

							}//end if else statement

						}//end if statement
					}else if (personCards[i].getValue() > 21) {
						System.out.println("You Busted!");
						break;
					}

				}//end if statement
			}//end if else statement

		}//end for loop
		return i;
	}//end checkDealing()


	/*
	 * Method Name: playAgain()
	 * Description: Runs the program again if the user enters y or Y
	 * Parameters:  
	 * Returns: Boolean even
	 */
	public static boolean playAgain() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nPlay again? (Y/N): \n");
		String replay = keyboard.nextLine();
		return replay.equals("Y");
	}//end playAgain()

	/*
	 * Method Name: checkWinner
	 * Description: Determines the winner of Blackjack using if else statements.
	 * Parameters:  personCards
	 * Returns: n/a
	 */

	public static int checkWinner(Cards[] p)
	{
		if (p[3].getValue() == p[0].getValue() && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() == p[1].getValue() && p[2].getValue() == 21 && p[1].getValue() == 21 && p[2].getValue() > p[3].getValue()) {   

			System.out.println("\nplayer two and three are tied. And split the chips.");
		}
		else if(p[0].getValue() > 21 && p[2].getValue() > 21 && p[1].getValue() <= 21 && p[3].getValue() <= 21 && p[1].getValue() > p[3].getValue()) {
			System.out.println("\nplayer two wins");
			return 1;
		}
		else if (p[0].getValue() > 21 && p[2].getValue() > p[1].getValue() && p[3].getValue() == p[1].getValue() && p[2].getValue() <=21 && p[1].getValue() <=21 ) {
			System.out.println("\nplayer three wins");
			return 2;
		}
		else if (p[3].getValue() == p[0].getValue() && p[0].getValue() > p[2].getValue() && p[2].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() <=21 && p[1].getValue() <=21 ) {
			System.out.println("\nDealer and player one are tied. And split the chips.");
		}
		else if (p[0].getValue() > p[1].getValue() && p[3].getValue() > 21 && p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <= 21) {
			System.out.println("\nplayer one wins");
			return 0;
		}
		else if (p[1].getValue() > p[3].getValue() && p[3].getValue() == p[0].getValue() && p[1].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() <= 21 && p[2].getValue() > 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}
		else if (p[2].getValue() > p[1].getValue() && p[1].getValue() <= 21 && p[2].getValue() <= 21 && p[0].getValue() > 21 && p[3].getValue() > 21 ) {
			System.out.println("\nPlayer three and two are tied.And split the chips.");
		}
		else if (p[0].getValue() == p[1].getValue() && p[1].getValue() > p[3].getValue() && p[2].getValue() > 21 && p[0].getValue() <=21 && p[1].getValue() <=21 && p[3].getValue() <=21  )
		{
			System.out.println("\nPlayer one and two are tied. And split the chips.");
		}
		else if (p[2].getValue() > p[3].getValue() && p[1].getValue() > 21 && p[0].getValue() > 21 && p[2].getValue() <= 21 && p[3].getValue() <= 21 ) {
			System.out.println("\nPlayer three wins");
			return 2;
		}
		else if (p[0].getValue() > p[3].getValue() && p[1].getValue() > 21 && p[2].getValue() > 21 && p[0].getValue() <= 21 && p[3].getValue() <=21 )
		{
			System.out.println("\nPlayer one wins");
			return 0;
		}
		else if (p[0].getValue() < p[3].getValue() && p[1].getValue() > 21 && p[2].getValue() > 21 && p[0].getValue() <=21 && p[3].getValue() <=21 ) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[0].getValue() > 21 && p[1].getValue() <= 21 && p[2].getValue() <=21 &&  p[3].getValue() <=21 && p[1].getValue() < p[2].getValue() && p[2].getValue() < p[3].getValue() ) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[2].getValue() > 21 && p[0].getValue() > 21 && p[3].getValue() > p[1].getValue() && p[3].getValue() <=21 && p[1].getValue() <=21    ) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[2].getValue() > 21 && p[0].getValue() == p[3].getValue() && p[0].getValue() == 21 && p[3].getValue() == 21 && p[3].getValue() > p[1].getValue() ) {
			System.out.println("\nDealer and player 1 wins. And split the chips.");
		}
		else if (p[1].getValue() > 21 && p[0].getValue() > 21 && p[2].getValue() <= 21 && p[3].getValue() <= 21 && p[3].getValue() > p[2].getValue() ) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[0].getValue() > 21 && p[1].getValue() <= 21 && p[2].getValue() <=21 &&  p[3].getValue() <=21 && p[1].getValue() < p[3].getValue() && p[3].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if (p[0].getValue() > 21 && p[1].getValue() <= 21 && p[2].getValue() <=21 &&  p[3].getValue() <=21 && p[1].getValue() > p[3].getValue() && p[1].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if (p[0].getValue() > 21 && p[1].getValue() <= 21 && p[2].getValue() <=21  && p[3].getValue() <=21 && p[2].getValue() < p[3].getValue() && p[3].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if (p[0].getValue() > 21 && p[1].getValue() <= 21 && p[2].getValue() <=21  && p[3].getValue() <=21 && p[3].getValue() < p[2].getValue() && p[2].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 2;
		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[2].getValue() < p[3].getValue() && p[3].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[3].getValue() < p[2].getValue() && p[0].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[0].getValue() < p[3].getValue() && p[3].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");

			return 2;		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[3].getValue() < p[0].getValue() && p[0].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[0].getValue() < p[2].getValue() && p[2].getValue() < p[3].getValue()  ) {
			System.out.println("\ndealer wins");
			return 3;
		}
		else if (p[1].getValue() > 21 && p[3].getValue() <= 21 && p[0].getValue() <= 21 && p[2].getValue() <=21 && p[2].getValue() < p[0].getValue() && p[0].getValue() < p[3].getValue()  ) {
			System.out.println("\ndealer wins");
			return 3;
		}


		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() < p[3].getValue() && p[3].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[3].getValue() < p[0].getValue() && p[0].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[1].getValue() < p[3].getValue() && p[3].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[3].getValue() < p[1].getValue() && p[1].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[1].getValue() < p[0].getValue() && p[0].getValue() < p[3].getValue()  ) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[2].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() < p[1].getValue() && p[1].getValue() < p[3].getValue()  ) {
			System.out.println("\nDealer wins");
			return 3;
		}

		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[2].getValue() <=21 && p[1].getValue() < p[2].getValue() && p[2].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[2].getValue() < p[1].getValue() && p[1].getValue() < p[0].getValue()  ) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}

		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[2].getValue() <=21 && p[2].getValue() < p[0].getValue() && p[0].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() < p[2].getValue() && p[2].getValue() < p[1].getValue()  ) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}

		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[2].getValue() <=21 && p[1].getValue() < p[0].getValue() && p[0].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if (p[3].getValue() > 21 && p[1].getValue() <= 21 && p[0].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() < p[1].getValue() && p[1].getValue() < p[2].getValue()  ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}

		else if (p[0].getValue() > 21 && p[1].getValue() > 21 && p[2].getValue() > 21 && p[3].getValue() <= 21 ) {
			System.out.println("\nDealer wins");
			return 3;
		}

		else if (p[0].getValue() > 21 && p[1].getValue() > 21 && p[2].getValue() <=21 && p[3].getValue() > 21) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if(p[0].getValue() > 21 && p[3].getValue() > 21 && p[2].getValue() > 21 && p[1].getValue() <=21)  {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if ( p[3].getValue() > 21 && p[2].getValue() > 21 && p[1].getValue() > 21 && p[0].getValue() > 21  ) {
			System.out.println("\nIts a draw");

		} 
		else if(p[1].getValue() > 21 && p[2].getValue() > 21 && p[3].getValue() > 21 && p[0].getValue() <=21) {
			System.out.println("\nPlayer 1 wins");
			//make code where player 1 and 3 are above 21
			return 0;
		}


		else if (p[0].getValue() == p[1].getValue()  && p[3].getValue() > 21 && p[0].getValue() <=21 && p[1].getValue() <=21 && p[2].getValue() > 21) {
			System.out.println("\nPlayer 1 and 2 wins. And split the chips.");

		}
		else if (p[0].getValue() == p[2].getValue() && p[3].getValue() > 21   &&  p[0].getValue() <=21 && p[2].getValue() <=21 && p[1].getValue() > 21) {
			System.out.println("\nPlayer 1 and 3 wins. And split the chips.");

		}
		else if (p[0].getValue() == p[3].getValue()  &&  p[3].getValue() <=21 &&  p[0].getValue() <=21 && p[2].getValue() >21 && p[1].getValue() > 21) {
			System.out.println("\nPlayer 1 and Dealer wins. And split the chips.");
		}


		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() <=21 && p[2].getValue() <=21 && p[0].getValue() > 21 && p[3].getValue() > 21) {
			System.out.println("\nPlayer 2 and 3 wins. And split the chips.");
		}
		else if (p[1].getValue() == p[3].getValue() && p[1].getValue() <=21 && p[3].getValue() <=21 && p[0].getValue() > 21 && p[2].getValue() > 21) {
			System.out.println("\nPlayer 2 and 3 wins. And split the chips.");
		}


		else if (p[0].getValue() == p[1].getValue() && p[0].getValue() > 21 && p[1].getValue() > 21 && p[1].getValue() == p[2].getValue() && p[3].getValue() <=21 ) {
			System.out.println("\nDealer wins");
			return 0;
		}
		else if (p[0].getValue() == p[1].getValue() && p[3].getValue() > 21 && p[0].getValue() > 21 && p[1].getValue() > 21 && p[1].getValue() == p[3].getValue()  && p[2].getValue() <=21 ) {
			System.out.println("\nPlayer 3 wins");
			return 2;
		}
		else if(p[0].getValue() == p[2].getValue() && p[0].getValue() > 21 && p[2].getValue() > 21 && p[3].getValue() > 21  && p[2].getValue() == p[3].getValue() && p[1].getValue() <=21) {
			System.out.println("\nPlayer 2 wins");
			return 1;
		}
		else if(p[1].getValue() == p[2].getValue() && p[3].getValue() > 21 && p[1].getValue() > 21 && p[2].getValue() > 21  && p[0].getValue() <=21 && p[2].getValue() == p[3].getValue()) {
			System.out.println("\nPlayer 1 wins");
			return 0;
		}
		else if (p[0].getValue() == p[1].getValue() && p[0].getValue() <=21 && p[1].getValue() <=21 && p[2].getValue() > 21 && p[3].getValue() > 21) {
			System.out.println("\nPlayer 1 and 2 wins. And split the chips.");
		}
		else if (p[0].getValue() == p[2].getValue() && p[0].getValue() <=21 && p[2].getValue() <=21 && p[1].getValue() > 21 && p[3].getValue() > 21) {
			System.out.println("\nPlayer 1 and 3 wins. And split the chips.");
		}
		else if (p[0].getValue() == p[3].getValue() && p[0].getValue() <=21 && p[2].getValue() > 21 && p[1].getValue() > 21 && p[3].getValue() > 21) {
			System.out.println("\nPlayer 1 and dealer wins. And split the chips.");
		}
		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() <=21 && p[2].getValue() <=21 && p[3].getValue() > 21 && p[0].getValue() > 21) {
			System.out.println("\nPlayer 2 and 3 wins. And split the chips.");
		}

		//Check if they are draws
		else if (p[0].getValue() == p[1].getValue() && p[1].getValue() == p[2].getValue() && p[1].getValue() == p[3].getValue()) {
			System.out.println("\nIts a draw!");
		}
		else if (p[0].getValue() == p[1].getValue() && p[0].getValue() == p[2].getValue() && p[1].getValue() < p[3].getValue() && p[3].getValue()<= 21) {
			System.out.println("\nDealer wins");
			return 3;
		}
		else if (p[0].getValue() == p[1].getValue() && p[0].getValue() == p[3].getValue() && p[1].getValue() < p[2].getValue() && p[2].getValue()<= 21) {
			System.out.println("\nPlayer three wins");
			return 2;
		}
		else if (p[0].getValue() == p[2].getValue() && p[3].getValue() == p[2].getValue() && p[2].getValue() < p[1].getValue() && p[1].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}
		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() == p[3].getValue() && p[1].getValue() < p[0].getValue() && p[0].getValue()<= 21) {
			System.out.println("\nPlayer one wins");
			return 0;
		} 
		else if (p[0].getValue() == p[1].getValue() && p[1].getValue() > p[2].getValue()  && p[2].getValue() > p[3].getValue() && p[3].getValue() <=21 && p[0].getValue() <=21 ) {
			System.out.println("\nPlayer one and two wins! And split the chips.");
		}
		else if (p[0].getValue() == p[1].getValue() && p[1].getValue() > p[3].getValue()  && p[3].getValue() > p[2].getValue() && p[3].getValue() <=21 && p[0].getValue() <=21 ) {
			System.out.println("\nPlayer one and two wins! And split the chips.");
		}
		else if (p[0].getValue() == p[2].getValue() && p[2].getValue() > p[1].getValue() && p[1].getValue() > p[3].getValue() && p[0].getValue() <=21 && p[3].getValue() <=21 ) {
			System.out.println("\nPlayer one and player three wins! And split the chips.");
		}
		else if (p[0].getValue() == p[2].getValue() && p[2].getValue() > p[3].getValue() && p[3].getValue() > p[1].getValue() && p[0].getValue() <=21 && p[2].getValue() <=21 ) {
			System.out.println("\nPlayer one and three wins! And split the chips.");
		}

		else if (p[0].getValue() == p[3].getValue() && p[3].getValue() > p[1].getValue() && p[1].getValue() > p[2].getValue() && p[0].getValue() <=21 && p[2].getValue() <=21 ) {
			System.out.println("\nPlayer one and Dealer wins! And split the chips.");
		}
		else if (p[0].getValue() == p[3].getValue() && p[3].getValue() > p[2].getValue() && p[2].getValue() > p[1].getValue() && p[0].getValue() <=21 && p[3].getValue() <=21 ) {
			System.out.println("\nPlayer one and Dealer wins! And split the chips.");
		}

		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() > p[3].getValue() && p[3].getValue() > p[0].getValue() && p[1].getValue() <=21 && p[2].getValue() <=21 ) {
			System.out.println("\nPlayer two and three wins! And split the chips.");
		}
		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() > p[0].getValue() && p[0].getValue() > p[3].getValue() && p[1].getValue() <=21 && p[2].getValue() <=21 ) {
			System.out.println("\nPlayer two and three wins! And split the chips.");
		}
		else if (p[1].getValue() == p[3].getValue() && p[1].getValue() > p[2].getValue() && p[2].getValue() > p[0].getValue() && p[1].getValue() <=21 && p[3].getValue() <=21 ) {
			System.out.println("\nPlayer two and Dealer wins! And split the chips.");
		}
		else if (p[1].getValue() == p[3].getValue() && p[1].getValue() > p[0].getValue() && p[0].getValue() > p[2].getValue() && p[1].getValue() <=21 && p[3].getValue() <=21 ) {
			System.out.println("\nPlayer two and Dealer wins! And split the chips.");
		}


		else if (p[0].getValue() > p[1].getValue() && p[1].getValue() > p[3].getValue() && p[3].getValue() > p[2].getValue() && p[0].getValue()<= 21) {
			System.out.println("\nPlayer one wins");
			return 0;
		}
		else if (p[0].getValue() > p[1].getValue() && p[1].getValue() > p[2].getValue() && p[2].getValue() > p[3].getValue() && p[0].getValue()<= 21) {
			System.out.println("\nPlayer one wins");
			return 0;
		}

		else if (p[0].getValue() > p[1].getValue() && p[3].getValue() < p[1].getValue() && p[1].getValue() < p[2].getValue() && p[2].getValue() < p[0].getValue() && p[0].getValue()<= 21) {
			System.out.println("\nPlayer one wins");
			return 0;
		}
		else if (p[0].getValue() > p[1].getValue() && p[1].getValue() < p[3].getValue() && p[3].getValue() < p[2].getValue() && p[2].getValue() < p[0].getValue() && p[0].getValue()<= 21) {
			System.out.println("\nPlayer one wins");
			return 0;
		}

		else if (p[1].getValue() > p[0].getValue() && p[0].getValue() > p[2].getValue() && p[0].getValue() > p[3].getValue() && p[1].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}
		else if (p[1].getValue() > p[3].getValue() && p[3].getValue() > p[2].getValue() && p[3].getValue() > p[0].getValue() && p[1].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}

		else if (p[1].getValue() > p[0].getValue() && p[3].getValue() < p[0].getValue() && p[0].getValue() < p[2].getValue() && p[2].getValue() < p[1].getValue() && p[1].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}
		else if (p[1].getValue() > p[0].getValue() && p[0].getValue() < p[3].getValue() && p[3].getValue() < p[2].getValue() && p[2].getValue() < p[1].getValue() && p[1].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}

		else if (p[2].getValue() > p[1].getValue() && p[1].getValue() > p[3].getValue() && p[3].getValue() > p[0].getValue() && p[2].getValue()<= 21) {
			System.out.println("\nPlayer three wins");
			return 2;
		}
		else if (p[2].getValue() > p[1].getValue() && p[1].getValue() > p[0].getValue() && p[0].getValue() > p[3].getValue() && p[2].getValue()<= 21) {
			System.out.println("\nPlayer three wins");
			return 2;
		}



		else if (p[3].getValue() > p[1].getValue() && p[1].getValue() < p[0].getValue() && p[2].getValue() < p[0].getValue()  && p[0].getValue() < p[3].getValue() && p[3].getValue()<= 21) {
			System.out.println("\nDealer wins");
			return 3;	
		}
		else if (p[3].getValue() > p[1].getValue() && p[1].getValue() < p[0].getValue() && p[0].getValue() < p[2].getValue()  && p[2].getValue() < p[3].getValue() && p[3].getValue()<= 21) {
			System.out.println("\nDealer wins");
			return 3;
		}

		else if (p[2].getValue() > p[1].getValue() && p[1].getValue() < p[0].getValue() && p[3].getValue() < p[0].getValue()  && p[0].getValue() < p[2].getValue() && p[2].getValue()<= 21) {
			System.out.println("\nPlayer three wins");
			return 2;
		}
		else if (p[2].getValue() > p[1].getValue() && p[1].getValue() < p[0].getValue() && p[0].getValue() < p[3].getValue()  && p[3].getValue() < p[2].getValue() && p[2].getValue()<= 21) {
			System.out.println("\nPlayer three wins");
			return 2;
		}
		else if (p[0].getValue() == p[2].getValue() && p[0].getValue() == p[3].getValue() && p[2].getValue() < p[1].getValue() && p[1].getValue()<= 21 && p[3].getValue()<= 21) {
			System.out.println("\nPlayer two wins");
			return 1;
		}
		else if (p[1].getValue() == p[2].getValue() && p[1].getValue() < p[0].getValue() && p[0].getValue()<= 21 && p[3].getValue()<= 21 && p[1].getValue() == p[3].getValue()   ) {
			System.out.println("\nPlayer one wins");
			return 0;
		}
		return 0;
	}//end method checkWinner()

	/*
	 * Method Name: getTotalBets
	 * Description: Calculates and prints the bets of all three users.
	 * Parameters:  personCards
	 * Returns: n/a
	 */
	public static double getTotalBets(Cards[] p)
	{
		return p[0].Bet + p[1].Bet + p[2].Bet;
	}//end method getTotalBets()

}//end finalproject






















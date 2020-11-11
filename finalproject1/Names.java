//Name: Leonardo Moodley
//Teacher: Mrs. McCaffery 
//Subject: ICS3UI
//Date: November 10, 2020
//Description: The program stores the names of the users.


package finalproject1;

public class Names
{
	public String code;
	public String name1;
	public String name2;
	public String name3;
	


	/*
	 * Method Name: Names
	 * Description: Stores names of users.
	 * Parameters: String newname1, String newname2, String newname3, String newname4
	 * Returns: n/a
	 */

	public Names( String newname1, String newname2,
			String newname3, String newname4)
	{
		name1 = newname1;
		name2 = newname2;
		name3 = newname3;

	}

	
	/*
	 * Method Name: newname1
	 * Description: returns name1
	 * Parameters: 
	 * Returns: n/a
	 */

	public String newname1()
	{   
		return name1;
	}//end method newname1()

	/*
	 * Method Name: newname2
	 * Description: returns name2
	 * Parameters: 
	 * Returns: n/a
	 */

	public String newname2()
	{   
		return name2;
	}//end method newname2()

	/*
	 * Method Name: newname3
	 * Description: returns name3
	 * Parameters: 
	 * Returns: n/a
	 */

	public String newname3()
	{   
		return name3;
	}//end method newname3()


	/*
	 * Method Name: toString
	 * Description: returns name1, name2, name3 as Strings.
	 * Parameters: 
	 * Returns: n/a
	 */
	public String toString()
	{
		return String.format("%s %s %s ",
				name1, name2, name3);
	}//end method toString
}//end Names
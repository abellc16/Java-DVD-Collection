/**
 * @author     Camby Abell
 * @assignment assg6_Abell
 * @filename   ArrayListDVDCollection.java
 */

package assg6_Abell;

import java.io.*;
import java.util.*;


public class ArrayListDVDCollection implements DVDCollectionInterface
{
	// Initialize the ArrayList of DVDs
	public static ArrayList<DVD> arrList = new ArrayList<DVD>();
	Scanner kbd = new Scanner(System.in);
	
	/**
	 * loadData(file) will read data from a file and load the data containing
	 * the DVD collection entries.
	 * 
	 * @param file - the file to be read in.
	 */
	public void loadData(String file)
	{	
		try 
		{
			Scanner reader = new Scanner(new File(file));
			
			while (reader.hasNextLine())
			{
				String t = reader.nextLine();
				String cat = reader.nextLine();
				String run = reader.nextLine();
				String yr = reader.nextLine();
				String pr = reader.nextLine();
				
				arrList.add(new DVD(t, cat, run, yr, pr));
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
	}
	
	/**
	 * lookupEntry(t) will check to see if a DVD already exists in a DVD
	 * collection.
	 * 
	 * @param t - the title of the DVD being looked up.
	 * @return arrList.get(i) - the DVD at index i of an ArrayList.
	 * @return null - the the DVD does not exist in the ArrayList.
	 */
	public DVD lookupEntry(String t)
	{
		// Determine length of arrList
		int len = arrList.size();
		
		// Loop through to see if DVD exists in arrList.
		for(int i = 0; i < len; i++)
		{
			if(arrList.get(i).getTitle().equals(t))
			{
				return arrList.get(i);
			}
		}
		return null;
	}

	/**
	 * addOrChangeDVD(t, cat, run, yr, pr) will add a new DVD to a DVD
	 * collection if the DVD does not exist, or if the DVD does exist the user
	 * will be able to change the fields of the DVD (excluding the title of
	 * the DVD).
	 * 
	 * @param t - the title of a DVD.
	 * @param cat - the category of a DVD.
	 * @param run - the runtime of a DVD.
	 * @param yr - the release year of a DVD.
	 * @param pr - the price of a DVD.
	 * @return null - if a new DVD is added to the existing DVD collection.
	 * @return temp - a temporary DVD that will act as a placeholder for an
	 * 				  amended existing DVD.
	 */
	public DVD addOrChangeDVD(String t, String cat, String run, String yr, String pr) 
	{
		DVD temp = this.lookupEntry(t);
		int userNum = -1;
		String ch;
		
		if(temp == null)
		{
			// Adding a new DVD
			
			DVD addDVD = new DVD(t, cat, run, yr, pr);
			arrList.add(addDVD);
			return null;
		}
		else
		{
			// Changing an existing DVD
			
			System.out.println("1: Title: " + temp.getTitle() + "\n"
					 		 + "2: Category: " + temp.getCategory() + "\n"
					 		 + "3: Runtime: " + temp.getRuntime() + "\n"
					 		 + "4: Year Released: " + temp.getYear() + "\n"
					 		 + "5: Price: $" + temp.getPrice() + "\n");
			
			System.out.println("Choose a number 1-5 to edit a field, "
							 + "0 returns you to the main menu.");
			
			while(userNum != 0)
			{
				userNum = kbd.nextInt();
				kbd.nextLine();
				
				if(userNum == 0)
				{
					System.out.println("Exiting...\n");
					return temp;
				}
				
				switch(userNum)
				{
					case 1:
						System.out.println("Cannot edit title.");
						break;
					case 2:
						System.out.println("Changing category...");
						System.out.print("Enter new category:");
						ch = kbd.nextLine();
						temp.setCategory(ch);
						break;
					case 3:
						System.out.println("Changing runtime...");
						System.out.print("Enter new runtime:");
						ch = kbd.nextLine();
						temp.setRuntime(ch);
						break;
					case 4:
						System.out.println("Changing year...");
						System.out.print("Enter new year:");
						ch = kbd.nextLine();
						temp.setYear(ch);
						break;
					case 5:
						System.out.println("Changing price...");
						System.out.print("Enter new price:");
						ch = kbd.nextLine();
						temp.setPrice(ch);
						break;
					default:
						System.out.println("Invalid entry.");
						break;
				}
				
				System.out.println(temp.toString());
				System.out.println("Choose a number 1-5 to edit a field, "
								 + "0 returns you to the main menu.");
			}
			return temp;
		}
	}

	/**
	 * removeDVD(t) will remove a DVD from a DVD collection if the DVD exists
	 * in the collection.
	 * 
	 * @param t - the title of the DVD to be removed from the collection.
	 * @return temp - the DVD that has been removed from the collection.
	 * @return null - if the DVD trying to be removed does not exist.
	 */
	public DVD removeDVD(String t)
	{
		DVD temp;
		
		for(int i = 0; i < arrList.size(); i++)
		{
			if(arrList.get(i).getTitle().equals(t))
			{
				temp = arrList.get(i);
				arrList.remove(i);
				return temp;
			}
		}
		
		return null;
		
	}

	/**
	 * getDVDsInCategory(cat) will determine all of the DVDs in a specified
	 * category.
	 * 
	 * @param cat - the specified category.
	 * @return tempList - a temporary list that will hold all of the DVDs that
	 *                    the specified category.
	 */
	public ArrayList<DVD> getDVDsInCategory(String cat) 
	{
		int len = arrList.size();
		
		// Temporary ArrayList
		ArrayList<DVD> tempList = new ArrayList<DVD>();
		
		for(int i = 0; i < len; i++)
		{
			if(arrList.get(i).getCategory().equals(cat))
			{
				tempList.add(arrList.get(i));
			}
		}
		
		return tempList;
	}

	/**
	 * Save() will write the current DVD collection back to a file.
	 */
	public void Save() 
	{
		File file = new File("DVDCollection.txt");
		FileWriter wr;
		
		try
		{
			wr = new FileWriter(file);
			
			// Loop through each field of each element in the ArrayList
			for(int i = 0; i < arrList.size(); i++)
			{
				wr.write(arrList.get(i).getTitle().toString() + "\n");
				wr.write(arrList.get(i).getCategory().toString() + "\n");
				wr.write(arrList.get(i).getRuntime().toString() + "\n");
				wr.write(arrList.get(i).getYear().toString() + "\n");
				wr.write(arrList.get(i).getPrice().toString() + "\n");
			}

			wr.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}

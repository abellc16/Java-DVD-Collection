/**
 * @author     Camby Abell
 * @assignment assg6_Abell
 * @filename   DVDApplication.java
 */

package assg6_Abell;

import java.util.*;
import assg6_Abell.ArrayListDVDCollection;

public class DVDApplication extends ArrayListDVDCollection
{
	public static void main(String args[])
	{
		// Declare variables
		int userNum = -1;
		String t, cat, run, yr, pr;
		ArrayListDVDCollection DVDInt = new ArrayListDVDCollection();
		Scanner kbd = new Scanner(System.in);
				
		// Load the data into the DVD collection.
		DVDInt.loadData("DVDCollection.txt");	
		
		System.out.println("MAIN MENU: ");
		System.out.println("1: Add new DVD entry\n"
						 + "2: Change Existing DVD entry\n"
				         + "3: Look up DVD entry\n"
						 + "4: Display DVDs by category\n"
				         + "5: Remove a DVD entry\n"
						 + "6: Save\n"
				         + "0: Exit");
		System.out.print("Choose an option from the above choices: ");
		
		// Loop to use the main menu until user enters 0
		while(userNum != 0)
		{
			userNum = kbd.nextInt();
			
			kbd.nextLine();		// Prevents newline from interfering.
			
			switch(userNum)
			{
				// Add new DVD entry
				case 1:
					System.out.println("Enter title:");
					t = kbd.nextLine();
					
					DVD temp = DVDInt.lookupEntry(t);
					
					if(temp != null)
					{
						System.out.println("DVD already exists, returning to main menu.");
					}
					else
					{
						// Ask user for last four fields of new DVD.
						System.out.println("DVD not found...");
						
						System.out.print("Enter category:");
						cat = kbd.nextLine();
						
						System.out.print("Enter runtime:");
						run = kbd.nextLine();
						
						System.out.print("Enter year released:");
						yr = kbd.nextLine();
						
						System.out.print("Enter price:");
						pr = kbd.nextLine();
						
						DVDInt.addOrChangeDVD(t, cat, run, yr, pr);
					}
					break;
				
				// Change Existing DVD entry
				case 2:
					System.out.println("Enter title:");
					t = kbd.nextLine();
					
					temp = DVDInt.lookupEntry(t);
					
					if(temp != null)
					{
						cat = temp.getCategory();
						run = temp.getRuntime();
						yr = temp.getYear();
						pr = temp.getPrice();
						
						DVDInt.addOrChangeDVD(t, cat, run, yr, pr);
					}
					else
					{
						System.out.println("Cannot change, DVD does not exist.");
					}
					break;
				
				// Look up DVD entry
				case 3:
					System.out.println("Enter title: ");
					t = kbd.nextLine();
					
					temp = DVDInt.lookupEntry(t);
					
					if(temp == null)
					{
						System.out.println("DVD not found.\n");
					}
					else
					{
						System.out.println("Found DVD!");
						System.out.println(temp.toString());
					}
					break;
					
				// Display DVDs by category
				case 4:
					System.out.println("Enter category: ");
					cat = kbd.nextLine();
					
					ArrayList<DVD> tempList1 = DVDInt.getDVDsInCategory(cat);
					
					if(tempList1.size() == 0)
					{
						System.out.println("There are zero DVDs in category " + cat);
					}
					else
					{
						System.out.println("DVDs in category " + cat + ":");
					}
					
					for(int i = 0; i < tempList1.size(); i++)
					{
						System.out.println(tempList1.get(i).getTitle());
					}
					
					System.out.print("\n");
					break;
				
				// Remove a DVD entry 
				case 5:
					System.out.println("Enter title: ");
					t = kbd.nextLine();
					
					temp = DVDInt.removeDVD(t);
					
					if(temp == null)
					{
						System.out.println("DVD does not exist.\n");
					}
					else
					{
						System.out.println("Removing...");
						System.out.println(temp.toString());
						System.out.println("Removed.");
					}
					break;
					
				// Save
				case 6:
					System.out.println("Saving...\n");
					DVDInt.Save();
					break;
					
				// Exit
				case 0:
					System.out.println("Exiting...\nThanks for using!");
					DVDInt.Save();
					System.exit(0);
					
			}
			
			// Display main menu options to user
			System.out.println("MAIN MENU:");
			System.out.println("1: Add new DVD entry\n"
							 + "2: Change Existing DVD entry\n"
					         + "3: Look up DVD entry\n"
							 + "4: Display DVDs by category\n"
					         + "5: Remove a DVD entry\n"
							 + "6: Save\n"
					         + "0: Exit");
			System.out.print("Choose an option from the above choices: ");
		}	
		
		kbd.close();
	}
}

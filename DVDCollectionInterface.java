/**
 * @author     Camby Abell
 * @assignment assg6_Abell
 * @filename   DVDCollectionInterface.java
 */

package assg6_Abell;

import java.util.*;

public interface DVDCollectionInterface
{
	/**
	 * loadData(file) will read data from a file and load the data containing
	 * the DVD collection entries.
	 * 
	 * @param file - the file to be read in.
	 */
	public void loadData(String file);
	
	/**
	 * lookupEntry(t) will check to see if a DVD already exists in a DVD
	 * collection.
	 * 
	 * @param t - the title of the DVD being looked up.
	 */
	public DVD lookupEntry(String t);
	
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
	 */
	public DVD addOrChangeDVD(String t, String cat, String run, String yr, String pr);
	
	/**
	 * removeDVD(t) will remove a DVD from a DVD collection if the DVD exists
	 * in the collection.
	 * 
	 * @param t - the title of the DVD to be removed from the collection.
	 */
	public DVD removeDVD(String t);
	
	/**
	 * getDVDsInCategory(cat) will determine all of the DVDs in a specified
	 * category.
	 * 
	 * @param cat - the specified category.
	 */
	public ArrayList<DVD> getDVDsInCategory(String cat);
	
	/**
	 * Save() will write the current DVD collection back to a file.
	 */
	public void Save();
}











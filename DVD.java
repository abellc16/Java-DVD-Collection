/**
 * @author     Camby Abell
 * @assignment assg6_Abell
 * @filename   DVD.java
 */

package assg6_Abell;

public class DVD implements Comparable<DVD>
{
	private String title;
	private String category;
	private String runtime;
	private String year;
	private String price;
	
	/**
	 * Default constructor.
	 * 
	 * Although it is rare, it is also still possible.
	 */
	public DVD()
	{
		title = "";
		category = "";
		runtime = "";
		year = "";
		price = "";
	}
	
	/**
	 * Constructor that takes five parameters and initializes all 5 fields.
	 * 
	 * @param t - title
	 * @param cat - category
	 * @param run - runtime
	 * @param yr - year
	 * @param pr - price
	 */
	public DVD(String t, String cat, String run, String yr, String pr)
	{
		title = t;
		category = cat;
		runtime = run;
		year = yr;
		price = pr;
	}
	
	/**
	 * This constructor is used solely for comparing the titles of two DVDs.
	 * @param t - the title of a DVD.
	 */
	public DVD(String t)
	{
		title = t;
		category = "";
		runtime = "";
		year = "";
		price = "";
	}

	/**
	 * getTitle() returns the title of a DVD.
	 * @return - the title of a DVD.
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * getCategory() returns the category of a DVD.
	 * @return - the category of a DVD.
	 */
	public String getCategory()
	{
		return this.category;
	}
	
	/**
	 * getRuntime() returns the runtime of a DVD.
	 * @return - the runtime of a DVD.
	 */
	public String getRuntime()
	{
		return this.runtime;
	}
	
	/**
	 * getYear() returns the year that a DVD was released.
	 * @return - the year a DVD was released.
	 */
	public String getYear()
	{
		return this.year;
	}
	
	/**
	 * getPrice() returns the price of a DVD.
	 * @return - the price of a DVD.
	 */
	public String getPrice()
	{
		return this.price;
	}
	
	/**
	 * setCategory() sets the category of a DVD.
	 * @param cat - the category that will be set to a DVD.
	 */
	public void setCategory(String cat)
	{
		this.category = cat;
	}
	
	/**
	 * setRuntime() sets the runtime of a DVD.
	 * @param run - the runtime that will be set to a DVD.
	 */
	public void setRuntime(String run)
	{
		this.runtime = run;
	}

	/**
	 * setYear() sets the year of a DVD.
	 * @param yr - the year that will be set to a DVD.
	 */
	public void setYear(String yr)
	{
		this.year = yr;
	}
	
	/**
	 * setPrice() sets the price of a DVD.
	 * @param pr - the price that will be set to a DVD.
	 */
	public void setPrice(String pr)
	{
		this.price = pr;
	}
	
	/**
	 * toString() will print the contents of a DVD in a clear and readable
	 * format.
	 */
	public String toString()
	{
		return "Title: " + this.title + "\n"
			 + "Category: " + this.category + "\n"
			 + "Runtime: " + this.runtime + "\n"
			 + "Year Released: " + this.year + "\n"
			 + "Price: $" + this.price + "\n"; 
	}
	
	/**
	 * equals(a, b) will compare the title of DVD a to determine if
	 * they are the same or not.
	 * @param a - the first DVD object that will be compared.
	 * @return true - if the titles are the same.
	 * @return false - if the titles are not the same.
	 */
	public boolean equals(Object obj)
	{
		if(obj != null && obj instanceof DVD)
		{
			DVD newDVD = new DVD(((DVD) obj).getTitle());
			
			if(newDVD.getTitle().equals(this.getTitle()))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * compareTo() will compare two titles of DVDs and will determine which
	 * title comes first alphabetically. 
	 * @param a - the DVD that will be used to compare titles.
	 * @return 
	 */
	public int compareTo(DVD a)
	{
		int compare = this.getTitle().compareTo(a.getTitle());
		
		return compare;	
	}
}


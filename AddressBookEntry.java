
public class AddressBookEntry {
	//private members variable of the class
	private String name;
	private String email;
	private String cellNumber;
	
	//get and set methods for each variable
	public void setName(String n)
	{
		name = n;
	}
	public void setEmail(String e)
	{
		email = e;
	}
	public void setCellNumber(String c)
	{
		cellNumber = c;
	}
	public String getName()
	{
		return name;
		
	}
	public String getEmail()
	{
		return email;
		
	}
	public String getCellNumber()
	{
		return cellNumber;
		
	}
}

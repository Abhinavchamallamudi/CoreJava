
public class Validator {
	// function to validate user's input for an entry
	public static boolean ValidateEntity(AddressBookEntry entity)
	{	//check if any of those fields is emty
		if(entity.getName().equals("") || entity.getEmail().equals("") || entity.getCellNumber().equals(""))
			return false;
		// if anyone of the entries isn't according to rules return false
		// Name can only contain Alphabets, period, -, '
		// email should be in correct format
		// callNumber can be 1234567890 or (123) 456 7890 or 123-456-7890
		if(!entity.getName().matches("^[a-zA-Z -.']*$") || !entity.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.com$") || !entity.getCellNumber().matches("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$"))
			return false;
		else
			return true;
		
	}
	
}

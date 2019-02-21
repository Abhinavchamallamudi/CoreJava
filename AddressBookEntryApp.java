import java.util.Scanner;

public class AddressBookEntryApp {
	
	public static void main(String args[]) {
		int choice = 0;
		AddressBookEntry entry = new AddressBookEntry();
		Scanner input = new Scanner(System.in);
		String in = null;
		System.out.println("\nWelcome to the Address Book Application\n");
		while(choice != 3)
		{
			
			// menu
			System.out.println("1 - List entries");
			System.out.println("2 - Add entry");
			System.out.println("3 - Exit\n");
			System.out.print("Enter Menu Number: ");
			choice = Integer.parseInt(input.nextLine());
			
			switch(choice)
			{
				case 1:
					// display list of entries
					System.out.println("\n"+AddressBookIO.getEntriesString());
					break;
				case 2:
					// take input for new entry
					System.out.print("\nEnter Name: ");
					entry.setName(input.nextLine());
					System.out.print("Enter Email Address: ");
					entry.setEmail(input.nextLine());
					System.out.print("Enter Phone Number: ");
					entry.setCellNumber(input.nextLine());
					// validate input if it's correct Save new entry otherwise display error
					if(Validator.ValidateEntity(entry) == true)
					{
						AddressBookIO.saveEntry(entry);
						System.out.println("\nThis entry has been saved.\n");
					}
					else
						System.out.println("Wrong Input. Try Again!\n");
					break;
				case 3:
					// Exit
					choice = 3;
					System.out.print("\nGood bye.");
					break;
				default:
					// User Choice can be validated here
					System.out.println("Wrong Input. Try Again!\n");
			}
		}
		input.close();
	}
}

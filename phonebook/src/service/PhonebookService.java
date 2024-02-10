package service;

// Calling dao(data access object) package in PhonebookService class.
import dao.PhonebookDetails;

public class PhonebookService
{
	public int insertService(String contctName, String gender, String phoneNo)
	{
		//creating The object of PhonebookDetails in PhonebookService.
		PhonebookDetails pd = new PhonebookDetails();
		
		//gender to convert uppercase
		String gen = gender.toUpperCase();
		
		//contacting 0 as preceding to phoneNo
		String phno = "0"+phoneNo;
		
		//Calling the PhonebookDetails Method in PhonebookService.
		int insertRecord = pd.insertData(contctName, gen, phno);
		return insertRecord;
	}
}
// Creating Our Own Package.
package service;

//Calling Dao Package In  the SearchPhoneNoService class
import dao.SearchPhonebookDao;
import java.util.*;

public class SearchPhoneNoService 
{
	// Creating SearchPhoneNoService Method.
	public List<ArrayList<String>> searchPhoneDetails(String searchPrName)
	{
		System.out.println("Calling SearchPhoneNoService class");
		
		//Calling Dao class object in the SearchPhoneNoService class.
		SearchPhonebookDao spd = new SearchPhonebookDao();
		
		//calling Dao class Method In the SearchPhoneNoService class.
		List<ArrayList<String>> allData = spd.searchData(searchPrName);
		return allData;
	}
}
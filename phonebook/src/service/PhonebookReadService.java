package service;

import dao.PhonebookReadDao;
import java.util.*;

public class PhonebookReadService
{
	public List<ArrayList<String>> readPhoneDetails()
	{
		PhonebookReadDao prd = new PhonebookReadDao();
		List<ArrayList<String>> allData = prd.readFromPhoneBook();
		return allData;
	}
}
package service;

public class SimpleInterestService
{
	public double calculateInterest(double p, double r, double t)
	{
		double si = p*r*t/100;
		return si;
	}
}
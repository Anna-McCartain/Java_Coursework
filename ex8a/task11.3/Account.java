public class Account
{


private String provider;
private int balance = 0;
private static final String NLS = System.getProperty("line.separator");

// constructor
public Account(String getProvider)
{
  provider = getProvider;

}

// method to increase balance of Account
public int balanceIncrease(int credit)
{
  balance += (credit * 100);
  return balance;
}

// method to decrease balance when call is made.
// it also determines the real duration of a call.
public int balanceDecrease(int desiredDuration)
{
  int duration = desiredDuration;

  if(duration > balance)
  {
    duration = balance;
    balance = 0;
  } //if
  else
    balance -= duration;
    
  return duration;
}


//method to print out the'construction' of the account object
public String toString()
{
  return  "provider - " 
          + provider + NLS + "balance - " 
	  + balance;
}

}

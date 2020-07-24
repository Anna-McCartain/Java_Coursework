/**
* This class represents phone accounts and provides
* certain manipulation of them.
*
* @author Anna McCartain
*/

public class Account
{


private String provider;
private int balance = 0;
private static final String NLS = System.getProperty("line.separator");

// constructor
/**
*Constructs an account, assigning it the provider name
*given in construction
*
* @param getProvider The specified provider.
*/

public Account(String getProvider)
{
  provider = getProvider;

}

// method to increase balance of Account
/**Method to update the balance of the phones account.
*this method is used in conjuction with topping up a
*phone hence only increases the balance.
*
* @param credit The input credit in pounds
*
* @return The new balance on the account
*/
public int balanceIncrease(int credit)
{
  balance += (credit * 100);
  return balance;
}

// method to decrease balance when call is made.
// it also determines the real duration of a call.
// method to increase balance of Account
/**Method to update the balance of the phones account.
*this method is used in conjuction with making calls
* hence only decreases the balance. The duration is 
* capped at the maximum balance of account
*
* @param desiredDuration The duration intended for the call
*
* @return The actual duration that occured when balance is factored in.
*/
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
/**
* Provides the provider/balance represntation of the account
*
* @return A string representation of account
*/ 
public String toString()
{
  return  "provider - " 
          + provider + NLS + "balance - " 
	  + balance;
}

}

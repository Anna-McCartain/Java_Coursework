public class Phone
{
  private String name;
  private int totalDuration = 0;
  private Account currentAccount = null;
  private static final String NLS = System.getProperty("line.separator");

  //constructor
  public Phone(String newName)
  {
    name = newName;
  }


//three methods to assist in buy phone method
  public String getName()
  {
    return name;
  }

  public int getTotalDuration()
  {
    return totalDuration;
  }

  public Account getCurrentAccount()
  {
 
    return currentAccount;
  }
  
  //method to assign account when phone is purchased
  public void buyAccount(Account newAccount)
  {
   currentAccount = newAccount;
   
  }

  //method to make a call it takes the requested duration and returns
  //the actual duration, then adds this to totalDuration
  public void makeCall(int inputDuration)
  {
    totalDuration += currentAccount.balanceDecrease(inputDuration);
   
  }

  //method to top up a phone with credit
  public void topUp(int inputCredit)
  {
    currentAccount.balanceIncrease(inputCredit);
  }

  //method to give a string representation of object Phone
  public String toString()
  {
    return  "Name - " + name + NLS
            + "Total Call Duration - " + totalDuration + NLS
	    + "Account - " + currentAccount;
  }

}

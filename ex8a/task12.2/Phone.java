/**
* This class represents phone objects and provides
* certain manipulation of them.
*
* @author Anna McCartain
*/

public class Phone
{
  private String name;
  private int totalDuration = 0;
  private Account currentAccount = null;
  private static final String NLS = System.getProperty("line.separator");

  //constructor
/**
*Constructs a phone, assigning it a brand name
*given in construction
*
* @param newName The specified brand
*/
  public Phone(String newName)
  {
    name = newName;
  }
  
  
  //method to assign account when phone is purchased
/**Method to assign a particular student who has a phone
*with a particular account provider
*
* @param newAccount the account specifed in calling
*/
  public void buyAccount(Account newAccount)
  {
   currentAccount = newAccount;
   
  }

  //method to make a call it takes the requested duration and returns
  //the actual duration, then adds this to totalDuration
/**Method that makes a call from phone. It updates the total
*duration and balance with the actual duration of call once balance
*is taken into account.
*
* @param inputDuration the desired duration the student would like
*/
  public void makeCall(int inputDuration)
  {
    totalDuration += currentAccount.balanceDecrease(inputDuration);
   
  }
/**Method that increases balcance on account when credit is inputed
*
* @param inputCredit the actual credit value added onto balance
*/
  //method to top up a phone with credit
  public void topUp(int inputCredit)
  {
    currentAccount.balanceIncrease(inputCredit);
  }

  //method to give a string representation of object Phone
/*provides the total call duration/account representation of phone
*
* @return A string represntation of phone
*/
  public String toString()
  {
    return  "Name - " + name + NLS
            + "Total Call Duration - " + totalDuration + NLS
	    + "Account - " + currentAccount;
  }

}

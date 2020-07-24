//student class is template for creating a student.
//ech student has a name and a phone Status

public class Student
{
  private final String name;
  private Phone phone = null;
  private static final String NLS = System.getProperty("line.separator");

//constructor
  public Student(String getName)
  {
    name = getName;
   
  }

//method to buy a phone
  public Phone buyPhone(Phone newPhone, Account account)
  {
    phone = newPhone;
    phone.buyAccount(account);
    
    return phone;
  }
 

//method to try and make a call only if phone status != null
  public void tryToCall(int inputDuration)
  {
  if (phone == null)
  return;

  phone.makeCall(inputDuration);
  }


//method to add credit to phone only if phone status != null
  public void tryToTopUp(int inputCredit)
  {
    if (phone == null)
    return;

    phone.topUp(inputCredit);
  }

//string representation
  public String toString()
  {
    return "Student:" + NLS 
            + "Name - " + name + NLS
	    + "Phone: " + phone;
  }

} //class

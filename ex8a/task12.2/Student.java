//student class is template for creating a student.
//ech student has a name and a phone Status


/**
* This class represents student objects and provides
* certain manipulation of them.
*
* @author Anna McCartain
*/

public class Student
{
  private final String name;
  private Phone phone = null;
  private static final String NLS = System.getProperty("line.separator");

//constructor
/**Cpnstructs a student, assigning them a name
*given in contruction
*
* @param getName The specifed name
*/
  public Student(String getName)
  {
    name = getName;
   
  }

//method to buy a phone
/** assigns a student with a particular phone
*
* @param newPhone the phone specified in calling
*
* @param account the account specified in calling that 
*will be assigned to the particular phone in phone class
*
* @return the new phone stats etc
*/
  public Phone buyPhone(Phone newPhone, Account account)
  {
    phone = newPhone;
    phone.buyAccount(account);
    
    return phone;
  }
 

//method to try and make a call only if phone status != null
/**Method to see if makeCall should be implemented - it depends 
*on if student posseses a phone
*
* @param inputDuration the desired duration used if makeCall is called
*/
  public void tryToCall(int inputDuration)
  {
  if (phone == null)
  return;

  phone.makeCall(inputDuration);
  }


//method to add credit to phone only if phone status != null
/**Method to see if topUp should be implemented - it depends
*on if the student posseses a phone
*
* @param inputCredit the actual credit used if topUp is called
*/

  public void tryToTopUp(int inputCredit)
  {
    if (phone == null)
    return;

    phone.topUp(inputCredit);
  }

//string representation
/**provides the name/phone represntation of student
*
* @return A string representation of student
*/
  public String toString()
  {
    return "Student:" + NLS 
            + "Name - " + name + NLS
	    + "Phone: " + phone;
  }

} //class

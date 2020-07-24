/* This programme demonstrates the model of students using their mobile phone.
It creates some students, phone makes, and account makes. The students can buy
a phone, the top it up with credit to make calls - each second costing 1p. Credit
is brought in whole pounds, but stored on the account balance in pennies. If
a student wants to make a call that their credit score cannot cover, the call
duration runs until credit = 0. If a student does not have a phone, a request to
make call or top up will be ignored, if a student buys a second phone, the 1st
is discarded. */

public class StudentsCalling
{

private static final String NLS = System.getProperty("line.separator");

//first helper method is to print out the buy phone method
private static void printBuyPhone(Student student, Phone phone, Account account)
{
  System.out.println(student);
  System.out.println("decides to buy the phone " + NLS + phone);
  System.out.println("and account provider " + NLS + account);
  student.buyPhone(phone, account);
  System.out.println("Result: " + NLS + student);
  System.out.println();
}
//second helper method to print out the make call method
private static void printMakeCall(Student student, Phone phone, 
                                  Account account, int inputDuration)
{
  
  System.out.println(student);
  System.out.println("Wants to make call of " + NLS + inputDuration + " seconds.");
  student.tryToCall(inputDuration);
  System.out.println("Return: " + NLS + student);
  System.out.println();
}

//third helper method to print out the top up method
private static void printTopUp(Student student, Phone phone, 
                               Account account, int inputCredit)
{
  
  System.out.println(student);
  System.out.println("Wants to top up their phone with " + NLS + inputCredit + " Quid.");
  student.tryToTopUp(inputCredit);
  System.out.println("Return: " + NLS + student);
  System.out.println();
}

//main method tells a story highlighting all the features of the programme.
public static void main(String[] args)
{

//create students
  System.out.println("Students:");
  Student student1 = new Student("Anna McCartain");
  System.out.println(student1);

  Student student2 = new Student ("Annie Fitzmaurice");
  System.out.println(student2);

  Student student3 = new Student ("Lydia Xie");
  System.out.println(student3);
  System.out.println();

//create phone makes
  System.out.println("Phone Makes:");
  Phone phone1 = new Phone ("Iphone");
  System.out.println(phone1);

  Phone phone2 = new Phone ("Samsung");
  System.out.println(phone2);

  Phone phone3 = new Phone ("Huawei");
  System.out.println(phone3);
  System.out.println();

//create some accounts
  System.out.println("Account Providers:");
  Account account1 = new Account ("EE");
  System.out.println(account1);

  Account account2 = new Account ("O2");
  System.out.println(account2);
  System.out.println();

//buying initial phones
  System.out.println("Initial Purchase:");
  System.out.println();
  printBuyPhone(student1, phone1, account1);
  printBuyPhone(student2, phone2, account2);

//Topping up with Credit
  System.out.println("Credit Top Ups:");
  System.out.println();
  printTopUp(student1, phone1, account1, 10);
  printTopUp(student2, phone2, account2, 5);
  printTopUp(student3, phone3, account2, 20);


//Making calls
  System.out.println("Make Calls:");
  System.out.println();
  printMakeCall(student1, phone1, account1, 300);
  printMakeCall(student2, phone2, account2, 100);
  printMakeCall(student3, phone3, account2, 1500);
  printMakeCall(student1, phone1, account1, 600);
  printMakeCall(student2, phone2, account2, 400);
  printMakeCall(student1, phone1, account1, 200);
  printMakeCall(student2, phone2, account2, 500);

//Switch phone
  System.out.println("Change Phones:");
  System.out.println();
  printBuyPhone(student1, phone3, account2);

//More Credit
  System.out.println("Credit Top Ups:");
  System.out.println();
  printTopUp(student1, phone3, account2, 15);

//Making calls
  System.out.println("Make Calls:");
  System.out.println();
  printMakeCall(student1, phone3, account2, 500);

  } //main
} //class

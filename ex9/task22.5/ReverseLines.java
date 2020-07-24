import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

//this programme takes liens from input and reverses them

public class ReverseLines
{

  
  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    
    try
    {

      input = new BufferedReader(new InputStreamReader(System.in));
      output =  new PrintWriter(System.out, true);

      recursiveMethod(input, output);

    } //try 

    
      catch (Exception exception)
    {
      System.out.println(exception.getMessage());
    } //catch
  } //main 

  private static void recursiveMethod(BufferedReader input, PrintWriter output) throws Exception
  {
   String head;
    try
    {
    if((head = input.readLine()) != null)
    {
      recursiveMethod(input, output);
      output.println(head);
    } //if
   } //try
   
   catch (IOException exception)
   {
     System.out.println(exception.getMessage());
   } //catch
   
  } //recursiveMethod
} //class


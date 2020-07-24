import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

//programme that adds a line number to each line in a file
//produces the result in new file. files given as comman line arg
//no file given standard input output used

public class DeleteField
{

  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    try
    {
      //check if files of standard i/o will be used
      if(args.length > 3)
        throw new DeleteFieldException("Too Many Arguments");

      //check if input is a dash if it is use input/output not files
      if(args.length < 2 || args[1].equals("-"))
        input = new BufferedReader(new InputStreamReader(System.in));
      else
        input = new BufferedReader(new FileReader(args[1]));

      if(args.length < 3 || args[2].equals("-"))
        output =  new PrintWriter(System.out, true);
      else
      {
        if (new File(args[2]).exists())
          throw new DeleteFieldException("Output file" + args[2]
                                                       + " already exists");

        output = new PrintWriter(new FileWriter(args[2]));
      }

      //Now copy input to output adding line numbers

      String inputLine;
      int deleteFieldNumber = Integer.parseInt(args[0]);

      while ((inputLine = input.readLine()) != null)
      {


        // Divide the line into fields using tab as a delimiter.
        String[] fields = inputLine.split("\t");
        String editedLine = "";


        if (fields.length < deleteFieldNumber)
           editedLine = inputLine;

        else
        {
        // We build the new line in parts.
        // Add the fields before the one to be deleted.
          for (int index = 0; index < deleteFieldNumber - 1; index++)
            {  if (editedLine.equals(""))
                editedLine = fields[index];
              else
                editedLine += "\t" + fields[index];
            }
        // Add the fields after the one to be deleted.
          for (int index = deleteFieldNumber; index < fields.length; index++)
            {

              if (editedLine.equals(""))
                editedLine = fields[index];
              else
                editedLine += "\t" + fields[index];
            }
         } // else

     output.print(editedLine + "\n");
     } //while
   } //try

    catch (DeleteFieldException exception)
    {
      System.out.println(exception.getMessage());
    }

    catch (IOException exception)
    {
      System.err.println(exception);
    }
    finally
    {
      try { if (input != null) input.close(); }
      catch (IOException exception)
      {
          System.err.println("Could not close input " + exception);
      }
      if (output != null)
      {
        output.close();
        if (output.checkError())
          System.err.println("Something went wrong");
      }
     }
    }
  }

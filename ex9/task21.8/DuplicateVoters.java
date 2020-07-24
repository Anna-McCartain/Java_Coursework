//class that takes an input file of voters and checks how many multiple votes 
//were made it will print the duplicates along with the total number of them

import java.util.HashSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List; 

public class DuplicateVoters
{

  public static void main(String[] args)
  {
    BufferedReader input = null;
    PrintWriter output = null;
    
    try
    {
      //check if files of standard i/o will be used
      if(args.length != 2)
        throw new DuplicateVotersException("Supply 2 arguments");

	      input = new BufferedReader(new FileReader(args[0]));

       	if (new File(args[1]).exists())
          throw new DuplicateVotersException("Output file" + args[1]
                                                       + " already exists");

        output = new PrintWriter(new FileWriter(args[1]));
        
//make an ArrayList to store all lines 
       List<String> allLines = new ArrayList<String>();
       
//make HashMap
        Map<String, String> voters = new HashMap<String, String>();
        
        String currentLine;
        int    duplicateCount = 0;
        
//add all lines to list
        while((currentLine = input.readLine()) != null)
           allLines.add(currentLine);

//get each line where the id is stated check if already has a vote linked with
//it. if yes print out duplicate format and add one to count. if not put into
//hash map.
        for(int index = 0; index < allLines.size(); index += 2)
        {
          String id = allLines.get(index);

          if(voters.get(id) != null)
          {
            output.println(id);
            output.println("      duplicate: " + allLines.get(index + 1));
            output.println("      first: " + voters.get(id));
            duplicateCount++;
          }
          else
            voters.put(id, allLines.get(index + 1));
        } //for

        output.println("There were " + duplicateCount + " duplicate votes");
    } //try 

    
      catch (DuplicateVotersException exception)
    {
      System.out.println(exception.getMessage());
    } //catch

    catch (IOException exception)
    {
      System.err.println(exception);
    } //catch
    
    finally
    {
      try { if (input != null) input.close(); }
      catch (IOException exception)
      {
          System.err.println("Could not close input " + exception);
      } //catch
      if (output != null)
      {
       	output.close();
        if (output.checkError())
          System.err.println("Something went wrong");
      } //if
    } //finally
  } //main 
} //class

 

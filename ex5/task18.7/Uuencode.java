import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Uuencode
{

// Write a single result byte as a printable character.
// Each byte is 6-bit, i.e. range 0..63.
// Thus adding 32 makes it printable, except for 0 which would become space
// and so we add 96 instead -- a left single quote (‘).
 private static void writeByteAsChar(int thisByte)
 {
   System.out.print((char) (thisByte == 0 ? 96 : thisByte + 32));
 } // writeByteAsChar


public static void main(String[] args)
{
  FileInputStream input = null;
  int arrayPlace = 0;

  try
  {
    if(args.length > 1 || args.length < 1)
      throw new UuencodeException("Only One Argument Allowed");

    input = new FileInputStream(args[0]);

    //header
    System.out.println("begin 600 " + args[0]);
    //make array
    char[] bytesForOneLine = new char[45];
    //get first byte of file
    int getByte = input.read();

    while(getByte != -1)
    {
      while(getByte != -1 && arrayPlace < 45)
      {
        //thie loop puts each char into the array one by one untill full
        bytesForOneLine[arrayPlace] = (char) getByte;
        arrayPlace++;
        getByte = input.read();
      } //while

      //output the number of bytes on this line
      writeByteAsChar(arrayPlace);

      //make new variable from given code to make the index increase by
      //three (bytes) each loop.
      int byteGroupIndex = 0;

      while(byteGroupIndex < arrayPlace)
      {
        
        // Calculate 4 result bytes from the 3 input bytes.
         int byte1 = bytesForOneLine[byteGroupIndex] >> 2;
         int byte2 = (bytesForOneLine[byteGroupIndex] & 0x3) << 4
                          | (bytesForOneLine[byteGroupIndex + 1] >> 4);
         int byte3 = (bytesForOneLine[byteGroupIndex + 1] & 0xf) << 2
                          | bytesForOneLine[byteGroupIndex + 2] >> 6;
         int byte4 = bytesForOneLine[byteGroupIndex + 2] & 0x3f;

        // Now write those result bytes.
         writeByteAsChar(byte1);
         writeByteAsChar(byte2);
         writeByteAsChar(byte3);
         writeByteAsChar(byte4);

        //add 3 to the byte group index so next time it changes byte 3 4 5 etc
        byteGroupIndex += 3;
	
	
	
      } //while

      System.out.print("\n");
      //reset the array incase you are at the end and get overwritten jumble
      //of half arrays. (big mess) also reset counter
      for(int index = 0; index < arrayPlace; index++)
        bytesForOneLine[index] = 0;
	
      arrayPlace = 0;


    } //while

      //output a trailer line
      System.out.println("`");
      System.out.println("end");
  } //try

  catch (UuencodeException exception)
  {
    System.out.println(exception.getMessage());
  } //catch

  catch (FileNotFoundException exception)
  {
    System.err.println("Could not find file specified" + exception);
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
   } //finally
 } //main
} //class

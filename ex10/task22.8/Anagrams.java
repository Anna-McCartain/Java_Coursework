public class Anagrams
{
  private static char[] charArray;
  private static char[] permArray;
  private static boolean[] booleanArray;
  public static void main(String[] args) throws RuntimeException
  {

//make three arrays one to take the input, one to build current perumation
//one to record whether characters from string have been used in the permutation
    String input = args[0];
    charArray = input.toCharArray();

    permArray = new char[charArray.length];
    booleanArray = new boolean[charArray.length];

//call method
    printPermutations(0);

  }



  public static void printPermutations(int currentIndex)
  {

//if current index has gone past end of permutation array print it out
    if(currentIndex == permArray.length)
      System.out.println(permArray);
    else
    {
//for each index in the char array made from string, if the char at that index
//is not already used in perm mark it as being used put that char in the perm
//at current index and call method again at 1 = current index. set back to false
      for(int index = 0; index < charArray.length; index++)
      {
        if(booleanArray[index] == false)
        {
          booleanArray[index] = true;
          permArray[currentIndex] = charArray[index];
          printPermutations(currentIndex + 1);
          booleanArray[index] = false;
        } //if
      } //for
    } //else
  } //printPermutations
} //class

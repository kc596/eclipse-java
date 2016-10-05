package random;


public class Solution
{
    public static void main(String args[])
    {
    	System.out.println(stripEnd("nal", "kunal"));
    }
    public static String stripEnd(final String str, final String stripChars) 
    {
        if (str == null)
            return str;

        int end =  str.length();
        int INDEX_NOT_FOUND = -1;

        if(end == 0)
            return str;

        else if (stripChars.isEmpty()) 
        {
            return str;
        } 
        else 
        {
            // *********************
            // What's the code here?
            // *********************
        	while (end != 0 && str.indexOf(stripChars.charAt(end - 1)) != INDEX_NOT_FOUND) 
        	{
        	    end--;
        	}
        }

        return str.substring(0, end);
    }
}
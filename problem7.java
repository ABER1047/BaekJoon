import java.util.*;

public class problem7 
{
    public static void main(String[] args)
    {
    Scanner sc = new Scanner(System.in);
    char alphabet[] = new char[26], returned_char;
    double highest = 0;
    
        while(sc.hasNextLine())
        {
        String str = sc.nextLine();
            for(int i = 0; i < str.length(); i++)
            {
            returned_char = str.charAt(i);
                if (returned_char != ' ')
                {
                int __i = (int) returned_char;
                alphabet[__i-97]++;
                }
            }
            
            for(int i = 0; i < 26; i++)
            {
                if (highest < alphabet[i])
                {
                highest = alphabet[i];
                }
            }
        }
    System.out.print((char) 97+highest);
    }
}

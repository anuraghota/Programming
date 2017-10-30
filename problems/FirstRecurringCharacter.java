import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter
{
    public static void main(String args[])
    {
        String text = "ABC";
        System.out.println(getFirstRecurringCharacter(text));
    }

    public static Character getFirstRecurringCharacter(String string)
    {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++)
        {
            if(map.containsKey(string.charAt(i)))
            {
                return string.charAt(i);
            }
            else
            {
                map.put(string.charAt(i),1);
            }
        }
        return null;
    }
}

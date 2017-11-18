import java.util.Map;
import java.util.TreeMap;

public class StringPermutation
{
    public static void main(String args[])
    {
        char string[] = {'A','A','B','C'};
        permute(string);
    }

    public static void permute(char string[])
    {
        TreeMap<Character,Integer> map = new TreeMap<>();
        for(char s : string)
        {
            map.compute(s,(key,value)->
            {
               if(value != null)
               {
                   return value + 1;
               }
               return 1;
            });
        }


        char input[] = new char[map.size()];
        int count[] = new int[map.size()];

        int index = 0;
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            input[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }

        char result[] = new char[string.length];
        permuteUtil(input,count,result,0);
    }

    public static void permuteUtil(char input[], int count[], char result[], int level)
    {
        if(level == result.length)
        {
            printPermutation(result);
            return;
        }

        for(int i = 0; i < input.length; i++)
        {
            if(count[i] == 0)
            {
                continue;
            }
            else
            {
                result[level] = input[i];
                count[i]--;
                permuteUtil(input,count,result,level+1);
                count[i]++;
            }
        }
    }

    public static void printPermutation(char result[])
    {
        for(char s : result)
        {
            System.out.printf("%c",s);
        }
        System.out.println();
    }
}

import java.util.Map;
import java.util.TreeMap;

public class StringCombination
{
    public static void main(String args[])
    {
        char string[] = {'A','A','B','C'};
        combine(string);
    }

    public static void combine(char string[])
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
        combineUtil(input,count,result,0,0);
    }

    public static void combineUtil(char input[], int count[], char result[],int position, int length)
    {

        printCombination(result, length);

        for(int i = position ; i < input.length; i++)
        {
            if(count[i] == 0)
            {
                continue;
            }
            else
            {
                result[length] = input[i];
                count[i]--;
                combineUtil(input,count,result,i,length+1);
                count[i]++;
            }
        }
    }

    public static void printCombination(char result[], int length)
    {
        for(int i = 0; i < length; i++)
        {
            System.out.printf("%c ",result[i]);
        }
        System.out.println();
    }
}

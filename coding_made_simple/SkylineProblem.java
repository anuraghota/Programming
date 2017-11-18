import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SkylineProblem
{
    public static void main(String args[])
    {
        int buildings[][] = {{1,3,4},{3,4,4},{2,6,2},{8,11,4},{7,9,3},{10,11,2}};
        List<int[]> result = getSkyline(buildings);
        for(int[] point : result)
        {
            System.out.printf("%s : %s\n",point[0],point[1]);
        }
    }

    static class BuildingPoint implements Comparable<BuildingPoint>
    {
        int x;
        boolean isStart;
        int height;

        @Override
        public int compareTo(BuildingPoint o)
        {
            if(this.x != o.x )
            {
                return this.x - o.x;
            }
            else
            {
                if(this.isStart && o.isStart)
                {
                    return o.height - this.height;
                }
                else if(!this.isStart && !o.isStart)
                {
                    return this.height - o.height;
                }
                else
                {
                    return -1;
                }
            }
        }
    }


    public static List<int[]> getSkyline(int[][] buildings)
    {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for(int building[] : buildings)
        {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].isStart = true;
            buildingPoints[index].x = building[0];
            buildingPoints[index].height = building[2];

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].isStart = false;
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].height = building[2];

            index = index + 2;
        }

        Arrays.sort(buildingPoints);
        List<int[]> result = new ArrayList<>();
        TreeMap<Integer,Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight = 0;

        for(BuildingPoint buildingPoint : buildingPoints)
        {
            if(buildingPoint.isStart)
            {
                queue.compute(buildingPoint.height,(key,value) ->
                {
                    if(value != null)
                    {
                        return value + 1;
                    }
                    return 1;
                }
                );
            }
            else
            {
                queue.compute(buildingPoint.height,(key,value) ->
                {
                    if(value == 1)
                    {
                        return null;
                    }
                    return value - 1;
                }
                );
            }

            int currentMaxHeight = queue.lastKey();
            if(currentMaxHeight != prevMaxHeight)
            {
                result.add(new int[]{buildingPoint.x,currentMaxHeight});
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;

    }



}

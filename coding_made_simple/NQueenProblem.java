public class NQueenProblem
{
    static class Position
    {
        int row;
        int col;
        Position(int row,int col)
        {
            this.row = row;
            this.col = col;
        }
    }

    public static Position[] solveNQueen(int n)
    {
        Position positions[] = new Position[n];
        boolean hasSolution = solveNQueenUtil(n,0,positions);
        if(hasSolution)
        {
            return positions;
        }
        else
        {
            return null;
        }

    }

    public static boolean solveNQueenUtil(int n, int row, Position[] positions)
    {
        if(n == row)
        {
            return true;
        }
        int col;
        for(col = 0; col < n; col++)
        {
            boolean foundSafe = true;

            for(int queen = 0; queen < row; queen++)
            {
                if(positions[queen].col == col || positions[queen].row - positions[queen].col == row-col || positions[queen].row + positions[queen].col == row+col)
                {
                    foundSafe = false;
                    break;
                }
            }
            if(foundSafe)
            {
                positions[row] = new Position(row,col);
                if(solveNQueenUtil(n,row+1, positions))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        Position positions[] = solveNQueen(4);
        if(positions != null)
        {
            for(Position position : positions)
            {
                System.out.printf("(%d,%d)\n",position.row,position.col);
            }
        }
        else
        {
            System.out.printf("No solution!");
        }
    }
}

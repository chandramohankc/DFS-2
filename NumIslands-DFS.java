class Solution {
    int[][]dirs; int m; int n;
    public int numIslands(char[][] grid) {
        
        if (null == grid || grid.length == 0) return 0;
        m = grid.length; // m rows
        n = grid[0].length; //n cols
        int count = 0;
        
        dirs = new int[][] {{0,1}, {0,-1}, {1,0}, {-1,0} };
        Queue<int[]> q = new LinkedList<>();
        
        for (int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
                
            }
        }
       return count;
        
    }
    
    
    public void dfs(char[][] grid, int i, int j){
        

        //base
        if (i < 0 || j < 0 || i == m || j == n || grid[i][j] != '1') return;
        
        //logic
        System.out.println ("i "+i+ ", j: " +j);
        grid[i][j] = '0';
        for (int[] dir : dirs) {
            System.out.println ("Dir[0]:" +dir[0]+", dir[1]: "+dir[1]);
            int r  = i + dir[0];
            int c  = j + dir[1];
            dfs(grid, r,c);
        }
        
    }
}

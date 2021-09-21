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
                   grid[i][j] = 0;
                   q.add (new int[] {i,j});
                    
                   while (!q.isEmpty()){
                       int[] curr = q.poll();
                       
                       for (int[] dir: dirs) {
                           int r = dir[0] + curr[0];
                           int c = dir[1] + curr[1];
                           
                           if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == '1'){
                               grid[r][c] = 0;
                               q.add(new int[] {r,c});
                               
                           }
                       }
                       
                   }
                }
                
            }
        }
       return count;
    
     
    }
}

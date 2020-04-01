class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return 0;
        }
        
        int m=matrix.length;
        int n=matrix[0].length;
        int max=0;
        
        int[][] sides=new int[m][n];
        
        for(int i=0;i<m;i++){
            if(matrix[i][0]=='0'){
                sides[i][0]=0;
            }else{
                sides[i][0]=1;
            }
            max=Math.max(max,sides[i][0]);
        }
        
        for(int j=0;j<n;j++){
            if(matrix[0][j]=='0'){
                sides[0][j]=0;
            }else{
                sides[0][j]=1;
            }
            max=Math.max(max,sides[0][j]);
        }
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    sides[i][j]=Math.min(Math.min(sides[i-1][j],sides[i][j-1]),sides[i-1][j-1])+1;
                    max=Math.max(max,sides[i][j]);
                }
            }
        }
        
        return max*max;
        
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if( matrix.length == 0 || matrix == null || matrix[0] == null || matrix[0].length == 0){
            return res;
        }
        int rowBegin = 0;
        int rowEnd = matrix.length - 1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int i = colBegin; i <= colEnd; i++){
                res.add(matrix[rowBegin][i]);
            }
            rowBegin++;
            for(int i = rowBegin; i <= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){       //should confirm rowBegin <= rowEnd
                for(int i = colEnd; i >= colBegin; i--){
                    res.add(matrix[rowEnd][i]);
                }
                
            }
            rowEnd--;
            if(colBegin <= colEnd){
                for(int i = rowEnd; i >= rowBegin; i--){
                    res.add(matrix[i][colBegin]);
                }
                
            }
            colBegin++;
        }
        return res;
    }
}



//Fail Solution
class FailSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if( matrix.length == 0 || matrix == null || matrix[0] == null || matrix[0].length == 0){
            return res;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        System.out.println("n = " + n + "m = " + m);
        if( n == 1 ){
            return  IntStream.of(matrix[0]).boxed().collect(Collectors.toList());
        }
        if( m == 1){
            for(int i = 0; i < n; i++){
                res.add(matrix[i][0]);
            }
            return res;
        }
        int rowBegin = 0, rowEnd = n - 1;
        int colBegin = 0, colEnd = m - 1;
        while(true){
            int row = rowBegin, col = colBegin;
            
            if(row == rowBegin && col == colBegin){
                while(col < colEnd){
                res.add(matrix[row][col]);
                col++;
            }
            }
            if(row == rowBegin && col == colEnd){
                while(row < rowEnd){
                    res.add(matrix[row][col]);
                    row++;
                }
            }
            if(row == rowEnd && col == colEnd){  //when rowBegin == rowEnd && colBegin < colEnd, [[1,2,3]],  at point 3 it will traceback and get wrong
                while(col > colBegin){
                    res.add(matrix[row][col]);
                    col--;
                }
            }
            if(row == rowEnd && col == colBegin){
                while(row > rowBegin){
                    res.add(matrix[row][col]);
                    row--;
                }
            }
            if(rowBegin == rowEnd && colBegin == colEnd){
                res.add(matrix[rowBegin][colBegin]);
            }
            rowBegin++;
            rowEnd--;
            colBegin++;
            colEnd--;
            if(rowBegin > rowEnd || colBegin > colEnd) return res;
    }
}
}
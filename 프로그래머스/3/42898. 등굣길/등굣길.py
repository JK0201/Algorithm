def solution(col, row, puddles):
    grid = [[0] * col for _ in range(row)]
    
    for p in puddles:
        grid[p[1]-1][p[0]-1] = 1
        
    memo = {}
    def dp(r, c):
        if r == 0 and c == 0:
            memo[(r, c)] = 1
            return memo[(r, c)]
        
        if (r, c) not in memo:
            paths = 0
            if r > 0 and grid[r-1][c] != 1:
                paths += dp(r-1, c)
                
            if c > 0 and grid[r][c-1] != 1:
                paths += dp(r, c-1)
            
            memo[(r, c)] = paths
            
        return memo[(r, c)]
    
    res = dp(row-1, col-1)
    return res % 1000000007
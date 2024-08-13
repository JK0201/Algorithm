def solution(triangle):
    memo = {}
    def dp(r, c):
        if r == 0:
            memo[(r, c)] = triangle[r][c]
            return memo[(r, c)]
        
        if (r, c) not in memo:
            if c == 0:
                memo[(r, c)] = triangle[r][c] + dp(r-1, c)

            elif c == len(triangle[r]) - 1:
                memo[(r, c)] = triangle[r][c] + dp(r-1, c-1)

            else:
                memo[(r, c)] = triangle[r][c] + max(dp(r-1, c-1), dp(r-1, c))
            
        return memo[(r, c)]
    
    return max(dp(len(triangle)-1, c) for c in range(len(triangle[-1])))
def solution(triangle):
    memo = {(0, 0) : triangle[0][0]}
    
    for r in range(1, len(triangle)):
        for c in range(len(triangle[r])):
            if c == 0:
                memo[(r, c)] = triangle[r][c] + memo[(r-1, c)]
            
            elif c == len(triangle[r]) - 1:
                memo[(r, c)] = triangle[r][c] + memo[(r-1, c-1)]
            
            else:
                memo[(r, c)] = triangle[r][c] + max(memo[(r-1, c-1)], memo[(r-1, c)])
                
    return max(memo.values())
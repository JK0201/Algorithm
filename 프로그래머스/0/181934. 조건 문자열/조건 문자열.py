def solution(ineq, eq, n, m):
    operator = ineq + eq
    
    if operator == '<=' and n <= m:
        return 1
        
    elif operator == '>=' and n >= m:
        return 1
    
    elif operator == '<!' and n < m:
        return 1
        
    elif operator == '>!' and n > m:
        return 1
    
    else:
        return 0
def solution(a, b):
    n = int(str(a) + str(b))
    m = int(str(b) + str(a))
    
    if n > m:
        return n
    
    elif n < m:
        return m 
        
    elif n == m:
        return n
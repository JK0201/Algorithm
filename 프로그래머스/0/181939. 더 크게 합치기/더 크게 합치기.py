def solution(a, b):
    n = int(str(a) + str(b))
    m = int(str(b) + str(a))
    
    return max(n, m)
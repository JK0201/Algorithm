def solution(m, n):
    if m[:len(n)] != n:
        return 0
    
    return 1
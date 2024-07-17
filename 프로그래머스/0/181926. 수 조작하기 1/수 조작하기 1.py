def solution(n, control):
    answer = n
    
    dict = {
        'w' : 1,
        's' : -1,
        'd' : 10,
        'a' : -10
    }
    
    for c in control:
        answer += dict[c]
    
    return answer
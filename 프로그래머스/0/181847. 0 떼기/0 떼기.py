def solution(n_str):
    answer = ''
    not_zero = False
    
    for s in n_str:
        if s != "0":
            not_zero = True
        
        if not_zero:
            answer += s
        
    return answer
def solution(q, r, code):
    answer = ''
    str = [s for s in code]
    
    for i in range(len(str)):
        if i % q == r:
            answer += str[i]
    
    return answer
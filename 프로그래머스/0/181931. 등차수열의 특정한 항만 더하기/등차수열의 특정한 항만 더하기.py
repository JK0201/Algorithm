def solution(a, d, included):
    answer = 0
    
    for i in range(len(included)):
        num = a + d * i
        
        if included[i] :
            answer += num
    
    return answer
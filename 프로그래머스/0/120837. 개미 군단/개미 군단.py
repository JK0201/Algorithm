def solution(hp):
    answer = 0
    remain = 0
    
    answer += hp // 5
    remain = hp % 5
    
    answer += remain // 3
    answer += remain % 3
    
    return answer
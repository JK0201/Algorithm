def solution(num_list):
    answer = 0
    length = len(num_list)
    
    if length <= 10:
        answer += 1
    
    for i in num_list:
        if length >= 11:
            answer += i
            
        elif length <= 10:
            answer *= i
            
    return answer
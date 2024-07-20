def solution(num_list):
    answer = 0
    i = 0
    
    while i < len(num_list):  
        if num_list[i] == 1:
            i += 1
            
        elif num_list[i] % 2 == 0:
            num_list[i] /= 2
            answer += 1
            
        elif num_list[i] % 2 != 0:
            num_list[i] = (num_list[i] - 1) / 2
            answer += 1
    
    return answer
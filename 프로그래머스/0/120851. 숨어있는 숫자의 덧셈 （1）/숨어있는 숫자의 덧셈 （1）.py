def solution(my_string):
    answer = 0
    
    
    for s in my_string:
        if s in [str(i) for i in range(1, 10)]:
            answer += int(s)
       
    
    return answer
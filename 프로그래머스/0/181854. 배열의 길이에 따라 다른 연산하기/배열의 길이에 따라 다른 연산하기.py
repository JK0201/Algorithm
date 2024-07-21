def solution(arr, num):
    answer = []
    
    for i, n in enumerate(arr):
        if len(arr) % 2 != 0 and i % 2 == 0:
            answer.append(n + num)
        
        elif len(arr) % 2 == 0 and i % 2 != 0:
            answer.append(n + num)
                
        else:
            answer.append(n)
            
    return answer
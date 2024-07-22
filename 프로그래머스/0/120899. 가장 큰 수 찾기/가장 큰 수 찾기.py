def solution(array):
    answer = []
    max_num = max(array)
    print(max_num)
        
    for i, a in enumerate(array):
        if a == max(array):
            answer = [a, i]
    
    return answer
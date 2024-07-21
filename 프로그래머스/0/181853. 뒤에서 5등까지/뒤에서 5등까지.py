def solution(num_list):
    answer = []
    
    num_list.sort()
    
    for i, n in enumerate(num_list):
        if i < 5:
            answer.append(n)
    
    return answer
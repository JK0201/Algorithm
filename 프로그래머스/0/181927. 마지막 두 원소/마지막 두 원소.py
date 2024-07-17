def solution(num_list):
    answer = []
    
    for n in num_list:
        answer.append(n)
    
    if answer[-2] < answer[-1]:
        answer.append(answer[-1] - answer[-2])
        
    elif answer[-2] >= answer[-1]:
        answer.append(answer[-1] * 2)
    
    print(answer)
    
    return answer
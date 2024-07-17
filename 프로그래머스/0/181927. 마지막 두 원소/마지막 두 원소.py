def solution(num_list):
    answer = num_list
    
    if answer[-2] < answer[-1]:
        answer.append(answer[-1] - answer[-2])
        
    elif answer[-2] >= answer[-1]:
        answer.append(answer[-1] * 2)

    return answer
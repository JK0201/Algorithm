def solution(my_string):
    answer = []
    
    for n in range(len(my_string)):
        answer.append(my_string[n:])
    
    return sorted(answer)
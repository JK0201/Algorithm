def solution(array, commands):
    answer = []
    
    for i, j, k in commands:
        s = sorted(array[i - 1 : j])[k - 1]
        answer.append(s)
    
    return answer
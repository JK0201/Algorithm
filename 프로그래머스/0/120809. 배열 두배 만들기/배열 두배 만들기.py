def solution(numbers):
    answer = [0] * len(numbers)
    
    for i, n in enumerate(numbers):
        answer[i] = n * 2
    
    return answer
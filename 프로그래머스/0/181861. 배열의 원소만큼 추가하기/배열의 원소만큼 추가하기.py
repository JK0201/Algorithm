def solution(arr):
    answer = []
    
    for num in arr:
        i = num
        while i > 0:
            answer.append(num)
            i -= 1
    
    return answer
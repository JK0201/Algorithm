def solution(arr, queries):
    answer = arr
    
    for i, j in queries:
        a = answer[i]
        b = answer[j]
        
        answer[i] = b
        answer[j] = a
    
    return answer
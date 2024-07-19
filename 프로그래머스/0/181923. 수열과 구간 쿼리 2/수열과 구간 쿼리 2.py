def solution(arr, queries):
    answer = []
    
    for s, e, k in queries:
        case = arr[s:e + 1]
        compare = []
        
        for i in case:
            if i > k:
                compare.append(i)
            
        if compare:
            answer.append(min(compare))
            
        else:
            answer.append(-1)
            
    return answer
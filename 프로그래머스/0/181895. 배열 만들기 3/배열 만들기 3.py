def solution(arr, intervals):
    answer = []
    
    for i in intervals:
        s, e = i
        new_arr = arr[s:e+1]
        
        for j in new_arr:
            answer.append(j)
        
    return answer
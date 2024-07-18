def solution(intStrs, k, s, l):
    answer = []
    
    for i in intStrs:
        a = int(i[s:s+l])
        if a > k:
            answer.append(a)
            
    return answer
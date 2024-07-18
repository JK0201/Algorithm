def solution(my_string):
    answer = [0] * 52
    str = [s for s in my_string]
    
    for s in str:
        idx = 0
        if s.isupper():
            idx = abs(ord('A') - ord(s))
        else:
            idx = abs(ord('A') - ord(s) + 6)
            
        answer[idx] += 1
        
    return answer
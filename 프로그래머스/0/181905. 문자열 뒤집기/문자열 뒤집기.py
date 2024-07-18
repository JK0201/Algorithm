def solution(my_string, s, e):
    answer = ''
    str = [s for s in my_string]
    
    left = s
    right = e
    
    while left < right:
        str[left], str[right] = str[right], str[left]
        left += 1
        right -= 1
        
    for s in str:
        answer += s
    
    return answer
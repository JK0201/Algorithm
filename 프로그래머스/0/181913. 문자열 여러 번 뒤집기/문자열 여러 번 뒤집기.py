def solution(my_string, queries):
    answer = ''
    str = [s for s in my_string]
    print(answer)
    
    for i, j in queries:
        left = i
        right = j
        
        while left < right:
            str[left], str[right] = str[right], str[left]
            left += 1
            right -= 1
    
    for n in str:
        answer += n
        
    return answer
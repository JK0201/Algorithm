def solution(numLog):
    answer = ''
    stack = []
    
    dict = {
        1 : 'w',
        -1 : 's',
        10 : 'd',
        -10 : 'a'
    }
    
    print(dict)
    
    for n in numLog:
        if stack and n - stack[-1] in dict:
            answer += dict[n - stack[-1]]
        stack.append(n)
        
    return answer
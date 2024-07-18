def solution(arr):
    stack = []
    
    for n in arr:
        if stack and n == stack[-1]:
            stack.pop()
            
        stack.append(n)
            
    return stack
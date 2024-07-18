def solution(str):
    stack = []
    
    for s in str:
        if s == '(':
            stack.append(')')
            
        elif not stack or s != stack[-1]:
            return False
        
        else:
            stack.pop()
            
    return not stack
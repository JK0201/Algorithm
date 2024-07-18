def solution(str):
    stack = []
    
    for s in str:
        if s == '(':
            stack.append(')')
            
        elif not stack or s != stack.pop():
            return False
            
    return not stack
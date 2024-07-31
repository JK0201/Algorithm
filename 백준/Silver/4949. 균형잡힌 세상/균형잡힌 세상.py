def chk_bracket(words):
    stack = []
    
    for w in words:
        if w == '(':
            stack.append(')')
        
        elif w == '[':
            stack.append(']')
            
        elif w == ')' or w == ']':
            if not stack or stack.pop() != w:
                return False
            
    return not stack

while True:
    words = input()
    
    if words == '.':
        break
    
    if chk_bracket(words):
        print('yes')
        
    else:
        print('no')
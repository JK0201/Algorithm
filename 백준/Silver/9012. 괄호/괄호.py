n = int(input())

def vps(ps):
    stack = []
    for p in ps:
        if p == '(':
            stack.append(')')
            
        elif not stack or stack.pop() != p:
            return False
        
    return not stack
    
for _ in range(n):
    ps = str(input())
    
    if vps(ps):
        print('YES')
    else:
        print('NO')
            
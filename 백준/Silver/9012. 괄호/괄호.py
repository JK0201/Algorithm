import sys
n = int(sys.stdin.readline())

def vps(ps):
    stack = []
    for p in ps:
        if p == '(':
            stack.append(')')
            
        elif not stack or stack.pop() != p:
            return 'NO'
        
    return 'YES' if not stack else 'NO'
    
for _ in range(n):
    ps = sys.stdin.readline().strip()
    res = vps(ps)
    print(res)
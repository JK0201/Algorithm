import sys
n = sys.stdin.readline().strip()

stack = []
for _ in range(int(n)):
    num = sys.stdin.readline().strip()
    
    if stack and num == '0':
        stack.pop()
        
    else:
        stack.append(int(num))

print(sum(stack))
import sys

n = int(input())
target = list(map(int, sys.stdin.read().split()))
stack = []
operation = []

j = 0
for i in range(n):
    stack.append(i+1)
    operation.append('+')
    
    while j < len(target) and target[j] == stack[-1]:
        stack.pop()
        operation.append('-')
        j += 1
        
        if not stack:
            break
    

if stack:
    print('NO')

else:
    for o in operation:
        print(o)
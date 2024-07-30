import sys

n = int(input())
stack = []

def push(num):
    stack.append(num)
    
def pop():
    if stack:
        num = stack.pop()
        print(num)
        
    else:
        print(-1)
        
def size():
    print(len(stack))
    
def empty():
    print(1 if not stack else 0)
    
def top():
    print(stack[-1] if stack else -1)  

for _ in range(n):
    operation = list(map(str, sys.stdin.readline().split()))
    
    case = operation[0]
    
    if case == 'push':
        push(operation[1])
        
    elif case == 'pop':
        pop()
        
    elif case == 'size':
        size()
        
    elif case == 'empty':
        empty()
        
    else:
        top()
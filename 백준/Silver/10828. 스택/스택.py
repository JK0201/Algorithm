import sys
n = int(sys.stdin.readline().strip())
stack = []

def push(num):
    stack.append(num)
    
def pop():
    if stack:
        num = stack.pop()
        print(num) 
        
    else: 
        print('-1')

def size():
    print(len(stack))
    
def empty():
    print('1') if not stack else print(0)
    
def top():
    print(stack[-1]) if stack else print(-1)
    
for i in range(n):
    operation = list(map(str, sys.stdin.readline().split()))
    
    if len(operation) == 2:
        push(operation[1])
        
    else:
        if operation[0] == 'pop':
            pop()
            
        elif operation[0] == 'size':
            size()
            
        elif operation[0] == 'empty':
            empty()
            
        else:
            top()
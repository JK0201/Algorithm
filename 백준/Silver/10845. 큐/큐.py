import sys
from collections import deque

n = int(input())
q = deque()

def push(num):
    q.append(num)
    
def pop():
    if q:
        num = q.popleft()
        print(num)
    
    else:
        print(-1)
        
def size():
    print(len(q))
    
def empty():
    print(0 if q else 1)

def front():
    print(q[0] if q else -1)
    
def back():
    print(q[-1] if q else -1)

for _ in range(n):
    operation = list(map(str, sys.stdin.readline().split()))
    
    if len(operation) == 2:
        num = operation[1]
        push(num)
        
    else:
        case = operation[0]
        
        if case == 'front':
            front()
            
        elif case == 'back':
            back()
            
        elif case == 'size':
            size()
        
        elif case == 'empty':
            empty()
            
        else:
            pop()
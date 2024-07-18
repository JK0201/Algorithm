from collections import deque

def solution(priorities, target):
    q = deque((p, i) for i, p in enumerate(priorities))
    stack = []
    
    while q:
        deq = q.popleft()
        stack.append(deq)
        
        idx = 0
        while idx < len(q):
            if deq[0] < q[idx][0]:
                q.append(deq)
                stack.pop()
                break
            idx += 1
            
    
    for i in range(len(stack)):
        if stack[i][1] == target:
            return i + 1
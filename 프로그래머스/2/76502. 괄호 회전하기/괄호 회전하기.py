from collections import deque

def solution(s):
    q = deque(s)
    res = [1] * len(s)
    i = 0
    
    while i < len(q):
        stack = []
        for j in q:
            if j == '(':
                stack.append(')')
                
            elif j == '[':
                stack.append(']')
                
            elif j == '{':
                stack.append('}')
            
            elif not stack or stack[-1] != j:
                res[i] = 0
                break
                
            elif stack and stack[-1] == j:
                stack.pop()
        
        if stack:
            print(stack)
            res[i] = 0
            
        cur_num = q.popleft()
        q.append(cur_num)
        i += 1
        
    return res.count(1)
        
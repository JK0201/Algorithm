from collections import deque

def solution(priorities, target):
    cnt = 0
    
    q = deque(i for i in range(len(priorities)))
    max_num = max(priorities)
    
    while q:
        idx = q.popleft()
        
        if priorities[idx] < max_num:
            q.append(idx)

        else:
            cnt += 1
            priorities[idx] = 0
            max_num = max(priorities)
            if idx == target:
                return cnt
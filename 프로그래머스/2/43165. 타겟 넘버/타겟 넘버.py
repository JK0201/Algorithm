from collections import deque

def solution(numbers, target):
    cnt = 0
    q = deque()
    q.append((0, 0))
    
    while q:
        cur_val, idx = q.popleft()
        
        if idx == len(numbers) and cur_val == target:
            cnt += 1
            
        elif idx < len(numbers):
            q.append((cur_val + numbers[idx], idx + 1))
            q.append((cur_val - numbers[idx], idx + 1))
    
    return cnt
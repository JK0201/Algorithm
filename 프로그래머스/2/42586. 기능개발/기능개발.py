from collections import deque

def solution(progresses, speeds):
    answer = []
    
    q = deque(progresses)
    s = deque(speeds)
    
    while q:
        cnt = 0
        idx = 0
        while idx < len(q):
            q[idx] += s[idx]
            idx += 1
            
        while q and q[0] >= 100:
            q.popleft()
            s.popleft()
            cnt += 1
        
        if cnt != 0:
            answer.append(cnt)
        
    return answer
from collections import deque

def solution(progresses, speeds):
    answer = []
    q = deque(progresses)
    s = deque(speeds)
    
    cnt = 0
    time = 0
    
    while q:
        if q[0] + s[0] * time >= 100:
            q.popleft()
            s.popleft()
            cnt += 1
            
        else:
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
            time += 1
            
    answer.append(cnt)
    return answer
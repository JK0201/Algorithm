from collections import deque

def solution(progresses, speeds):
    answer = []
    p = deque(progresses)
    s = deque(speeds)
    
    days = 0
    cnt = 0
    
    while p:
        cur_prog = p[0] + s[0] * days
        if cur_prog >= 100:
            p.popleft()
            s.popleft()
            cnt += 1
            
        else:
            if cnt > 0:
                answer.append(cnt)
                cnt = 0
                
            days += 1
    
    answer.append(cnt)
    return answer
from collections import deque

def solution(str1, str2):
    answer = ''
    stack = []
    s1 = deque(s for s in str1)
    s2 = deque(s for s in str2)

    while s1 and s2 :
        stack.append(s1.popleft())
        stack.append(s2.popleft())
    
    for s in stack:
        answer += s
    
    return answer
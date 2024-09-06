import sys
from collections import deque

def solution (testCase):
    words = [w for w in testCase]
    q = deque()
    result = []
    
    for w in words:
        if w == "<":
            while q:
                cur_word = q.pop()
                result.append(cur_word)
            q.append(w)
            continue
        
        elif w == ">":
            q.append(w)
            while q:
                cur_word = q.popleft()
                result.append(cur_word)
            continue
        
        elif w == " ":
            if "<" not in q:
                while q:
                    cur_word = q.pop()
                    result.append(cur_word)
                result.append(" ")
                continue
        
        elif w == "\n":
            while q:
                cur_word = q.pop()
                result.append(cur_word)
            
        q.append(w)
           
    return "".join(result)

testCase = sys.stdin.readline()
print(solution(testCase))
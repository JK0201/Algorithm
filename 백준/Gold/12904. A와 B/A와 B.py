import sys

n = sys.stdin.readline().strip()
t = sys.stdin.readline().strip()

while len(t) > len(n):
    if t[-1] == 'A':
        t = t[:-1]
    
    else:
        t = t[:-1]
        t = t[::-1]
        
if t == n:
    print(1)
else:
    print(0)
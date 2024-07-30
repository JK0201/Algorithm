import sys
t = int(input())

for i in range(t):
    n, s = list(map(str, sys.stdin.readline().split()))
    
    for i in s:
        print(i * int(n), end='')
        
    print()
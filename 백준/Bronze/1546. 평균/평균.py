import sys
n = int(sys.stdin.readline())
scores = list(map(int, sys.stdin.readline().split()))
max_score = max(scores)

total = 0
for s in scores:
    total += (s/max_score) * 100
    
print(total / n)
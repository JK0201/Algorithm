import sys
n = int(sys.stdin.readline().strip())
order = list(map(int, sys.stdin.readline().split()))
order.sort()

prev = 0
total = 0
for o in order:
    total += o + prev
    prev += o
    
print(total)
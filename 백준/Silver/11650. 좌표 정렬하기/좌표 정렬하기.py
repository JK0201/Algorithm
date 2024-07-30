import sys
p = int(input())
points = []

for _ in range(p):
    x, y = list(map(int, sys.stdin.readline().split()))
    points.append((int(x), int(y)))

sorted_points = sorted(points)

for s in sorted_points:
    x, y = s
    print(x, y)
import sys
a, b, c = list(map(int, sys.stdin.read().split()))

print(a + b - c)
print(int(str(a) + str(b)) - c)
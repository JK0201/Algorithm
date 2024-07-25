import sys
dict = set(map(int, sys.stdin.read().split()))

for i in range(1,31):
    if i not in dict:
        print(i)
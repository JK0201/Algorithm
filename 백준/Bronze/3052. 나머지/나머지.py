import sys
arr = list(map(int, sys.stdin.read().split()))

mods = {i % 42 for i in arr}

print(len(mods))
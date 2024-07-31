import sys

n = int(sys.stdin.readline())

for _ in range(n):
    words = sys.stdin.readline()
    
    for i in range(len(words)):
        if i == 0:
            print(words[i].upper(), end='')
        else:
            print(words[i], end='')
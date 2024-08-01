import sys
n = int(sys.stdin.readline().strip())

apt = [[0 for _ in range(14)] for _ in range(15)]

for i in range(len(apt)):
    total = 0
    for j in range(len(apt[i])):
        if i == 0:
            apt[i][j] = j + 1
            
        else:
            total += apt[i-1][j]
            apt[i][j] = total

for _ in range(n):
    k = int(sys.stdin.readline().strip())
    n = int(sys.stdin.readline().strip())
    print(apt[k][n-1])
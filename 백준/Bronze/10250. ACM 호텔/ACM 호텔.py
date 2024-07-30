import sys
c = int(input())

for i in range(c):
    h, w, n = list(map(int, sys.stdin.readline().split()))
    
    rooms = []
    for i in range(1, w + 1):
        for j in range(1, h + 1):
            rooms.append(str(j) + ('0' + str(i) if i < 10 else str(i)))
            
    print(rooms[n-1])
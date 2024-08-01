from collections import deque

n, k = map(int, input().split())
player = deque()

for i in range(1, n+1):
    player.append(i)
    
i = 0
print('<', end='')
while player:
    i += 1
    p = player.popleft()
    
    if i != k:
        player.append(p)
    
    else:
        if player:
            print(p, end=', ')
        
        else:
            print(p, end='')
        i = 0
        
print('>')
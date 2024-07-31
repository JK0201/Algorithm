n = int(input())
s = 1

for i in range(1, n+1):
    print(' ' * (n-i), end='')
    print('*', end='')
    
    if i != 1:
        print(' ' * (s), end='')
        print('*', end='')
        s += 2
        
    print()
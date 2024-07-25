import sys

data = sys.stdin.read().split()
x = int(data[0])
y = int(data[1])

if x > 0 and y > 0:
    print(1)
    
elif x < 0 and y > 0:
    print(2)
    
elif x < 0 and y < 0:
    print(3)
    
else:
    print(4)
arr = list(map(int, input().split()))

stack = []
ascending = False
descending = False
mixed = False

for i in arr:
    if not stack:
        stack.append(i)
    
    else:
        if i - 1 == stack[-1]:
            ascending = True
        
        elif i + 1 == stack[-1]:
            descending = True 
        
        else:
            mixed = True
        stack.append(i)
    
if mixed:
    print('mixed')
    
else:
    print ('ascending' if ascending else 'descending')
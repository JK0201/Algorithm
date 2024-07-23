def solution(arr1, arr2):
    x, y = arr1, arr2
    if len(x) != len(y):
        return -1 if len(y) > len(x) else 1
    
    else:
        if sum(y) > sum(x):
            return -1
        
        elif sum(x) > sum(y):
            return 1
        
        else:
            return 0
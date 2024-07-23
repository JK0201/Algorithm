def solution(arr1, arr2):
    if len(arr1) > len(arr2):
        return 1
    
    elif len(arr1) < len(arr2):
        return -1
    
    elif len(arr1) == len(arr2):
        a1 = 0
        a2 = 0
        for i in range(len(arr1)):
            a1 += arr1[i]
            a2 += arr2[i]
            
        if a1 > a2:
            return 1
            
        elif a1 < a2:
            return -1
            
        else:
            return 0
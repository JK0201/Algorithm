def solution(arr):
    if 2 not in arr:
        return [-1]
    
    answer = []
    left = 0
    right = len(arr) - 1
    
    while left < right:
        if arr[left] != 2:
            left += 1
        
        if arr[right] != 2:
            right -= 1
        
        if arr[left] == 2 and arr[right] == 2:
            break
        
    answer = arr[left:right+1]
    return answer
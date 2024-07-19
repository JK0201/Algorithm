def solution(arr):
    row = len(arr)
    col = len(arr[0])
    
    if row < col:
        while row < col:
            arr.append([0] * col)
            row += 1
    
    if col < row:       
        for i in range(len(arr)):
            arr[i].extend([0] * (row - col))
    
    return arr
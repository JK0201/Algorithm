def solution(arr):
    row = len(arr)
    col = len(arr[0])
    
    if row < col:
        while row < col:
            arr.append([0] * col)
            row += 1
    
    if col < row:       
        for i in range(len(arr)):
            while len(arr[i]) < row:
                arr[i].append(0)
    
    return arr
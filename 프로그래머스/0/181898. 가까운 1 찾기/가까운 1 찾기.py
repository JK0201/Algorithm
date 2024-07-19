def solution(arr, idx):
    for i, a in enumerate(arr):
        if i >= idx and a == 1:
            return i
            
    return -1
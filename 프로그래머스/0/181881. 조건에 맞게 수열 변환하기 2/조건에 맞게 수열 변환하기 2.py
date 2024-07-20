def solution(arr):
    answer = 0

    while True:
        count = 0
        for i in range(len(arr)):
            if arr[i] >= 50 and arr[i] % 2 == 0:
                arr[i] = int(arr[i] / 2)
                count += 1
            
            elif arr[i] < 50 and arr[i] % 2 != 0:
                arr[i] = arr[i] * 2 + 1
                count += 1
            
        if count == 0:
            break
            
        answer += 1
        
    return answer
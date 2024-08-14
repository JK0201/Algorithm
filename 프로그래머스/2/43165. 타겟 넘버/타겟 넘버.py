def solution(numbers, target):
    cnt = 0
    def dfs(idx, cur_val):
        nonlocal cnt
        
        if idx == len(numbers):
            if cur_val == target:
                cnt += 1
            return
        
        dfs(idx + 1, cur_val + numbers[idx])
        dfs(idx + 1, cur_val - numbers[idx])
        
    dfs(0, 0)
    return cnt
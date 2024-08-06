def solution(numbers, target):
    cnt = 0
    def dfs(cur_val, idx):
        nonlocal cnt
        
        if idx == len(numbers):
            if cur_val == target:
                cnt += 1
            return
        
        dfs(cur_val + numbers[idx], idx + 1)
        dfs(cur_val - numbers[idx], idx + 1)
        
    dfs(0, 0)
    return cnt
def solution(nums):
    answer = int(len(nums) / 2)
    dict = set(nums)
    
    if len(dict) < answer:
        return len(dict)
    
    return answer
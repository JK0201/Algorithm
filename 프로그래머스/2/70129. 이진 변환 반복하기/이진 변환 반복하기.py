def solution(s):
    answer = [0, 0]
    nums = {'0': 0, '1': 0}
    
    cnt = 0
    cur_num = s
    while cur_num != '1':
        cnt += 1
        
        for num in cur_num:
            if num in nums:
                nums[num] += 1
        
        length = nums['1']
        binary = ''
        
        while length != 0:
            length, mod = divmod(length, 2)
            binary += str(mod)
        
        cur_num = binary[::-1]
        nums['1'] = 0
        
    return [cnt, nums['0']]
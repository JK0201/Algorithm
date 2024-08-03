def xferToBin(num):
    cnt = 0
    while num != 0:
        num, mod = divmod(num, 2)
        if mod == 1:
            cnt += 1
            
    return cnt
        
def solution(n):
    init_num = xferToBin(n)
    target_num = n + 1
    
    while True:
        if init_num == xferToBin(target_num):
            return target_num
            
        target_num += 1
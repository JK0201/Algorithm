import sys
n = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))

def prime_num(num):
    if num < 2:
        return False
    
    for n in range(2, int(num**0.5)+1):
        if num % n == 0:
            return False
        
    return True

cnt = len([num for num in nums if prime_num(num)])
print(cnt)
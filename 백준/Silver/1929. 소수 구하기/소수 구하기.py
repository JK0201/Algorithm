m, n = map(int, input().split())

def prime_num(num):
    if num < 2:
        return False
    
    for n in range(2, int(num**0.5)+1):
        if num % n == 0:
            return False
    
    return True

for num in range(m, n+1):
    if prime_num(num):
        print(num)
a, b = map(int, input().split())

def gcd(a, b):
    if a % b == 0 or b % a == 0:
        print(min(a, b))
        
    else:
        i = 1
        div = []
        while i < a and i < b:
            if a % i == 0 and b % i == 0:
               div.append(i)
            i += 1
            
        print(max(div))

def lcm(a, b):
    l = 1
    r = 1
    num1 = a
    num2 = b
    while num1 != num2:
        if num1 > num2:
            r += 1
            
        elif num1 < num2:
            l += 1
            
        num1 = a * l
        num2 = b * r
            
    print(num1)
    
gcd(a, b)
lcm(a, b)
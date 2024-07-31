a, b = map(int, input().split())

def factorial(num):
    total = 1
    for n in range(num, 0, -1):
        total *= n
        
    return total

print(int(factorial(a) / (factorial(b) * factorial(a-b))))
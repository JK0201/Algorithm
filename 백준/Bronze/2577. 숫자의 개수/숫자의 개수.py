a = int(input())
b = int(input())
c = int(input())

mult = a * b * c
dict = {}

for n in str(mult):
    if int(n) not in dict:
        dict[int(n)] = 1
        
    else:
        dict[int(n)] += 1

for n in range(0, 10):
    if n in dict:
        print(dict[n])
        
    else:
        print(0)
num = int(input())

res = 1
for n in range(1, num + 1):
    res *= n
    
str_res = str(res)[::-1]

i = 0
while True:
    if str_res[i] == '0':
        i += 1
    
    else:
        break
    
print(i)
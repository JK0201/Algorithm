n = int(input())
words = str(input())
alpha_num = {chr(a) : i + 1 for i, a in enumerate(range(ord('a'), ord('z') + 1))}
res = 0
mod = 1234567891

for i in range(len(words)):
    v = words[i]
    if v in alpha_num:
        res += alpha_num[v] * (31 ** i)
        
print(res % mod)
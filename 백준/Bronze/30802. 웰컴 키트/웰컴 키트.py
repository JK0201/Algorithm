n = int(input())
sizes = list(map(int, input().split()))
t, p = map(int, input().split())

t_cnt = 0
for s in sizes:
    if s == 0:
        pass
    
    elif s <= t:
        t_cnt += 1
        
    else:
        val, mod = divmod(s, t)
        t_cnt += val if mod == 0 else val + 1

val, mod = divmod(n, p)

print(t_cnt)
print(val, mod)
h, m = map(int, input().split())

calc_m = m - 45

if m - 45 < 0:
    h -= 1
    if h < 0:
        h += 24
        
    calc_m += 60
    
print(h, calc_m)
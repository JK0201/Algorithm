import sys

n = int(input())
str_arr = list(map(str, sys.stdin.read().split()))
str_dict = {}

for s in str_arr:
    length = len(s)
    if length not in str_dict:
        str_dict[length] = [s]
        
    else:
        if s not in str_dict[length]:
            str_dict[length].append(s)

dict_len = max(str_dict)

for d in range(1, dict_len+1):
    if d in str_dict:
        sorted_str = sorted(str_dict[d])
        for s in sorted_str:
            print(s)
import sys

n = int(input())
data = []
member_list = [''] * n

for i in range(n):
    member = list(map(str, sys.stdin.readline().split()))
    member_list[i] = member
    age = member[0]
    data.append((int(age), i))
    
sorted_data = sorted(data)

for s in sorted_data:
    idx = s[1]
    age, name = member_list[idx]
    print(age, name)
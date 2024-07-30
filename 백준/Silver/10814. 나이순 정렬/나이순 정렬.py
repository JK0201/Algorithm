import sys

n = int(input())
member_list = []

for i in range(n):
    age, name = list(map(str, sys.stdin.readline().split()))
    member_list.append((int(age), name))
    
sorted_member = sorted(member_list, key = lambda x: x[0])

for s in sorted_member:
    age, name = s
    print(age, name)
import sys
n = int(sys.stdin.readline())
nums1 = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
nums2 = list(map(int, sys.stdin.readline().split()))

cards = {}

for i in nums1:
    if i not in cards:
        cards[i] = 1
        
    else:
        cards[i] += 1
        
for i in nums2:
    if i in cards:
        print(cards[i], end=' ')
        
    else:
        print(0, end=' ')
import sys
n = int(sys.stdin.readline())
nums1 = list(map(int, sys.stdin.readline().split()))
a = set(nums1)

m = int(sys.stdin.readline())
nums2 = list(map(int, sys.stdin.readline().split()))

for b in nums2:
    if b in a:
        print(1)
    else:
        print(0)
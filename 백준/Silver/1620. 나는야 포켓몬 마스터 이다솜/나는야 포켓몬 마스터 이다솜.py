import sys

n, q = sys.stdin.readline().split()
names ={}
nums = {}

for i in range(1, int(n)+1):
   pokemon = sys.stdin.readline().strip()
   names[pokemon] = str(i)
   nums[str(i)] = pokemon
   
for i in range(int(q)):
    quiz = sys.stdin.readline().strip()
    if quiz in names:
        print(names[quiz])
        
    elif quiz in nums:
        print(nums[quiz])
import sys

data = sys.stdin.read().splitlines()
n = data[0]

session = []
for i in range(1, len(data)):
    session.append(tuple(map(int, data[i].split())))
    
session.sort(key = lambda x: (x[1], x[0]))

end_time = session[0][1]
count = 1

for i in range(1, len(session)):
    cur_start = session[i][0]
    cur_end = session[i][1]

    if cur_start >= end_time:
        count += 1
        end_time = cur_end
        
print(count)
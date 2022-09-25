import sys

n = int(sys.stdin.readline())

for i in range(n):
    # Read line and split it by space and convert to ints
    testCase = sys.stdin.readline()
    outlets = [int(x) for x in testCase.split()]
    totalSockets = sum(outlets)
    l = len(outlets)
    print(totalSockets - l - 1)

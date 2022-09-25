import sys


def main():
    line = sys.stdin.read()
    # N: Number of articles
    # I: Required impact factor
    n, k = map(int, line.split())

    # impactFactor = citationsReceived / numberOfArticlesPublished
    # citationsReceived = impactFactor * numberOfArticlesPublished

    print(k * n)

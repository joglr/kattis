# Read number from standard input

import sys


def main():
    n = int(sys.stdin.read())
    print("Alice" if n % 2 == 1 else "Bob")


if __name__ == "__main__":
    main()

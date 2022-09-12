# Coverage

| Branch    | Input property | Covered by test | Input | Output           | Actual           |
| --------- | -------------- | --------------- | ----- | ---------------- | ---------------- |
| 1 (true)  | n < 0          | A               | -1    | BadUserException | BadUserException |
| 2 (false) | n >= 0         | B, C, D         |       |
| 2.1       | n = 0          | B               | 0     | 1                | 1                |
| 2.2       | n = 1          | C               | 1     | 1                | 1                |
| 2.3       | n = 2          | D               | 2     | 2                | 2                |

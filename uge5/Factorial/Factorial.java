package uge5.Factorial;

class BadUserException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
}

public class Factorial {
	int factorial(int n) throws BadUserException {
		if (n < 0)
			throw new BadUserException(); /* 1: n = -1 */
		else {
			int res = 1;
			for (int i = 1; i <= n; i++) { /* 2 n >= 0 */
				res = res * i;
				/* 2.1 n = 0, for løkken bliver ikke kørt og res = 1 */
				/* 2.2 n = 1, for løkken køres en gang, res = 1 */
				/* 2.3 n = 2, for løkken køres en gang, res = 2 */
			}
			return res;
		}
	}
}

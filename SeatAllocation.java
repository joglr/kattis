import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 * SeatAllocation
 */
public class SeatAllocation implements Testable {

  @Override
  public String getTestsFolder() {
    return "sempai5_1";
  }

  @Override
  public int getTestCount() {
    return 5;
  }

  @Override
  public String run(Reader in) throws IOException {
    StringBuilder out = new StringBuilder();
    Scanner sc = new Scanner(in);
    int[] nums = Test.getIntsFromLine(sc.nextLine());

    int numParties = nums[0];
    int numSeatsToAllocate = nums[1];

    // System.out.println(
    //   "Allocating " +
    //   numSeatsToAllocate +
    //   " seats between " +
    //   numParties +
    //   " parties"
    // );

    Party[] parties = new Party[numParties];
    MaxPQ<Party> maxPQ = new MaxPQ<>();

    for (int i = 0; i < numParties; i++) {
      parties[i] = new Party(i, Test.getIntsFromLine(sc.nextLine())[0]);
      maxPQ.insert(parties[i]);
    }
    // printParties(parties);

    sc.close();

    while (numSeatsToAllocate > 0) {
      // Heap.sort(parties);
      Party p = maxPQ.delMax();
      p.recieveSeat();

      // parties[parties.length - 1].recieveSeat();
      // System.out.println(p.getIndex() + " gets a vote!");
      // printParties(parties);
      maxPQ.insert(p);
      numSeatsToAllocate--;
    }

    // Output seatAllocation

    for (Party p : parties) {
      int seatCount = p.getSeats();
      out.append(seatCount + "\n");
    }
    return out.toString();
  }

  int width = 10;

  void printParties(Party[] parties) {
    System.out.println();
    System.out.println(f("I") + f("V") + f("Q") + f("S"));
    System.out.println((f("") + f("") + f("") + f("")).replace(" ", "-"));

    for (Party p : parties) {
      System.out.println(
        f(((Integer) (p.getIndex())).toString()) +
        f(((Double) Double.valueOf(p.getVotes())).toString()) +
        f(((Double) p.getQuotient()).toString()) +
        f(((Integer) p.getSeats()).toString())
      );
    }
    System.out.println();
  }

  String f(String str) {
    return String.format("%1$" + width + "s", str);
  }

  public static void main(String[] args) throws IOException {
    System.out.println(
      new SeatAllocation().run(new InputStreamReader(System.in))
    );
  }
}

class Party implements Comparable<Party> {
  double quotient;
  int index;
  int votes;
  int seats = 0;

  Party(int _index, int _votes) {
    index = _index;
    votes = _votes;
    quotient = _votes;
  }

  /**
   * @return the seats
   */
  public int getSeats() {
    return seats;
  }

  /**
   * @return the index
   */
  public int getIndex() {
    return index;
  }

  /**
   * @return the votes
   */
  public int getVotes() {
    return votes;
  }

  void recieveSeat() {
    seats++;
    quotient = Double.valueOf(votes) / Double.valueOf(seats + 1);
  }

  public double getQuotient() {
    return quotient;
  }

  @Override
  public int compareTo(Party p) {
    if (p.getQuotient() < getQuotient()) return 1;
    if (p.getQuotient() > getQuotient()) return -1;
    return 0;
  }
}

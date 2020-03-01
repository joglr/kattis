import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Scanner;

/**
 * SeatAllocation
 */
public class SeatAllocation implements Testable {
  Party[] parties;

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

    parties = new Party[numParties];

    for (int i = 0; i < numParties; i++) {
      parties[i] = new Party(i, Test.getIntsFromLine(sc.nextLine())[0]);
    }

    sc.close();

    while (numSeatsToAllocate > 0) {
      Heap.sort(parties);
      parties[parties.length - 1].recieveSeat();
      // System.out.println(
      //   parties[parties.length - 1].getIndex() + " gets a vote!"
      // );
      numSeatsToAllocate--;
      // printParties();
    }

    // Output seatAllocation

    for (Party p : parties) {
      int seatCount = p.getSeats();
      out.append(seatCount + "\n");
    }
    return out.toString();
  }

  int width = 10;

  void printParties() {
    System.out.println(f("i") + f("v") + f("q"));
    for (Party p : parties) {
      System.out.println(
        f(((Integer) (p.getIndex())).toString()) +
        f(((Double) Double.valueOf(p.getVotes())).toString()) +
        f(((Double) p.getQuantifier()).toString())
      );
    }
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
  double quantifier;
  int index;
  int votes;
  int seats = 0;

  Party(int _index, int _votes) {
    index = _index;
    votes = _votes;
    quantifier = _votes;
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
    quantifier = votes / (seats);
  }

  public double getQuantifier() {
    return quantifier;
  }

  @Override
  public int compareTo(Party p) {
    if (p.getQuantifier() < getQuantifier()) return 1;
    if (p.getQuantifier() > getQuantifier()) return -1;
    return 0;
  }
}

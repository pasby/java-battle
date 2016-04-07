/**
 * Created by user on 04.04.2016.
 */
public class Solve {
    public static void main(String[] args) {
        System.out.print("One Thread: ");
        OneThreadSolution sol = new OneThreadSolution();

        sol.solve(123456789,987654321);


        System.out.print("Five Threads: ");
       Thread[] sols= new Thread[5];
        sols[0]= new Thread(new MultiThreadSol(123_456_789,298_765_431));
        sols[1]= new Thread(new MultiThreadSol(312_456_789,498_765_321));
        sols[2]= new Thread(new MultiThreadSol(512_346_789,698_754_321));
        sols[3]= new Thread(new MultiThreadSol(712_345_689,897_654_321));
        sols[4]= new Thread(new MultiThreadSol(912_345_678,987_654_321));

        for (int i = 0; i < 5; i++) {
            sols[i].start();
        }




    }
}

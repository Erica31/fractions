
/**
 * Write a description of class estimatingPI here.
 *
 * @author Erica Lee
 * @version 12/13/2023
 */
import java.util.Scanner;
public class gameWithPi{
    public static boolean game=true;
    public static void main(String[] args){
        //runs game
        quizGame();
        
        //prints the estimate fraction for PI
        System.out.println(estimatePI());
    }

    public static fraction estimatePI(){
        fraction MILU = new fraction(355, 113);
        final double EPSILON = Math.abs(Math.PI - MILU.toDouble());
        fraction estimate = new fraction(355, 113);
        while(Math.abs(Math.PI - estimate.toDouble()) >= EPSILON){
            if(estimate.toDouble() <= Math.PI)
                estimate.setNum(estimate.getNum()+1);
            else if(estimate.toDouble() >= Math.PI)
                estimate.setDenom(estimate.getDenom()+1);
        }
        return estimate;
    }

    public static void quizGame(){
        Scanner in = new Scanner(System.in);
        System.out.println("Let the Fraction Quiz begin. Answers should be in lowest terms. Good luck!\n");
        int correct = 0;
        int total = 0;
        while(game==true){
            fraction f1 = new fraction(randomFrac());
            fraction f2 = new fraction(randomFrac());
            fraction ans = new fraction();

            int operation = (int)(Math.random()*4);
            if (operation == 0){
                ans = fraction.add(f1, f2);
                System.out.print(f1.toString()+" + "+f2.toString()+" = ");
            }
            if(operation == 1){
                ans = fraction.subtract(f1, f2);
                System.out.print(f1.toString()+" - "+f2.toString()+" = ");
            }
            if(operation == 2){
                ans = fraction.multiply(f1, f2);
                System.out.print(f1.toString()+" * "+f2.toString()+" = ");
            }
            if(operation == 3){
                ans = fraction.divide(f1, f2);
                System.out.print(f1.toString()+" / "+f2.toString()+" = ");
            }

            String user = in.nextLine();
            if(user.equals("quit")){
                game=false;
                break;
            }
            fraction userAns = new fraction(user);

            if (equals(ans, userAns)){
                System.out.println("Correct!\n");
                correct++;
            }else{
                System.out.println("Wrong, the answer is "+ans);
                System.out.println();
            }
            total++;
        }
        
        fraction score = new fraction(correct, total);
        int percent = (int)((score.toDouble()*100)+0.5);
        System.out.println("\nYour win/loss ratio was "+score+", for a score of "+percent+" percent!");
        
    }

    public static boolean equals(fraction u, fraction c){
        if(u.getNum()==c.getNum() && u.getDenom()==c.getDenom()) return true;
        else return false;
    }

    public static fraction randomFrac(){
        int num = (int)(Math.random()*9)+1;
        int denom = (int)(Math.random()*9)+1;
        fraction f = new fraction(num, denom);
        return f;
    }

}

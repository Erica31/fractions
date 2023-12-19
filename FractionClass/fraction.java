
/**
 * Fraction Class will deal with all sorts of fraction functions. 
 *
 * @author Erica Lee
 * @version Dec 5, 2023
 */
public class fraction{
    
    //Instance Variables
    private int numerator;
    private int denominator;
    
    //Constructors
    /**
     * sets defult fraction to 1/1
     */
    public fraction(){
        numerator = 1;
        denominator = 1;
    }
    /**
     * makes a fraction with paramaters
     * @param numerator first paramater
     * @param denominator second paramater
     */
    public fraction(int nume, int denom){
        error(denom);
        numerator = nume;
        denominator = denom;
    }
    /**
     * makes a fraction object from a string representing a fraction
     * @param frac fraction in String form. eg."3/4"
     */
    public fraction(String frac){
        int index = frac.indexOf("/");
        if(index>0){
            numerator = Integer.parseInt(frac.substring(0,index));
            int d = Integer.parseInt(frac.substring(index+1)); 
            error(d);
            denominator=d;
        }else{
            System.out.println("not a valid fraction, fraction is set to 1/1");
            numerator = 1;
            denominator = 1;
        }
    }
    /**
     * makes a fraction duplicate
     * @param frac the fraction being duplicated from. 
     */
    public fraction(fraction frac){
        numerator = frac.numerator;
        denominator = frac.denominator;
    }
    
    //Behaviors
    /**
     * checks if the int is 0. If it is, it changes to one and prints an error message. Used for checking denominators. 
     * @param intd used as denominator
     */
    private void error(int d){
        if(d==0){
            System.out.println("ERROR - denominator cannot be zero and will be changed to one");
            d = 1;
        }
    }
    
    //ACCESSOR METHODS
    public int getNum(){
        return numerator;
    }
    public int getDenom(){
        return denominator;
    }
    public String toString(){
        return numerator+"/"+denominator;
    }
    public double toDouble(){
        return (double) numerator/denominator;
    }
    
    //MUTATOR METHODS
    public void reduce(){
        int f = gcd(numerator, denominator);
        if(numerator<0 && denominator<0){
            numerator *= -1;
            denominator *= -1;
        }
        numerator /= f;
        denominator /= f;
    }
    public void setNum(int newNum){
        numerator = newNum;
    }
    public void setDenom(int newDenom){
        error(newDenom);
        denominator = newDenom;
    }
    
    //STATIC METHODS
    public static fraction multiply(fraction frac1, fraction frac2){
        int n = frac1.numerator * frac2.numerator;
        int d = frac1.denominator * frac2.denominator;
        fraction newFrac = new fraction(n, d);
        newFrac.reduce();
        
        return newFrac;
    }
    public static fraction divide(fraction frac1, fraction frac2){
        int n = frac1.numerator * frac2.denominator;
        int d = frac1.denominator * frac2.numerator;
        fraction newFrac = new fraction(n, d);
        newFrac.reduce();
        
        return newFrac;
    }
    public static fraction add(fraction frac1, fraction frac2){
        int n1 = frac1.numerator*frac2.denominator;
        int n2 = frac2.numerator*frac1.denominator;
        int d = frac1.denominator*frac2.denominator;
        int n = n1 + n2;
        fraction newFrac = new fraction(n,d);
        newFrac.reduce();
        
        return newFrac;
    }
    public static fraction subtract(fraction frac1, fraction frac2){
        int n1 = frac1.numerator*frac2.denominator;
        int n2 = frac2.numerator*frac1.denominator;
        int d = frac1.denominator*frac2.denominator;
        int n = n1 - n2;
        fraction newFrac = new fraction(n,d);
        newFrac.reduce();
        
        return newFrac;
    }
    
    public int gcd(int a, int b){
        a = Math.abs(a);
        b = Math.abs(b);
        
        while(a!=b){
            if(a>b){
                a = a-b;
            }
            if(b>a){
                b = b-a;
            }
        }
        return a;
    }
    
}

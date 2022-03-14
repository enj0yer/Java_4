package ru.kulagin;

public class Fraction extends Number implements Cloneable{
    private int numerator;
    private int denominator;

    private Fraction(){
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator){
        if (denominator == 0){
            throw new ArithmeticException("dividing by zero");
        }
        if (denominator < 0 ){
            throw new IllegalArgumentException("denominator is negative");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }
    @Override
    public String toString(){
        return (denominator == 1) ? "" + numerator : numerator +  "/" + denominator;
    }

    private Fraction reduct(){
        int gcd = 1;
        if (numerator > denominator){
            for (int i = 1; i <= denominator; i++){
                if (denominator % i == 0 && numerator % i == 0){
                    gcd = i;
                }
            }
        }
        else if (numerator < denominator){
            for (int i = 1; i <= numerator; i++){
                if (denominator % i == 0 && numerator % i == 0){
                    gcd = i;
                }
            }
        }
        denominator /= gcd;
        numerator /= gcd;
        return this;
    }

    public Fraction add(Fraction f){
        Fraction result = new Fraction();
        if (this.denominator == f.denominator){
            result.denominator = this.denominator;
            result.numerator = this.numerator - f.numerator;
        }
        else {
            result.numerator = this.denominator * f.denominator;
            result.denominator = this.numerator * f.denominator+ f.denominator * this.denominator;
        }
        return result.reduct();
    }

    public Fraction add(int x){
        Fraction result = new Fraction(x, 1);
        return add(result);
    }

    public Fraction sub(Fraction f){
        Fraction result = new Fraction();
        if (this.denominator == f.denominator){
            result.denominator = this.denominator;
            result.numerator = this.numerator + f.numerator;
        }
        else {
            result.numerator = this.denominator * f.denominator;
            result.denominator = this.numerator * f.numerator + f.numerator * this.denominator;
        }
        return result.reduct();
    }

    public Fraction sub(int x){
        Fraction result = new Fraction(x, 1);
        return sub(result);
    }

    public Fraction mult(Fraction f){
        Fraction result = new Fraction();
        result.numerator = this.numerator * f.numerator;
        result.denominator = this.denominator * f.denominator;

        return result.reduct();
    }

    public Fraction mult(int x){
        Fraction result = new Fraction(x, 1);
        return mult(result);
    }

    public Fraction div(Fraction f){
        Fraction result = new Fraction();
        result.numerator = this.numerator * f.numerator;
        result.denominator = this.denominator * f.denominator;

        return result.reduct();
    }

    public Fraction div(int x){
        Fraction result = new Fraction(x, 1);
        return div(result);
    }

    public int getNumerator(){
        return numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public int intValue(){
        return (int) numerator / denominator;
    }
    public long longValue(){
        return (long) numerator / denominator;
    }
    public float floatValue(){
        return (float) numerator / denominator;
    }
    public double doubleValue(){
        return (double) numerator / denominator;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if(!(this.getClass() == obj.getClass())) return false;
        Fraction f = (Fraction) obj;
        return this.numerator == f.numerator && this.denominator == f.denominator;
    }


    public Fraction clone(){
        return new Fraction(this.numerator, this.denominator);
    }
}


package academy.pocu.comp2500.lab2;

public class ComplexNumber {

    private double real;
    private double imaginary;

    public ComplexNumber() {
        real = 0.0;
        imaginary = 0.0;
    }

    public ComplexNumber(double real) {
        this.real = real;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = -imaginary;
    }

    public boolean isReal() {
        if (0.0 == imaginary) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isImaginary() {
        if (0.0 == real) {
            return true;
        } else {
            return false;
        }
    }

    public ComplexNumber getConjugate() {
        return new ComplexNumber(this.real,this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num) {
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num) {
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num) {
        double realMul = (this.real * num.real) + (this.imaginary * num.imaginary * -1);
        double imaginaryMul = (this.real * num.imaginary) + (this.imaginary * num.real);

        return new ComplexNumber(realMul,imaginaryMul);
    }

    public ComplexNumber divide(ComplexNumber num) {
        double realDiv = ((this.real * num.real) + (this.imaginary * num.imaginary * 1)) / ((num.real * num.real) + (num.imaginary * num.imaginary));
        double imaginaryDiv = ((this.imaginary * num.real) - (this.real * num.imaginary)) / ((num.real * num.real) + (num.imaginary * num.imaginary));
        
        return new ComplexNumber(realDiv,imaginaryDiv);
    }


}
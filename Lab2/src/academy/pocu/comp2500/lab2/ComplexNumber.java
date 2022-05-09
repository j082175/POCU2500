package academy.pocu.comp2500.lab2;

public class ComplexNumber {

    public double real;
    public double imaginary;

    public ComplexNumber(){
        real = 0.0;
        imaginary = 0.0;
    }

    public ComplexNumber(double real){
        this.real = real;
        this.imaginary = 0.0;
    }

    public ComplexNumber(double real, double imaginary){
        this.real = real;
        this.imaginary = imaginary;
    }

    public boolean isReal(){
        if(0.0 == imaginary){
            return true;
        }else{
            return false;
        }
    }

    public boolean isImaginary(){
        if(0.0 == real){
            return true;
        }else{
            return false;
        }
    }

    public ComplexNumber getConjugate(){
        return new ComplexNumber(this.real,this.imaginary);
    }

    public ComplexNumber add(ComplexNumber num){
        return new ComplexNumber(this.real + num.real, this.imaginary + num.imaginary);
    }

    public ComplexNumber subtract(ComplexNumber num){
        return new ComplexNumber(this.real - num.real, this.imaginary - num.imaginary);
    }

    public ComplexNumber multiply(ComplexNumber num){
        return new ComplexNumber(this.real * num.real, this.imaginary * num.imaginary);
    }

    public ComplexNumber divide(ComplexNumber num){
        return new ComplexNumber(this.real / num.real, this.imaginary / num.imaginary);
    }


}
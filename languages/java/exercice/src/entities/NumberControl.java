package entities;

public class NumberControl {
    private int result;
    private int sumNumber1;
    private int sumNumber2;

    public NumberControl(int result, int sumNumber1, int sumNumber2) {
        this.result = result;
        this.sumNumber1 = sumNumber1;
        this.sumNumber2 = sumNumber2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getSumNumber1() {
        return sumNumber1;
    }

    public void setSumNumber1(int sumNumber1) {
        this.sumNumber1 = sumNumber1;
    }

    public int getSumNumber2() {
        return sumNumber2;
    }

    public void setSumNumber2(int sumNumber2) {
        this.sumNumber2 = sumNumber2;
    }
}


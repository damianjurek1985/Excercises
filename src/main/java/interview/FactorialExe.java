package interview;

public class FactorialExe {
    public static void main(String[] args) {

    }

    //toDo
    public static void factorialLastTwo (int number) {
        Integer myInf = Integer.MAX_VALUE;
        if(number>=0){
            int result = 1;
            for(int i=1; i <= number; i++){
                result = result*i;
            }
            System.out.println("Result from factorial is: " + result);
            if(result != myInf){

            }
        }
    }
}

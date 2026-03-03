package WorkSheet_2;

public class EqualCheck {
    public static void main(String[] args) {
        if(args.length != 3){
            System.out.print("Provide 3 Integer Values");
            return;
        }

        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if(a == b && b == c){
            System.out.print("Equal");
        }
        else {
            System.out.print("Not Equal");
        }

    }
}

public class AppleMain{
    
    public static void main(String[] args){
        System.out.println(IntegerEnum.I_A);
        Apple a = Apple.valueOf(args[0]);
        System.out.println(a.ordinal());
        System.out.println(Apple.A.ordinal());
        switch(a.toString()){
            case "A":
                System.out.println("A: aa");
                break;
            case "B":
                System.out.println("B: bb");
                break;
            case "C":
                System.out.println("C: cc");
                break;
            case "E":
                System.out.println("E: ee");
                break;
            default:
                System.out.println("default ...");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            switch (args[0].toLowerCase()) {
                case "v0" -> System.out.println(V0.func(Double.parseDouble(args[1])));
                case "v2"-> System.out.println(v2.func(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4])));
                case "v16"-> System.out.println(V16.func(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5])));
                //case "v2"-> System.out.println(v2.func(Double.parseDouble(args[1]))); что-то неправильно тут
                case "v14"->  System.out.println(V14.v14(Double.parseDouble(args[1])));
		        case "v7" -> System.out.println(V7.func(Double.parseDouble(args[1])));
                case "v13"->System.out.println(V13.func(Double.parseDouble(args[1])));
                case "v6" -> System.out.println(V6.function(Double.parseDouble(args[1])));
                case "V10" -> System.out.println(V10.v10(Double.parseDouble(args[1]), (Double.parseDouble(args[2])), (Double.parseDouble(args[3]))));
                case "v9"-> System.out.println(V9.funcV9(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3])) );
                case "v8" -> System.out.println(V8.func8(Double.parseDouble(args[1]),Double.parseDouble(args[2]),Double.parseDouble(args[3]),Double.parseDouble(args[4])));
                case "exit" -> {
                    System.out.println("Done");
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }
}

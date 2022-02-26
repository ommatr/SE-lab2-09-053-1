public class Main {
    public static void main(String[] args) {
        try {
            switch (args[0].toLowerCase()) {
                case "v0" -> System.out.println(V0.func(Double.parseDouble(args[1])));
<<<<<<< HEAD
                case "v2"-> System.out.println(v2.func(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4])));
                case "v16"-> System.out.println(V16.func(Double.parseDouble(args[1]), Double.parseDouble(args[2]), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5])));
=======
                case "v2"-> System.out.println(v2.func(Double.parseDouble(args[1])));
		case "v7" -> System.out.println(V7.func(Double.parseDouble(args[1])));
>>>>>>> 0cfa60545d020bc517d8753e1d724fd2b5fa3ebe
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

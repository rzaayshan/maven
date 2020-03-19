package app.lesson21;

public class StringOps {

        // abc -> ABC
        // aBc -> AbC
        // Abc -> aBC
        static String invertCase(String origin) {
            StringBuilder invert = new StringBuilder();
            for(int i=0;i<origin.length();i++){
                if(origin.charAt(i)<91)
                    invert.append((char)(origin.charAt(i)+32));
                else
                    invert.append((char)(origin.charAt(i)-32));
            }
            return invert.toString();
        }

        // abc -> ABC
        // aBc -> ABC
        // Abc -> ABC
        static String toUpperCase(String origin) { // a -> A A -> A
            StringBuilder invert = new StringBuilder();
            for(int i=0;i<origin.length();i++){
                if(origin.charAt(i)>91)
                    invert.append((char)(origin.charAt(i)-32));
                else
                    invert.append((char)(origin.charAt(i)));

            }
            return invert.toString();
        }

        // abc -> abc
        // aBc -> abc
        // Abc -> abc
        static String toLowerCase(String origin) { // A -> a a -> a
            StringBuilder invert = new StringBuilder();
            for(int i=0;i<origin.length();i++){
                if(origin.charAt(i)<91)
                    invert.append((char)(origin.charAt(i)+32));
                else
                    invert.append((char)(origin.charAt(i)));
            }
            return invert.toString();

        }
        public static void main(String[] args) {
            System.out.println(invertCase("AbC"));
            System.out.println(toUpperCase("aBc"));
            System.out.println(toLowerCase("Abc"));
        }



    }



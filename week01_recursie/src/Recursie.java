import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Recursie {


    // Oefening 1: n-de Fibonacci-getal

    public static int fibonacci(int getal) {
        if(getal < 0) throw new IllegalArgumentException();
        if(getal == 1 || getal == 2) return 1;

        else {
            return fibonacci(getal-1) + fibonacci(getal-2);
        }
    }

    // Oefening 2 : som van cijfers

    public static int somVanCijfers(int getal) {
        getal = Math.abs(getal);
        if (getal < 10) return getal;
        else {
            return getal % 10 + somVanCijfers(getal/10);
        }
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        String out = "";
        if(s == null) throw new IllegalArgumentException();
        if(s.length() <= 1) return s;
        else {
            return s.charAt(s.length()-1) + keerOm(s.substring(0,s.length()-1));
        }
    }

    //oefening 4: countX

    public static int countX(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length() == 0) return 0;
        else{
            return (s.charAt(0)=='x' ? 1 : 0) + countX(s.substring(1));
        }
    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if(s == null) throw new IllegalArgumentException();
        if(s.length()<=1) return 0;
        else {
            return (s.substring(0,2).toLowerCase(Locale.ROOT).equals("hi") ? 1 : 0) + countHi(s.substring(1));
        }
    }

    // oefening 6
    public static String changeXY(String s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 7

    public static String changePi(String s) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 8:
    public static int tweelog(int getal) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String string) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // oefening 11;
    public static int aantalKaarten(int n){
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
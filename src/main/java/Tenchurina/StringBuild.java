package Tenchurina;



public class StringBuild {
    public String masIntToString(int[] massiv) {
        String str="";
        for( int m : massiv){
            str = str +" "+ Integer.toString(m);
        }
        return  str;
    }

    public void generateException() {
        throw new RuntimeException();
    }
}

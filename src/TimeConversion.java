public class TimeConversion {
    public static void main(String[] arg){
        String s = "12:05:39AM";
        String result = TimeConversion.convertTime(s);
        System.out.println(result);
    }

    static String convertTime(String s) {
        String result = "";
        if (s.contains("PM")) {
            String str = s.substring(2, s.length() - 2);
            int hh = Integer.parseInt(s.substring(0, 2));
            if(hh == 12){
                return result = Integer.toString(hh).concat(str);
            }else{
                hh = 12 +  Integer.parseInt(s.substring(0, 2));
                return result = Integer.toString(hh).concat(str);
            }

        } else {
            String str = s.substring(2, s.length() - 2);
            int hh = Integer.parseInt(s.substring(0, 2));
            if (hh == 12) {
                hh = 00;
                String hour = String.format("%02d",hh);
                return result = hour.concat(str);
            }else{
                return result = Integer.toString(hh).concat(str);
            }
        }
    }
}

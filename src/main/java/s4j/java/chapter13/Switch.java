package s4j.java.chapter13;

public class Switch {
    public static void main(String... args) {
        String month = "August";
        String quarter;
        switch (month) {
            case "January":
            case "February":
            case "March":
                quarter = "1st quarter";
                break;
            case "April":
            case "May":
            case "June":
                quarter = "2nd quarter";
                break;
            case "July":
            case "August":
            case "September":
                quarter = "3rd quarter";
                break;
            case "October":
            case "November":
            case "December":
                quarter = "4th quarter";
                break;
            default:
                quarter = "unknown quarter";
                break;
        }
        System.out.println(quarter);
    }

}

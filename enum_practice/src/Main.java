public class Main {
    public static void main(String[] args) {

        System.out.println(howLongCanThisGoOn(WeekDays.MONDAY));
        System.out.println(howLongCanThisGoOn(WeekDays.SATURDAY));
        System.out.println(howLongCanThisGoOn(WeekDays.FRIDAY));
        System.out.println(howLongCanThisGoOn(WeekDays.SUNDAY));
    }
    //Метод возвращает количество оставшихся часов рабочей недели в зависимости от введенного дня недели
    static String howLongCanThisGoOn(WeekDays w){
        int timeLeft = 40;
        if (w.isWorkDay()){
            timeLeft-=w.ordinal()*8;
            return ("До конца рабочей недели осталось часов: " + Integer.toString(timeLeft));
        }else return "Выходной день";
    }
}

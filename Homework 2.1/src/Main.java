
public class Main {
    public static void main(String[] args) {

        Sportsman s1 = new Sportsman("Alyosha", 10000, 3000, 3);
        Sportsman s2 = new Sportsman("Fedya", 12000, 5000, 4);
        Sportsman s3 = new Sportsman("Sasha", 8000, 4000, 2);
        Sportsman s4 = new Sportsman("Pasha", 7000, 6000, 2);

        Team dreamTeam = new Team(s1, s2, s3, s4);

        Course olympics = new Course(10000, 3000, 2);
        olympics.doIt(dreamTeam);
        dreamTeam.showResults(olympics, dreamTeam);

//Пример успешно пройденного состязания
//        Course training = new Course(1000, 1000, 1);
//        dreamTeam.showResults(training, dreamTeam);
    }
}

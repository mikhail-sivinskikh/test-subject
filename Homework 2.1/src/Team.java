public class Team {

    private Sportsman s1;
    private Sportsman s2;
    private Sportsman s3;
    private Sportsman s4;

    public Team(Sportsman s1, Sportsman s2, Sportsman s3, Sportsman s4) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        this.s4 = s4;
    }


    Sportsman getS1() {
        return s1;
    }

    Sportsman getS2() {
        return s2;
    }

    Sportsman getS3() {
        return s3;
    }

    Sportsman getS4() {
        return s4;
    }

    //метод выводит результаты каждого спортсмена по прохождению каждого препятствия и дает комментарий на том этапе, когда состязание оканчивается
    void showResults(Course c, Team t) {
        Sportsman[] theTeam = new Sportsman[4];
        theTeam[0] = t.getS1();
        theTeam[1] = t.getS2();
        theTeam[2] = t.getS3();
        theTeam[3] = t.getS4();
        boolean lost = false;
        System.out.println("Спортсменам предстоят следующие препятстаия: Прыжок в длину(м): " + c.getJumping() + " Забег на дистанцию(м): " + c.getRunning() + "Заплыв на дистанцию(м): " + c.getSwimming());

        if (!lost) {
            for (Sportsman aTheTeam : theTeam) {
                if (aTheTeam.getJumpDistance() >= c.getJumping()) {
                    System.out.println("Спортсмен " + aTheTeam.getName() + " справился с прыжком!");
                } else {
                    System.out.println("Какая досада, спортсмен " + aTheTeam.getName() + " не справился с прыжком, команда выбывает из чемпионата!");
                    lost = true;
                    break;
                }
            }
        }
        if (!lost) {
            for (Sportsman aTheTeam : theTeam) {
                if (aTheTeam.getRunDistance() >= c.getRunning()) {
                    System.out.println("Спортсмен " + aTheTeam.getName() + " справился с забегом!");
                } else {
                    System.out.println("Какая досада, спортсмен " + aTheTeam.getName() + " не справился с забегом, команда выбывает из чемпионата!");
                    lost = true;
                    break;
                }
            }
        }
        if (!lost) {
            for (int i = 0; i < theTeam.length; i++) {
                if (theTeam[i].getSwimDistance() >= c.getSwimming()) {
                    System.out.println("Спортсмен " + theTeam[i].getName() + " справился с заплывом!");
                    if (i == theTeam.length - 1) {
                        System.out.println("Ура! команда прошла все препятствия успешно!");
                    }
                } else {
                    System.out.println("Какая досада, спортсмен " + theTeam[i].getName() + " не справился с забегом, команда выбывает из чемпионата!");
                    lost = true;
                    break;
                }
            }
        }
    }
}


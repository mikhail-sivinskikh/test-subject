public class Course {
    private int running;
    private int swimming;
    private int jumping;

    int getRunning() {
        return running;
    }

    int getSwimming() {
        return swimming;
    }

    int getJumping() {
        return jumping;
    }

    Course(int running, int swimming, int jumping) {
        this.running = running;
        this.swimming = swimming;
        this.jumping = jumping;
    }

    //проверяем прошла ли вся команда все испытания или нет, в результате выводим на экран только результат
    void doIt(Team t) {
        int passed = 0;
        if (t.getS1().getRunDistance() >= running) {
            if (t.getS1().getSwimDistance() >= swimming) {
                if (t.getS1().getJumpDistance() >= jumping) {
                    passed++;
                }
            }
        }
        if (t.getS2().getRunDistance() >= running) {
            if (t.getS2().getSwimDistance() >= swimming) {
                if (t.getS2().getJumpDistance() >= jumping) {
                    passed++;
                }
            }
        }
        if (t.getS3().getRunDistance() >= running) {
            if (t.getS3().getSwimDistance() >= swimming) {
                if (t.getS3().getJumpDistance() >= jumping) {
                    passed++;
                }
            }
        }
        if (t.getS4().getRunDistance() >= running) {
            if (t.getS4().getSwimDistance() >= swimming) {
                if (t.getS4().getJumpDistance() >= jumping) {
                    passed++;
                }
            }
        }
        if (passed == 4) {
            System.out.println();
            System.out.println("Результат проведения соревнования: команда справилась с заданием");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Результат проведения соревнования: команда не справилась с заданием");
            System.out.println();
        }
    }
}






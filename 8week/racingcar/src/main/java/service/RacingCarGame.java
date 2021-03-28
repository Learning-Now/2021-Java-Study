package service;

public class RacingCarGame {

    public void start() {
        RacingCarGameController controller = new RacingCarGameController();
        controller.gameSetting();
        controller.run(controller.count, controller.cars);
        controller.findWinner(controller.cars);
    }

}

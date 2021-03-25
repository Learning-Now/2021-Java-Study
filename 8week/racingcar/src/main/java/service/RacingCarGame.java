package service;

public class RacingCarGame extends RacingCarGameController {

    public void start() {
        RacingCarGameController controller = new RacingCarGameController();
        controller.carSetting();
        controller.countSetting();
        controller.run(controller.count, controller.cars);
        controller.findWinner(controller.cars);
    }

}

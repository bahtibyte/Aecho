package bahti.gui;

import bahti.tank.World;
import bahti.helper.CurrentGui;
import bahti.tank.Tank;

public class Game extends Gui{
	
    public static MainMenu theMenu;
    public static JoinMenu joinMenu;
    public static CreateMenu createMenu;
    public static MainGame mainGame;
    public static CurrentGui currentGui;

    private final int tps;
    private final int fps;

    public Game() {
        super(1920,1080,"Aecho");
        createGui();
        finishGui();

        theMenu = new MainMenu();
        joinMenu = new JoinMenu();
        createMenu = new CreateMenu();
        mainGame = new MainGame();
        currentGui = new CurrentGui(theMenu);

        tps = 60;
        fps = 100;

        run();
        renderer();
    }

    public void run() {
        new Thread() {
            public void run() {
                int delay = 1000 / tps;
                while(true) {

                    currentGui.onTick();

                    try{ 
                            Thread.sleep(delay);
                    }catch (Exception e){
                            e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    private void renderer() {
        new Thread() {
            public void run() {
                int delay = 1000 / fps;
                while(true) {

                    currentGui.render();

                    try {
                            Thread.sleep(delay);
                    }catch(Exception e) {
                            e.printStackTrace();
                    }
                }
            }
        }.start();
    }
	
}

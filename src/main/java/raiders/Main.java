package raiders;

import engine.io.Window;

public class Main implements Runnable {

    public Thread game;
    public static Window window;
    public static final int WIDTH = 1920, HEIGHT = 1080;

    public void start() {
        game = new Thread(this, "game");
        game.start();
    }

    public static void init() {
        System.out.println("Initializing Star Raiders");
        window = new Window(WIDTH, HEIGHT, "Star Raiders");
        window.create();
    }

    public void run() {
        init();
        while (!window.shouldClose()) {
            update();
            render();
        }
    }

    private void update() {
        window.update();
    }

    private void render() {
        window.swapBuffers();
    }

    public static void main(String[] args) {
        new Main().start();
    }

}

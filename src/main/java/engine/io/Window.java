package engine.io;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWVidMode;

public class Window {

    private int width, height;
    private String title;
    private long window;

    public Window(int width, int height, String title) {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    public void create() {
        if (!GLFW.glfwInit()) { // error handling
            System.err.println("ERROR: GLFW wasn't initialized");
            return;
        }

        window = GLFW.glfwCreateWindow(width, height, title, 0, 0);

        if (window == 0) { // error handling
            System.err.println("ERROR: Window wasn't created");
            return;
        }

        GLFWVidMode videoMode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(window, (videoMode.width() -  width) / 2, (videoMode.height() -  height) / 2);
        GLFW.glfwMakeContextCurrent(window);

        GLFW.glfwShowWindow(window);

        GLFW.glfwSwapInterval(1); // limits frame rate to vsync... TODO possible work around?
    }

    public void update() {
        GLFW.glfwPollEvents();
    }

    public void swapBuffers() {
        GLFW.glfwSwapBuffers(window);
    }

    public boolean shouldClose() {
        return GLFW.glfwWindowShouldClose(window);
    }

}

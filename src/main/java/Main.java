import Engine.*;
import Engine.Object;
import org.joml.Vector2f;
import org.joml.Vector3f;
import org.joml.Vector4f;
import org.lwjgl.opengl.GL;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window = new Window(800,800,"hello world");
    ArrayList<Object> objects = new ArrayList<>();
    ArrayList<Object> objectsRectangle = new ArrayList<>();
    ArrayList<Circle> objectsCircle = new ArrayList<>();
    ArrayList<Rectangle> objectStar = new ArrayList<>();
    ArrayList<Object> objectPointControl = new ArrayList<>();
    ArrayList<Rectangle> objectLineRec = new ArrayList<>();
    ArrayList<Object> objectLengkung = new ArrayList<>();


    public void run() {
        init();
        loop();

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    public void init(){
        window.init();
        GL.createCapabilities();
        // code dibawah createCapabilities
//        objects.add(new Object2D(
//                        Arrays.asList(
//                                //ShaderFile lokasi menyesuaikan object
//                                new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                                , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of( //TITIK UNTUK SEGITIGANYA
//                                new Vector3f(0.0f, 0.5f,0.0f),
//                                new Vector3f(-0.5f,-0.5f,0.0f),
//                                new Vector3f(0.5f,-0.5f,0.0f)
//                        )
//                ),
//                new Vector4f(0.0f,0.0f,1.0f,1.0f)
//        ));
//        objects.add(new Object2D(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/sceneWithVerticesColor.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/sceneWithVerticesColor.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK SEGITIGANYA
//                        new Vector3f(0.0f, 0.5f,0.0f),
//                        new Vector3f(-0.5f,-0.5f,0.0f),
//                        new Vector3f(0.5f,-0.5f,0.0f)
//                )
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK SEGITIGANYA
//                        new Vector3f(1.0f, 0.0f,0.0f),
//                        new Vector3f(0.0f,1.0f,0.0f),
//                        new Vector3f(0.0f,0.0f,1.0f)
//                ))
//        ));
//                objectsRectangle.add(new Rectangle(
//                        Arrays.asList(
//                                //ShaderFile lokasi menyesuaikan object
//                                new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                                , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                        ), new ArrayList<>(
//                        List.of( //TITIK UNTUK Tanah
//                                new Vector3f(-1.0f, -0.5f,0.0f),
//                                new Vector3f(1.0f,-0.5f,0.0f),
//                                new Vector3f(1.0f,-1.0f,0.0f),
//                                new Vector3f(-1.0f,-1.0f,0.0f)
//                        )
//                        ),
//                        new Vector4f(0.05f,0.313f,0.0f,1.0f),
//                        Arrays.asList(0,1,2,2,3,0)
//
//        ));
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK Langit
//                        new Vector3f(-1.0f, 1.0f,0.0f),
//                        new Vector3f(1.0f,1.0f,0.0f),
//                        new Vector3f(1.0f,-0.5f,0.0f),
//                        new Vector3f(-1.0f,-0.5f,0.0f)
//                )
//        ),
//                new Vector4f(0.011f,0.0f,0.313f,1.0f),
//                Arrays.asList(0,1,2,2,3,0)
//
//        ));
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK Body rumah
//                        new Vector3f(-0.6f, -0.2f,0.0f),
//                        new Vector3f(0.6f,-0.2f,0.0f),
//                        new Vector3f(0.6f,-0.8f,0.0f),
//                        new Vector3f(-0.6f,-0.8f,0.0f)
//                )
//        ),
//                new Vector4f(0.85f,0.55f,0.04f,1.0f),
//                Arrays.asList(0,1,2,2,3,0)
//
//        ));
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK Atap merah
//                        new Vector3f(-0.5f, 0.3f,0.0f),
//                        new Vector3f(0.5f,0.3f,0.0f),
//                        new Vector3f(-0.7f,-0.2f,0.0f),
//                        new Vector3f(0.7f,-0.2f,0.0f)
//                )
//        ),
//                new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0,1,2,1,2,3)
//
//        ));
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK segitiga rumah
//                        new Vector3f(-0.35f, -0.2f,0.0f),
//                        new Vector3f(-0.5f,0.15f,0.0f),
//                        new Vector3f(-0.6f,-0.1f,0.0f),
//                        new Vector3f(-0.6f,-0.2f,0.0f)
//                )
//        ),
//                new Vector4f(0.85f,0.55f,0.04f,1.0f),
//                Arrays.asList(0,1,2,2,0,3)
//
//        ));
//
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK Atap merah
//                        new Vector3f(0.2f, 0.35f,0.0f),
//                        new Vector3f(0.3f,0.35f,0.0f),
//                        new Vector3f(0.3f,0.1f,0.0f),
//                        new Vector3f(0.2f, 0.1f,0.0f)
//                )
//        ),
//                new Vector4f(0.85f,0.55f,0.04f,1.0f),
//                Arrays.asList(0,1,2,2,3,0)
//
//        ));
//        objectsRectangle.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ), new ArrayList<>(
//                List.of( //TITIK UNTUK cerobong asap
//                        new Vector3f(0.17f, 0.4f,0.0f),
//                        new Vector3f(0.33f,0.4f,0.0f),
//                        new Vector3f(0.33f,0.35f,0.0f),
//                        new Vector3f(0.17f, 0.35f,0.0f)
//                )
//        ),
//                new Vector4f(1.0f,0.0f,0.0f,1.0f),
//                Arrays.asList(0,1,2,2,3,0)
//
//
//        ));
//
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                //ShaderFile lokasi menyesuaikan object
//                new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Circle.createCircle(-0.7f,0.7f,0.15f,0.15f),
//                new Vector4f(0.96f,1.0f,0.49f,0.0f)
//        ));
//
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Circle.createCircle(-0.65f,0.7f,0.13f,0.15f),
//                new Vector4f(0.011f,0.0f,0.313f,1.0f)
//        ));
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Circle.createCircle(0.25f,0.5f,0.07f,0.05f),
//                new Vector4f(0.29f,0.29f,0.29f,0.0f)
//        ));
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Circle.createCircle(0.29f,0.55f,0.1f,0.05f),
//                new Vector4f(0.29f,0.29f,0.29f,0.0f)
//        ));
//        objectsCircle.add(new Circle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Circle.createCircle(0.35f,0.6f,0.13f,0.05f),
//                new Vector4f(0.29f,0.29f,0.29f,0.0f)
//        ));
//        objectStar.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Rectangle.createStar(0.0f,0.75f,0.03f,0.03f),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                Arrays.asList(0,2,4,4,1,3)
//        ));
//
//        objectStar.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Rectangle.createStar(0.7f,0.7f,0.05f,0.05f),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                Arrays.asList(0,2,4,4,1,3)
//        ));
//
//        objectStar.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),Rectangle.createStar(-0.4f,0.6f,0.05f,0.05f),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                Arrays.asList(0,2,4,4,1,3)
//        ));
        objectPointControl.add(new Object(
                        Arrays.asList(
                                //ShaderFile lokasi menyesuaikan object
                                new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
                                , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
                        ),
                new ArrayList<>()
//                        objectLineRec.add(new Rectangle(
//                                Arrays.asList(
//                                        //ShaderFile lokasi menyesuaikan object
//                                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                                ),Rectangle.createStar(pos.x,0.6f,0.05f,0.05f),
//                                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                                Arrays.asList(0,2,4,4,1,3)
//                        ));
                ,
                new Vector4f(0.0f,1.0f,1.0f,1.0f)
        ));
        objects.add(new Sphere(
                        Arrays.asList(
                                //ShaderFile lokasi menyesuaikan object
                                new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
                                , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
                        ), new ArrayList<>(
                        List.of( //TITIK UNTUK SEGITIGANYA
                                new Vector3f(-0.5f, 0.5f,0.0f),
                                new Vector3f(-0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,-0.5f,0.0f),
                                new Vector3f(0.5f,0.5f,0.0f)
                        )
                ),
                new Vector4f(0.0f,1.0f,1.0f,1.0f),
                Arrays.asList(0.0f,0.0f,0.0f),
                0.2f,
                0.5f,
                0.4f
        ));

//        objectLineRec.add(new Rectangle(
//                Arrays.asList(
//                        //ShaderFile lokasi menyesuaikan object
//                        new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
//                        , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
//                ),new ArrayList<>(),
//                new Vector4f(1.0f,1.0f,1.0f,0.0f),
//                Arrays.asList(0,2,4,4,1,3)
//        ));


    }
    public void loop(){
        while (window.isOpen()) {
            window.update();
            glClearColor(0.0f,0.0f,0.0f,0.0f);
            GL.createCapabilities();
            input();

            objectLengkung.add(new Object(
                    Arrays.asList(
                            //ShaderFile lokasi menyesuaikan object
                            new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
                            , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
                    ),lengkung(),
                    new Vector4f(0.0f,1.0f,0.0f,1.0f)
            ));
            // code harus dibawah Gl.createCapabilities dan diatas glDisableVertex

            for(Object object:objects) {
                object.draw();
            }
            for(Object object:objectsRectangle) {
                object.draw();
            }
            for(Object object:objectsCircle) {
                object.draw();
            }
            for(Rectangle object:objectStar) {
                object.drawStar();
            }
            for(Object object:objectPointControl) {
                object.drawLine();
            }
            for(Object object:objectLineRec) {
                object.drawRec();
            }
            for (Object object:objectLengkung) {
                object.drawLine();
            }
            glDisableVertexAttribArray(0);
            glfwPollEvents();
        }
    }
    public void input() {
        if (window.isKeyPressed(GLFW_KEY_W)) {
            System.out.println("W");
        }
        if (window.getMouseInput().isLeftButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);

            if ((!(pos.x > 1 || pos.x < -0.97) && !(pos.y > 0.97 || pos.y < -1))) {
                System.out.println("x : " + pos.x + "y : " + pos.y);





                if (objectLineRec.isEmpty() || Collision(pos) == -1) {
                    objectLineRec.add(new Rectangle(
                            Arrays.asList(
                                    //ShaderFile lokasi menyesuaikan object
                                    new ShaderProgram.ShaderModuleData("resources/shadder/scene.vert", GL_VERTEX_SHADER)
                                    , new ShaderProgram.ShaderModuleData("resources/shadder/scene.frag", GL_FRAGMENT_SHADER)
                            ), createRec(pos.x, pos.y, 0.05f, 0.05f),
                            new Vector4f(1.0f, 1.0f, 1.0f, 0.0f),
                            Arrays.asList(0, 2, 4, 4, 1, 3), pos.x, pos.y
                    ));
                    objectPointControl.get(0).addVertices(new Vector3f(pos.x, pos.y, 0));
                    System.out.println(objectPointControl.get(0).vertices);

                }





                }



        }

        if (window.getMouseInput().isRightButtonPressed()) {
            Vector2f pos = window.getMouseInput().getCurrentPos();

            pos.x = (pos.x - (window.getWidth())/2.0f) / (window.getWidth()/2.0f);
            pos.y = (pos.y - (window.getHeight())/2.0f) / (-window.getHeight()/2.0f);
            if (!objectLineRec.isEmpty() && Collision(pos) != -1) {
//                while (!window.getMouseInput().isRightButtonReleased()) {
                int curBox = Collision(pos);
                objectLineRec.get(curBox).setVertices(createRec(pos.x, pos.y, 0.05f, 0.05f));
                objectLineRec.get(curBox).setupVAOVBO();
                objectPointControl.get(0).setDot(curBox, new Vector3f(pos.x, pos.y, 0));
                objectPointControl.get(0).setupVAOVBO();
//                }
            }


        }
    }
    public static List<Vector3f> createRec(float x, float y, float rx, float ry) {
        List<Vector3f> Rec = new ArrayList<>();
        double i = 45;
        int count = 1;
        while (i<= 315) {

            float xt = (float) (x+0.05f * -Math.sin(Math.toRadians(i)));
            float yt = (float) (y+0.05f * Math.cos(Math.toRadians(i)));
            float z = 0;
            Rec.add(new Vector3f (xt,yt,z));
            System.out.println(xt);
            i+=90;
            count++;


        }
        return Rec;
    }

    public int factorial(int fact) {
        if (fact <= 1)
            return 1;
        else {
            return fact * factorial(fact-1);
        }
    }

    public int combination(int n, int r) {
        return factorial(n) / (factorial(r)*factorial(n-r));
    }

    public List<Vector3f> lengkung() {
        objectLengkung.clear();
        ArrayList<Integer> pascal = new ArrayList<>();
        List<Vector3f> vertices = new ArrayList<>();

        for (int i = 0; i<objectPointControl.get(0).getVerticesSize();i++) {
            pascal.add(combination(objectPointControl.get(0).getVerticesSize()-1,i));
        }

        if (objectPointControl.get(0).getVerticesSize() >= 3) {
            for (double t = 0; t<= 1; t+=0.01) {
                float x = 0;
                float y = 0;
                for (int i = 0; i < objectPointControl.get(0).getVerticesSize(); i++) {
                    x += pascal.get(i) * (objectPointControl.get(0).getVerticesX(i) * Math.pow(1-t, (objectPointControl.get(0).getVerticesSize()-1)-i) * Math.pow(t, i));
                    y += pascal.get(i) * (objectPointControl.get(0).getVerticesY(i) * Math.pow(1-t, (objectPointControl.get(0).getVerticesSize()-1)-i) * Math.pow(t, i));
                }
                vertices.add(new Vector3f(x,y,0));
            }
        }

        return vertices;


    }




    public int Collision(Vector2f pos) {
        int index = 0;
        int collision = -1;
        boolean boolX = false;
        boolean boolY = false;

        for (Vector3f object : objectPointControl.get(0).vertices) {
            if (pos.x <= (object.x + 0.1f) && pos.x >= (object.x - 0.1f))
                boolX = true;
            if (pos.y <= (object.y + 0.1f) && pos.y >= (object.y - 0.1f))
                boolY = true;

            if (boolX && boolY) {
                collision = index;
                break;
            }

            index++;

        }
        return collision;
    }
    public static void main(String[] args) {
        new Main().run();
    }
}

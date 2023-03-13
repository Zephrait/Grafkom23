package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Rectangle extends Object {
    List<Integer> index;
    int ibo;
    float x;
    float y;
//    index buffer objext || element buffer object
    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);

    }

    public Rectangle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Integer> index, float x, float y) {
        super(shaderModuleDataList, vertices, color);
        this.index = index;
        ibo = glGenBuffers();
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);
        this.x = x;
        this.y = y;


    }
    public static List<Vector3f> createStar(float x,float y, float rx,float ry) {
        List<Vector3f> circle = new ArrayList<>();

        for (double i = 0; i<=360;i+=72) {
            float xt = (float) (x+rx * -Math.sin(Math.toRadians(i)));
            float yt = (float) (y+ry * -Math.cos(Math.toRadians(i)));
            float z = 0;
            circle.add(new Vector3f (xt,yt,z));
            System.out.println(xt);


        }
        return circle;
    }
    public void setVertices(List<Vector3f> vertices) {
        this.vertices = vertices;
    }



    public void draw() {
        drawSetup();
//        BIND IBO & DRAW
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);

    }
    public void drawStar() {
        drawSetup();
//        BIND IBO & DRAW
        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
        glDrawElements(GL_LINE_LOOP,index.size(),GL_UNSIGNED_INT,0);

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }
}

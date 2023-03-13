package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL30.*;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

public class Object extends ShaderProgram {
    public List<Vector3f> vertices;
    int vao;
    int vbo;
    Vector4f color;
    UniformsMap uniformsMap;
    List<Vector3f> verticesColor;
    int vboColor;

    public Object(List<ShaderModuleData> shaderModuleDataList,
                  List<Vector3f> vertices, Vector4f color) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
        this.color = color;
        uniformsMap = new UniformsMap(getProgramId());
        uniformsMap.createUniform("uni_color");

    }
    public Object(List<ShaderModuleData> shaderModuleDataList,
                  List<Vector3f> vertices, List<Vector3f> verticesColor) {
        super(shaderModuleDataList);

        this.vertices = vertices;
        this.verticesColor = verticesColor;
        setupVAOVBOWithVerticesColor();


    }
    public void setupVAOVBO() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);
    }
    public void setupVAOVBOWithVerticesColor() {
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(vertices), GL_STATIC_DRAW);

        vboColor = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glBufferData(GL_ARRAY_BUFFER, Utils.listoFloat(verticesColor), GL_STATIC_DRAW);
    }

    public void drawSetup() {
        bind();
        uniformsMap.setUniform("uni_color", color);
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);
    }
    public void drawSetupWithVerticesColor() {
        bind();
//        Bind VBO
        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER, vbo);
        glVertexAttribPointer(0,3,GL_FLOAT, false,0,0);
//        Bind VBOColor
        glEnableVertexAttribArray(1);
        glBindBuffer(GL_ARRAY_BUFFER, vboColor);
        glVertexAttribPointer(1,3,GL_FLOAT, false,0,0);
    }
    public int getVerticesSize() {
        return vertices.size();
    }

    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
    public void drawLine() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }

    public void addVertices(Vector3f newVector) {
        vertices.add(newVector);
        setupVAOVBO();
    }
    public void setDot(int index, Vector3f newVector) {
        vertices.set(index,newVector);
    }

    public float getVerticesX(int index) {
        return vertices.get(index).x;
    }
    public float getVerticesY(int index) {
        return vertices.get(index).y;
    }


    public void addRec(List<Vector3f> vertices) {
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void drawRec() {
        drawSetup();
        glLineWidth(10);
        glPointSize(10);
        glDrawArrays(GL_TRIANGLE_FAN, 0, vertices.size());

    }

    public void drawWithVerticesColor() {
        drawSetupWithVerticesColor();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES, 0, vertices.size());
    }
}

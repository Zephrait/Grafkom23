package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;

public class Sphere extends Circle{
    int ibo;
    float radiusZ;
    ArrayList<Vector3f> index;
    public Sphere(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY, Float radiusZ) {
        super(shaderModuleDataList, vertices, color, centerPoint, radiusX, radiusY);
        this.radiusZ = radiusZ;
        createElipsoid();
        setupVAOVBO();
    }

    public void createBox() {

        Vector3f temp = new Vector3f();
        ArrayList<Vector3f> tempVertices = new ArrayList<>();
//        Titik 1 kiri atas belakang
        temp.x = centerPoint.get(0) - radiusX /2;
        temp.y = centerPoint.get(1) + radiusY /2;
        temp.z = centerPoint.get(2) - radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 2 kiri bawah belakang
        temp.x = centerPoint.get(0) - radiusX /2;
        temp.y = centerPoint.get(1) - radiusY /2;
        temp.z = centerPoint.get(2) - radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 3 kanan bawah belakang
        temp.x = centerPoint.get(0) + radiusX /2;
        temp.y = centerPoint.get(1) - radiusY /2;
        temp.z = centerPoint.get(2) - radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 4 kanan atas belakang
        temp.x = centerPoint.get(0) + radiusX /2;
        temp.y = centerPoint.get(1) + radiusY /2;
        temp.z = centerPoint.get(2) - radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 5 kiri atas depan
        temp.x = centerPoint.get(0) - radiusX /2;
        temp.y = centerPoint.get(1) + radiusY /2;
        temp.z = centerPoint.get(2) + radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 6 kiri bawah depan
        temp.x = centerPoint.get(0) - radiusX /2;
        temp.y = centerPoint.get(1) - radiusY /2;
        temp.z = centerPoint.get(2) + radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 7 kanan bawah depan
        temp.x = centerPoint.get(0) + radiusX /2;
        temp.y = centerPoint.get(1) - radiusY /2;
        temp.z = centerPoint.get(2) + radiusZ /2;
        tempVertices.add(temp);
        temp = new Vector3f();
//        Titik 8 kanan atas depan
        temp.x = centerPoint.get(0) + radiusX /2;
        temp.y = centerPoint.get(1) + radiusY /2;
        temp.z = centerPoint.get(2) + radiusZ /2;
        tempVertices.add(temp);

        temp = new Vector3f();
//        kotak belakang
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));

        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(0));
//      kotak depan
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
//      kotak samping kiri
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(4));

        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(1));
//      kotak samping kanan
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(2));
//      kotak atas
        vertices.add(tempVertices.get(0));
        vertices.add(tempVertices.get(3));
        vertices.add(tempVertices.get(7));

        vertices.add(tempVertices.get(7));
        vertices.add(tempVertices.get(4));
        vertices.add(tempVertices.get(0));
//      kotak bawah
        vertices.add(tempVertices.get(1));
        vertices.add(tempVertices.get(2));
        vertices.add(tempVertices.get(6));

        vertices.add(tempVertices.get(6));
        vertices.add(tempVertices.get(5));
        vertices.add(tempVertices.get(1));



    }

    public void createSphere() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.5f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Vector3f> temp_indices = new ArrayList<>();
//        for(int i=0;i<stackCount;i++){
//            k1 = i * (sectorCount + 1);
//            k2 = k1 + sectorCount + 1;
//
//            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
//                if(i != 0){
//                    temp_indices.add(k1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k1+1);
//                }
//                if(i!=(18-1)){
//                    temp_indices.add(k1+1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k2+1);
//                }
//            }
//        }

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float tempX = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float tempY = 0.5f * (float)(Math.cos(v) * Math.sin(u));
                float tempZ = 0.5f * (float)(Math.sin(v));
                temp_indices.add(new Vector3f(tempX,tempY,tempZ));
            }
        }

        this.index = temp_indices;

//        ibo = glGenBuffers();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);


    }

    public void createElipsoid() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.3f * Math.cos(stackAngle));
            z = (float) (0.5f * Math.sin(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy * 2 * Math.cos(sectorAngle));
                y = (float) (xy * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Vector3f> temp_indices = new ArrayList<>();
//        for(int i=0;i<stackCount;i++){
//            k1 = i * (sectorCount + 1);
//            k2 = k1 + sectorCount + 1;
//
//            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
//                if(i != 0){
//                    temp_indices.add(k1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k1+1);
//                }
//                if(i!=(18-1)){
//                    temp_indices.add(k1+1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k2+1);
//                }
//            }
//        }

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float tempX = 0.5f * (float)(Math.cos(v) * Math.cos(u));
                float tempY = 0.2f * (float)(Math.cos(v) * Math.sin(u));
                float tempZ = 0.2f * (float)(Math.sin(v));
                temp_indices.add(new Vector3f(tempX,tempY,tempZ));
            }
        }

        this.vertices = temp_indices;

//        ibo = glGenBuffers();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);


    }

    public void createHyperboloid1() {
        vertices.clear();
        ArrayList<Vector3f> temp = new ArrayList<>();
        int stackCount = 18, sectorCount = 36;
        float x,y,z,xy,nx,ny,nz;
        float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
        float stackStep = (float)Math.PI / stackCount; // stack count
        float sectorAngle, stackAngle;

        for(int i=0;i<=stackCount;i++){
            stackAngle = (float)Math.PI/2 - i * stackStep;
            xy = (float) (0.1f * (1/Math.cos(stackAngle)));
            z = (float) (0.05f * Math.tan(stackAngle));
            for(int j=0;j<sectorCount;j++){
                sectorAngle = j * sectorStep;
                x = (float) (xy/2 * Math.cos(sectorAngle));
                y = (float) (xy/2 * Math.sin(sectorAngle));
                temp.add(new Vector3f(x,y,z));
            }
        }
        vertices = temp;

        int k1, k2;
        ArrayList<Vector3f> temp_indices = new ArrayList<>();
//        for(int i=0;i<stackCount;i++){
//            k1 = i * (sectorCount + 1);
//            k2 = k1 + sectorCount + 1;
//
//            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
//                if(i != 0){
//                    temp_indices.add(k1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k1+1);
//                }
//                if(i!=(18-1)){
//                    temp_indices.add(k1+1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k2+1);
//                }
//            }
//        }

        for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
            for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
                float tempX = 0.5f * (float)((1/Math.cos(v)) * Math.cos(u));
                float tempZ = 0.5f * (float)((1/Math.cos(v)) * Math.sin(u));
                float tempY = 0.5f * (float)(Math.tan(v));
                temp_indices.add(new Vector3f(tempX,tempY,tempZ));
            }
        }

        this.vertices = temp_indices;

//        ibo = glGenBuffers();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);


    }
//    public void draw() {
//        drawSetup();
////        BIND IBO & DRAW
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glDrawElements(GL_TRIANGLES,index.size(),GL_UNSIGNED_INT,0);
//
//    }
public void createElipticCone() {
    vertices.clear();
    ArrayList<Vector3f> temp = new ArrayList<>();
    int stackCount = 18, sectorCount = 36;
    float x,y,z,xy,nx,ny,nz;
    float sectorStep = (float)(2* Math.PI )/ sectorCount; //sector count
    float stackStep = (float)Math.PI / stackCount; // stack count
    float sectorAngle, stackAngle;

    for(int i=0;i<=stackCount;i++){
        stackAngle = (float)Math.PI/2 - i * stackStep;
        xy = (float) (0.1f * (1/Math.cos(stackAngle)));
        z = (float) (0.05f * Math.tan(stackAngle));
        for(int j=0;j<sectorCount;j++){
            sectorAngle = j * sectorStep;
            x = (float) (xy/2 * Math.cos(sectorAngle));
            y = (float) (xy/2 * Math.sin(sectorAngle));
            temp.add(new Vector3f(x,y,z));
        }
    }
    vertices = temp;

    int k1, k2;
    ArrayList<Vector3f> temp_indices = new ArrayList<>();
//        for(int i=0;i<stackCount;i++){
//            k1 = i * (sectorCount + 1);
//            k2 = k1 + sectorCount + 1;
//
//            for(int j=0;j<sectorCount;++j, ++k1, ++k2){
//                if(i != 0){
//                    temp_indices.add(k1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k1+1);
//                }
//                if(i!=(18-1)){
//                    temp_indices.add(k1+1);
//                    temp_indices.add(k2);
//                    temp_indices.add(k2+1);
//                }
//            }
//        }

    for(double v = -Math.PI/2; v<= Math.PI/2; v+=Math.PI/60){
        for(double u = -Math.PI; u<= Math.PI; u+=Math.PI/60){
            float tempZ = 0.5f * (float) v * (float)( Math.cos(u));
            float tempY = 0.5f * (float) v * (float)(Math.sin(u));
            float tempX = 0.5f * (float) v;
            temp_indices.add(new Vector3f(tempX,tempY,tempZ));
        }
    }

    this.vertices = temp_indices;

//        ibo = glGenBuffers();
//        glBindBuffer(GL_ELEMENT_ARRAY_BUFFER,ibo);
//        glBufferData(GL_ELEMENT_ARRAY_BUFFER,Utils.listoInt(index),GL_STATIC_DRAW);


}
    public void draw() {
        drawSetup();
        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_LINE_STRIP, 0, vertices.size());
    }
}

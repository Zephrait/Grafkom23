package Engine;

import org.joml.Vector3f;
import org.joml.Vector4f;

import java.util.ArrayList;
import java.util.List;

public class Circle extends Object {
    List<Float> centerPoint;
    Float radiusX;
    Float radiusY;

    public Circle(List<ShaderModuleData> shaderModuleDataList, List<Vector3f> vertices, Vector4f color, List<Float> centerPoint, Float radiusX, Float radiusY) {
        super(shaderModuleDataList, vertices, color);
        this.centerPoint = centerPoint;
        this.radiusX = radiusX;
        this.radiusY = radiusY;

    }

    public static List<Vector3f> createCircle(float x,float y, float rx,float ry) {
        List<Vector3f> circle = new ArrayList<>();

        for (double i = 0; i<=360;i+=0.1) {
            float xt = (float) (x+rx * Math.sin(Math.toRadians(i)));
            float yt = (float) (y+ry * Math.cos(Math.toRadians(i)));
            float z = 0;
            circle.add(new Vector3f (xt,yt,z));
            System.out.println(xt);


        }
        return circle;
    }


}

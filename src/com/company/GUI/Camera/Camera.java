package com.company.GUI.Camera;

import com.company.Math.Matrix.Matrix4;
import com.company.Math.Vector.Vector3;
import com.company.Math.Vector.Vector4;

public class Camera implements ICamera{
    private Matrix4 translate, rotate, scale, projection;

    public Camera() {
        translate = Matrix4.one();
        rotate = Matrix4.one();
        scale = Matrix4.one();
        projection = Matrix4.one();
    }

    @Override
    public Vector3 w2s(Vector3 v) {
        return projection.mul(translate.mul(rotate.mul(scale.mul(new Vector4(v, 1))))).asVector3();
    }

    public void modifyRotation(Matrix4 matrix4){
        this.rotate = matrix4.mul(this.rotate);
    }
    public void modifyTranslate(Matrix4 matrix4){
        this.translate = matrix4.mul(this.translate);
    }
    public void modifyScale(Matrix4 matrix4){
        this.scale = matrix4.mul(this.scale);
    }
    public void modifyProjection(Matrix4 matrix4){
        this.projection = matrix4.mul(this.projection);
    }

    public Matrix4 getProjection() { return projection; }
    public void setProjection(Matrix4 projection) { this.projection = projection; }

    public Matrix4 getRotate() { return rotate; }
    public void setRotate(Matrix4 rotate) { this.rotate = rotate; }

    public Matrix4 getScale() {
        return scale;
    }
    public void setScale(Matrix4 scale) {
        this.scale = scale;
    }

    public Matrix4 getTranslate() {
        return translate;
    }
    public void setTranslate(Matrix4 translate) {
        this.translate = translate;
    }


}

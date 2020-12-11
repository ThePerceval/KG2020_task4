package com.company.Math.Matrix;

import com.company.Math.Vector.Vector4;

public class Matrix4 {
    private double[] matrix;

    public Matrix4(double[][] m) {
        matrix = new double[16];
        for (int i = 0; i < 4; i++)
            System.arraycopy(m[i], 0, matrix, i * 4, 4);

    }

    private Matrix4(double[] matrix) {
        this.matrix = matrix;
    }

    private double getAt(int row, int col){
        return matrix[row * 4 + col];
    }

    void setAt(int row, int col, double value){
        matrix[row * 4 + col] = value;
    }

    public static Matrix4 zero() {
        return new Matrix4(new double[16]);
    }

    public static Matrix4 one() {
        Matrix4 m = zero();
        for (int i = 0; i < 4; i++)
            m.setAt(i, i, 1);
        return m;
    }

    public Matrix4 mul(double number) {
        double[] arr = new double[16];
        for (int i = 0; i < arr.length; i++)
            arr[i] = this.matrix[i] * number;
        return new Matrix4(arr);
    }

    public Vector4 mul(Vector4 v) {
        double[] arr = new double[4];
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                arr[i] += this.getAt(i, j) * v.at(j);
        return new Vector4(arr[0], arr[1], arr[2], arr[3]);
    }

    public Matrix4 mul(Matrix4 m) {
        Matrix4 r = zero();
        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 4; j++)
                for (int k = 0; k < 4; k++)
                    r.setAt(i, j, r.getAt(i, j) +
                            this.getAt(i, k) * m.getAt(k, j));
        return r;
    }
}

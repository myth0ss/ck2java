
package com.hieuthao.model;

/**
 *
 * @author MinhHieu
 */
public class Model_Reicever_Img {
    private int fileID;
    private String image;
    private int width;
    private int height;

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Model_Reicever_Img() {
    }

    public Model_Reicever_Img(int fileID, String image, int width, int height) {
        this.fileID = fileID;
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    
}

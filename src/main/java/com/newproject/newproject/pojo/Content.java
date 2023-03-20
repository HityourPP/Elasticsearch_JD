package com.newproject.newproject.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Content {
    private String title;
    private String img;
    private String price;
    //可以自主添加属性
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setImg(String img) {
        this.img = img;
    }

}

package com.terry.biz;

public class Apple {
    @FruitName("Apple")
    private String appleName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    public String getAppleName() {
        return appleName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String displayName() {
        return "水果的名字是:" + appleName + "水果的颜色是:" + appleColor;
    }
}

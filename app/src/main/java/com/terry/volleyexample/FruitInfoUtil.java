package com.terry.volleyexample;

import com.terry.biz.FruitColor;
import com.terry.biz.FruitName;

import java.lang.reflect.Field;


/**
 * Created by Terry on 2014/9/2.
 */
public class FruitInfoUtil {
    public static void getFruitInfo(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                try {
                    field.setAccessible(true);
                    field.set(obj, fruitName.value());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            } else if (field.isAnnotationPresent(FruitColor.class)) {
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                try {
                    field.setAccessible(true);
                    field.set(obj, fruitColor.fruitColor().toString());
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }

        }

    }
}

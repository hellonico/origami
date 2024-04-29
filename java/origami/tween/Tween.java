package origami.tween;

import org.opencv.core.RotatedRect;
import origami.Filters;

import java.lang.reflect.Field;
import java.util.List;

public abstract class Tween implements Runnable {

    public String fieldName = "squareSize";


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    Object target;

    public Tween target(Object f) {
        target = f;
        return this;
    }

    public Tween field(String f) {
        this.setFieldName(f);
        return this;
    }

    private Field getField() {
        String rField = this.fieldName.contains(".") ? this.fieldName.substring(this.fieldName.indexOf(".") + 1) : this.fieldName;
        try {
            return getTarget().getClass().getField(rField);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getTarget() {
        if(target instanceof Tweens) {
            String sindex = this.fieldName.contains(".") ? this.fieldName.substring(0,this.fieldName.indexOf(".")) : this.fieldName;
            int index = Integer.parseInt(sindex);
            return ((Tweens) target).getTweens().get(index);
        } else {
            return target;
        }
    }


    public int getInt() {
        try {
            return getField().getInt(getTarget());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<RotatedRect> getRects() {
        try {
            return (List<RotatedRect>) getField().get(getTarget());
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public void setFieldValue(double i) throws IllegalAccessException {
        Field field = getField();
        Object target = getTarget();

        if (field.getType().getSimpleName().equals("int")) {
            field.set(target, (int) i);
        } else {
            field.set(target, i);
        }
        System.out.println(">" + field.get(target));
    }

}

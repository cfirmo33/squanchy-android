package net.squanchy.support.view;

import android.view.MotionEvent;
import android.view.View;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Hotspot {

    public static Hotspot from(MotionEvent motionEvent) {
        return new AutoValue_Hotspot(motionEvent.getX(), motionEvent.getY());
    }

    @SuppressWarnings("MagicNumber")    // Just dividing by two to get the centre
    public static Hotspot fromCenterOf(View view) {
        float x = view.getX() + view.getWidth() / 2f;
        float y = view.getY() + view.getHeight() / 2f;

        return new AutoValue_Hotspot(x, y);
    }

    public abstract float x();

    public abstract float y();

    public Hotspot offsetToParent(View parent) {
        return new AutoValue_Hotspot(x() + parent.getX(), y() + parent.getY());
    }
}

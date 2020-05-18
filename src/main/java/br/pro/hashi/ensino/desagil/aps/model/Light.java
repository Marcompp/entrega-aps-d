package br.pro.hashi.ensino.desagil.aps.model;

import java.awt.*;

public class Light implements Receiver {
    private Color color;
    private Color offcolor;
    private Emitter emitter;

    public Light(int r, int g, int b, int r2, int g2, int b2) {
        color = new Color(r, g, b);
        offcolor = new Color(r2, g2, b2);
        emitter = null;
    }

    public Color getColor() {
        if (emitter != null && emitter.read()) {
            return color;
        }
        return offcolor;
    }

    public void setColor(Color color) {
        if (emitter != null && emitter.read()) {
            this.color = color;
        } else {
            this.offcolor = color;
        }
    }

    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex != 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        this.emitter = emitter;
    }
}
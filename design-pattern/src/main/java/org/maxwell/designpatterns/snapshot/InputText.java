package org.maxwell.designpatterns.snapshot;

/**
 * @author Maxwell
 * @description:
 * @email: maodihui@foxmail.com
 * @date: 2022/11/24 15:19
 */
public class InputText {
    private final StringBuilder text = new StringBuilder();

    public String getText() {
        return text.toString();
    }

    public void append(String input) {
        text.append(input);
    }

    public Snapshot creatSnapshot(){
        return new Snapshot(text.toString());
    }
    public void restoreSnapshot(String text) {
        this.text.replace(0, this.text.length(), text);
    }

}
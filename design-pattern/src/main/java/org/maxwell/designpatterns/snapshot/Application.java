package org.maxwell.designpatterns.snapshot;

import java.util.Scanner;

/**
 * @author Maxwell
 * @description: 备忘录模式
 * @email: maodihui@foxmail.com
 * @date: 2022/11/24 15:49
 */
public class Application {

    public static void main(String[] args) {
        InputText inputText = new InputText();
        SnapshotHolder holder = new SnapshotHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.next();
            if (":exit".equals(input))
                break;
            if (input.equals(":list")) {
                System.out.println(inputText.getText());
            } else if (input.equals(":undo")) {
                Snapshot prv = holder.popSnapshot();
                inputText.restoreSnapshot(prv.text());
            } else {
                holder.pushSnapshot(inputText.creatSnapshot());
                inputText.append(input);
            }
        }
    }


}
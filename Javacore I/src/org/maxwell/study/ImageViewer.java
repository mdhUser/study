package org.maxwell.study;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @description:
 * @author: Maxwell
 * @email: maodihui@foxmail.com
 * @date: 2022/5/3 10:28
 */
public class ImageViewer {

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
        });

    }

}

class ImageViewerFrame extends Frame {

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 400;

    public ImageViewerFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var label = new JLabel();
        add(label);

        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        var menuBar = new MenuBar();
        setMenuBar(menuBar);

        var menu =new Menu("File");
        menuBar.add(menu);


    }

}
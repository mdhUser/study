package com.maxwell.base.inter;

public class MP3 implements Player {
    @Override
    public void play() {
        System.out.println("播放");
    }

    @Override
    public void pause() {
        System.out.println("暂停");
    }

    @Override
    public void stop() {
        System.out.println("停止");
    }
}

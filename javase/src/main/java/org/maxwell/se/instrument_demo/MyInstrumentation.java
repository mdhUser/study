package org.maxwell.se.instrument_demo;

import java.lang.instrument.Instrumentation;

public class MyInstrumentation {

    private static volatile Instrumentation instrumentation;

    public static void premain(String agentArgs, Instrumentation inst) {
        instrumentation = inst;
    }

    public static Instrumentation getInstrumentation() {
        return instrumentation;
    }

}

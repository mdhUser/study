package org.maxwell.se.instrument_demo;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.Instrumentation;

public class LocalVariableInstrumentation {

//    public static void premain(String agentArgs, Instrumentation inst) {
//        inst.addTransformer((loader, className, classBeingRedefined, protectionDomain, classfileBuffer) -> {
//            if (className.startsWith("your/package/")) {
//                try {
//                    ClassPool classPool = ClassPool.getDefault();
//                    CtClass ctClass = classPool.get(className.replace("/", "."));
//
//                    CtMethod[] methods = ctClass.getDeclaredMethods();
//                    for (CtMethod method : methods) {
//                        System.out.println("Method Name: " + method.getName());
//                        System.out.println("Local Variables:");
//                        int localVarIndex = 1; // First local variable index
//                        for (int i = 0; i < method.getParameterTypes().length; i++) {
////                            System.out.println(method.getParameterTypes()[i] + " " + method.getParameterName(i + localVarIndex));
//                        }
//                    }
//
//                    return ctClass.toBytecode();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//            return null;
//        });
//    }
}

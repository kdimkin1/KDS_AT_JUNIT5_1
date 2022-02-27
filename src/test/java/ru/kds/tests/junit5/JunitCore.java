package ru.kds.tests.junit5;

import org.junit.jupiter.api.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JunitCore {

    public static void main(String[] args) throws Exception {
        // lookup classes with annotations  (@BeforeAll, @Test, @AfterAll)
        // here we go with class SimpleTest.class

        Class clazz = SimpleTest.class;

// example for using IDEA (how to get cicle from method):
// Alt+Enter => Iterate over  Method[]
//        for (Method declaredMethod : clazz.getDeclaredMethods()) {
//
//        }

        // 1) for @BeforeAll annotation:
        // 1.1) get all methods from Class "clazz"
        for (Method method : clazz.getDeclaredMethods()) {
            BeforeAll methodAnnotationBeforeAll = method.getAnnotation(BeforeAll.class);
            if (methodAnnotationBeforeAll != null) {
                // 1.2) run method with @BeforeAll
                method.invoke(clazz.getConstructor().newInstance());
                System.out.println("BeforeAll test passed: " + method.getName());
            }
        }
        System.out.println("========================================================");

        // 2) for @Test annotation (with @BeforeEach and @AfterEach):
        // 2.1) get all methods from Class "clazz"
        for (Method method : clazz.getDeclaredMethods()) {

            Test methodAnnotationTest = method.getAnnotation(Test.class);
            if (methodAnnotationTest != null) {
                //BeforeEach (begin)
                for (Method methodBE : clazz.getDeclaredMethods()) {
                    BeforeEach methodAnnotationBeforeEach = methodBE.getAnnotation(BeforeEach.class);
                    if (methodAnnotationBeforeEach != null) {
                        // run method with @BeforeEach
                        methodBE.invoke(clazz.getConstructor().newInstance());
                        System.out.println("BeforeEach tests passed: " + methodBE.getName() + "\n (Before @Test method:" + method.getName() +")");
                    }
                }
                //BeforeEach (end)

                // 2.2) run method with @Test
                try {
                    method.invoke(clazz.getConstructor().newInstance());
                } catch (InvocationTargetException e) {
                    if (e.getCause() instanceof AssertionError) {
                        System.out.println("Test failed: " + method.getName());

                        //AfterEach (begin)
                        for (Method methodAE : clazz.getDeclaredMethods()) {
                            AfterEach methodAnnotationBeforeEach = methodAE.getAnnotation(AfterEach.class);
                            if (methodAnnotationBeforeEach != null) {
                                // run method with @AfterEach
                                methodAE.invoke(clazz.getConstructor().newInstance());
                                System.out.println("AfterEach tests passed: " + methodAE.getName() + "\n (After @Test method:" + method.getName() + ")");
                                System.out.println("-------------------------------------------");
                            }
                        }
                        //AfterEach (end)


                        continue;
                    } else {
                        System.out.println("Test broken: " + method.getName());
                        //AfterEach (begin)
                        for (Method methodAE : clazz.getDeclaredMethods()) {
                            AfterEach methodAnnotationBeforeEach = methodAE.getAnnotation(AfterEach.class);
                            if (methodAnnotationBeforeEach != null) {
                                // run method with @AfterEach
                                methodAE.invoke(clazz.getConstructor().newInstance());
                                System.out.println("AfterEach tests passed: " + methodAE.getName() + "\n (After @Test method:" + method.getName() + ")");
                                System.out.println("-------------------------------------------");
                            }
                        }
                        //AfterEach (end)

                        continue;
                    }
                }
                System.out.println("Test passed: " + method.getName());
                //AfterEach (begin)
                for (Method methodAE : clazz.getDeclaredMethods()) {
                    AfterEach methodAnnotationBeforeEach = methodAE.getAnnotation(AfterEach.class);
                    if (methodAnnotationBeforeEach != null) {
                        // run method with @AfterEach
                        methodAE.invoke(clazz.getConstructor().newInstance());
                        System.out.println("AfterEach tests passed: " + methodAE.getName() + "\n (After @Test method:" + method.getName() + ")");
                        System.out.println("-------------------------------------------");
                    }
                }
                //AfterEach (end)

            }
        }

        System.out.println("All methods with annotation @Test executed.");
        System.out.println("========================================================");

        // 3) for @AfterAll annotation:
        // 3.1) get all methods from Class "clazz"
        for (Method method : clazz.getDeclaredMethods()) {

            AfterAll methodAnnotationAfterAll = method.getAnnotation(AfterAll.class);
            if (methodAnnotationAfterAll != null) {
                // 3.2) run method with @AfterAll
                method.invoke(clazz.getConstructor().newInstance());
                System.out.println("AfterAll tests passed: " + method.getName());
            }
        }


    }
}
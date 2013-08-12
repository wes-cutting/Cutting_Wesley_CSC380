package edu.neumont.csc380.ds2.server;

import org.omg.Dynamic.Parameter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.net.URL;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 7/14/13
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class MeThread_2 extends Thread {

    List<Class> classes;
    Method[] methods;
    int methodChoice;
    String path = "edu.neumont.csc380.ds2.resources";

    Socket socket;
    public MeThread_2(Socket s){
        socket = s;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input, output;

            // 1
            {
                output = "Welcome to Math Server";
                out.println(output);
                output = getClasses(path);
                out.println(output);
            }
            // 2
            {
                input = in.readLine();
                int classChoice = Integer.parseInt(input);
                output = getMethods(classes.get(classChoice).getName());
                out.println(output);
            }
            // 3
            {
                input = in.readLine();
                methodChoice = Integer.parseInt(input);
            }
            // 4
            {
                input = in.readLine();
                Object result = invokeMethod(input);
                output = result.toString();
            }
            // 5
            {
                out.println(output);
                output = "Thanks for stopping by.";
                out.println(output);
            }


            in.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private String getClasses(String path){
        getClassesInPackage(path);
        String classesAvailable = "";
        for(Class c : classes){
            String classPath = c.getName();
            String[] splitPath = classPath.split("\\.");
            classesAvailable += splitPath[splitPath.length - 1] + ";";
        }
        classesAvailable = classesAvailable.substring(0, classesAvailable.length() - 1);
        return classesAvailable;
    }

    public void getClassesInPackage(String packageName)  {
        URL packageUrl = this.getClass().getClassLoader().getResource(packageName.replace(".", "/"));
        List allClasses = new ArrayList<>();
        try{
            if(packageUrl != null) {
                Path packagePath = Paths.get(packageUrl.toURI());
                if(Files.isDirectory(packagePath)) {
                    try(DirectoryStream<Path> ds = Files.newDirectoryStream(packagePath, "*.class")) {
                        for(Path d : ds) {
                            allClasses.add(Class.forName(packageName + "." + d.getFileName().toString().replace(".class", "")));
                        }
                    }
                }
                classes = allClasses;
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    // Parse Methods objects of the class at the given path into a single String
    private String getMethods(String classPath){
        reflectOnClass(classPath);
        String methodsAvailable = "";
        if(methods.length > 0){
            for(Method m : methods){
                methodsAvailable += m.getName() + ";";
            }
            methodsAvailable = methodsAvailable.substring(0, methodsAvailable.length() - 1);
        }
        return methodsAvailable;
    }

    // Get the available Methods of the class at the given path
    private void reflectOnClass(String classPath){
        try {
            Class myClass = Class.forName(classPath);
            methods = myClass.getDeclaredMethods();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private Object invokeMethod(String input) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Object[] parameters = input.split(",");
        Class instanceObject = Class.forName(path);
        Object callMe = instanceObject.newInstance();
        Method m = instanceObject.getMethod(methods[methodChoice].getName(), Object[].class);
        return m.invoke(callMe, new Object[]{parameters});
    }
}

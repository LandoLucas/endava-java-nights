package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import model.Bart;
import model.Homero;
import model.Simpson;

public class Main {

    public static void main(String[] args) {
        
        Simpson homer = new Homero(false);
        Bart bart = new Bart();
        
        
        //Obtain an object class
        Class homerClass =  homer.getClass();      
        Class bartClass = bart.getClass();
        System.out.println("Homer's class is: " + homerClass.getName());
        System.out.println("Bart's class is: " + bartClass.getName());
        System.out.println("Homer's class class? " + homerClass.getClass().getName() + "\n");
        
        //Get a class contructor
        try {
            Constructor homersConstructor = homerClass.getConstructor(Boolean.class); 
            Constructor bartsConstructor = bartClass.getConstructor(); 
            
            System.out.println("Bart's constructor is " + bartsConstructor.getName());
            System.out.println("Homer's constructor is " + homersConstructor.getName() + "\n"); 
            
        }catch (NoSuchMethodException nsme) {
            System.out.println("No such method Exception!:" + nsme.getMessage());
        }
        
        
        //See what Methods the object has
        Method[] homerMethods = homerClass.getMethods();   
        for (Method method:homerMethods) 
            System.out.println("Homer's methods: " + method.getName());
        System.out.println("\n");
        
        Method[] bartMethods = bartClass.getMethods();   
        for (Method method:bartMethods) 
            System.out.println("Bart's methods: " + method.getName()); 
        System.out.println("\n");
        
        
        //Invocation of methods
        try {
            Method isHomerDrunk = homerClass.getDeclaredMethod("isDrunk");
            Object result = isHomerDrunk.invoke(homer);
            System.out.println("Is homer drunk? " + result.toString());
            
            System.out.println("mmm tal vez humedezca my gañote... \n");
            
            Method setIsHomerDrunk = homerClass.getDeclaredMethod("setDrunk", Boolean.class);
            setIsHomerDrunk.invoke(homer, true);
            result = isHomerDrunk.invoke(homer);
            System.out.println("Is homer drunk now? " + result.toString());
            
            System.out.println("Escena desaparecida, desaparecida, fin. \n");
            
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            System.out.println("Exception! " + e.getMessage());
        } 
  
        
        try {
            Field field = homerClass.getDeclaredField("job");
            field.setAccessible(true); //Exception thrown if getting a private field value
            
            System.out.println("What is homer's job? " + field.get(homer));
            
            field.set(homer, "astronauta");
            
            System.out.println("What is homer's job in this episode? " + field.get(homer));
            
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            System.out.println("Exception! " + e.getMessage());
        } 

        
        //Obtain superclass and interfaces
        Class homersSuperClass = homerClass.getSuperclass();
        System.out.println("What's homer superclass? " + homersSuperClass.getName());
        
        Class[] homersInterfaces = homerClass.getInterfaces();
        for(Class interf: homersInterfaces) {
            System.out.println("Interface: " + interf.getName() + "\n");
        }
        
        
        //New instance
        try {
            Bart hugo = (Bart) bartClass.newInstance();
            
            Field f = bartClass.getDeclaredField("catchphrase");
            f.setAccessible(true);
            f.set(hugo, "Estuve practicando, mira, hice una rata-paloma");
            Object hugosCatchphrase = bartClass.getMethod("sayChatchphrase").invoke(hugo);
            System.out.println("Hugo: " + hugosCatchphrase.toString() + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }

}

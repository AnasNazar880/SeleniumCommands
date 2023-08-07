package org.obs.basics;
import java.util.ArrayList;
import java.util.Iterator;
public class ListPrograms {
    public static void main(String[] args) {
        ArrayList<String> languages = new ArrayList<String>();
        languages.add("java");
        languages.add("php");
        languages.add(".net");
        languages.add("ruby");
        int size1 = languages.size();
        System.out.println("the size of the arraylist is :" + size1);
        if (languages.contains("python")) {
            System.out.println("python is in the list");
        } else {
            System.out.println("python is not in the list");
            languages.add("python");
            System.out.println("the python included list is:" + languages);
        }
        int index1 = languages.indexOf("python");
        System.out.println("the index of python is :" + index1);
        if (languages.contains("ruby")) {
            languages.set(3, "HTML");
            //int r=languages.indexOf("ruby");
            //System.out.println("the index of ruby is :"+r);
            //languages.add("HTMl");
            System.out.println("the updated list is :" + languages);
            ;
        }
        Iterator itr = languages.iterator();//getting elements through iterator
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        System.out.println();
        for (String i : languages) //getting elements through the for loop
            System.out.println(i);
    }
}




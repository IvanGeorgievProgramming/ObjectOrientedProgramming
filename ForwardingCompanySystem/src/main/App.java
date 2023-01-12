package main;

import main.helloworld.HelloWorld;

public class App {
    public static int main(String[] args) throws Exception {
        String str = new HelloWorld().sayHello();
        System.out.println(str);

        return 0;
    }
}

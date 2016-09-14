package dagger;


import dagger.internal.MembersInjectors;

public class ArneMain {

    public static void main(String[] args) {
//        Target t = DaggerDiConfig.create().createTarget();
//        t.sayHello();
//        DaggerDiConfig.builder().targetModule(new DiConfig.TargetModule()).build();
        Target t = new Target();
//        DaggerDiConfig.create().createTarget().sayHello();
//        DaggerDiConfig.create().enableInjectionsTo(t);
        t.sayHello();
    }
}

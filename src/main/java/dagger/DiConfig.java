package dagger;

import dagger.repository.UserRepo;
import dagger.repository.db.EsClient;
import dagger.rest.DaggerApp;
import dagger.rest.DaggerConf;
import dagger.service.UserService;

import javax.inject.Singleton;

@Singleton
@Component(modules = {
    DiConfig.ConfigModule.class
//    DiConfig.EsModule.class
})
public interface DiConfig {
    //    Target createTarget();
    UserService createUserService();
//    EsClient createEsClient();

//    void enableInjectionsTo(Target target);
//    void injectInto(DaggerApp target);

    //    @Module
//    class TargetModule {
//        @Provides
//        Target provideTarget() {
//            return new Target();
//        }
//    }
//
    @Module
    class ConfigModule {

        private DaggerConf conf;

        public ConfigModule(DaggerConf conf) {
            this.conf = conf;
        }

        @Provides
        DaggerConf provideConfig() {
            return conf;
        }
    }
//
//    @Module
//    class EsModule {
////        @Provides
////        @Singleton
////        EsClient provideEsClient() {
////            return new EsClient();
////        }
//    }

}


package guru.springframework.services;

public class GreetingServiceFactory {

    private GreetingRepository greestingRepository;

    public GreetingServiceFactory(GreetingRepository greestingRepository) {
        this.greestingRepository = greestingRepository;
    }

    public GreetingService createGreetingService(String lang){

        switch (lang){
            case "en":
                return new PrimaryGreetingService(greestingRepository);
            case "de":
                return new PrimaryGermanGreetingService(greestingRepository);
            case "es":
                return new PrimarySpanishGreetingService(greestingRepository);
            default:
                return new PrimaryGreetingService(greestingRepository);
        }
    }
}

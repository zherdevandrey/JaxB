import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        City moscow = new City(1, "Moscow");
        City london = new City(1, "London");
        City paris = new City(1, "Paris");

        Country country = new Country();
        country.setId(1);
        country.setName("Russia");

        List<City> cities = Arrays.asList(moscow, london, paris);
        country.setCities(cities);

        try {
            JAXBContext context = JAXBContext.newInstance(Country.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(country, new File("src/main/resources/country.xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}

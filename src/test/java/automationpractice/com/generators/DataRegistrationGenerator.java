package automationpractice.com.generators;

import automationpractice.com.model.DataRegistration;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import org.apache.commons.lang3.RandomStringUtils;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class DataRegistrationGenerator {
    @Parameter(names = "-c", description = "Group counts")
    public int count;
    @Parameter(names = "-f", description = "Target file")
    public  String file;
    @Parameter(names = "-d", description = "Format file")
    public  String format;

    public static void main(String[] args) throws IOException {
        DataRegistrationGenerator generator = new DataRegistrationGenerator();
        JCommander jCommander = new JCommander();
        try{
            jCommander.newBuilder().addObject(generator).build().parse(args);
        }catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();

    }

    private void run() throws IOException {
        List<DataRegistration> groups = generateData(count);
        if (format.equals("csv")) {
            saveAsCsv(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXml(groups, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(groups, new File(file));
        } else {
            System.out.println("unrecognized format" + format);
        }

    }

    private void saveAsJson(List<DataRegistration> dataRegistrations, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(dataRegistrations);
        try(Writer writer= new FileWriter(file);){
            writer.write(json);
        }
    }

    private void saveAsXml(List<DataRegistration> dataRegistrations, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(DataRegistration.class);
        String xml = xstream.toXML(dataRegistrations);
        try(Writer writer= new FileWriter(file);){
            writer.write(xml);
        }
    }


    private static void saveAsCsv(List<DataRegistration> dataRegistrations, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try(Writer writer = new FileWriter(file)) {
            for (DataRegistration dataRegistration : dataRegistrations) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s;%s;%s;\n", dataRegistration.getFirstName(),dataRegistration.getLastName(),
                        dataRegistration.getPassword(),dataRegistration.getCompany(),
                        dataRegistration.getAdress(),dataRegistration.getCity(),
                        dataRegistration.getPostcode(),dataRegistration.getPhoneMobile()));
            }
        }
    }

    private static List<DataRegistration> generateData(int count) {

        List<DataRegistration> dataRegistrations = new ArrayList<>();
        int i;
        for( i = 0;i < count;i++) {
            String name = RandomStringUtils.randomAlphabetic(10);
            String lastname = RandomStringUtils.randomAlphabetic(10);
            String email = RandomStringUtils.randomAlphabetic(10)
                    + "@" + RandomStringUtils.randomAlphabetic(5)
                    + "." + RandomStringUtils.randomAlphabetic(2);
            String city = RandomStringUtils.randomAlphabetic(10);
            String company = RandomStringUtils.randomAlphabetic(10);
            String s = RandomStringUtils.randomAlphanumeric(10);
            String postcode = RandomStringUtils.randomNumeric(5);
            String phoneMobile = RandomStringUtils.randomNumeric(10);

            dataRegistrations.add(new DataRegistration().setFirstName(name).setLastName(lastname).setEmail(email)
                    .setPassword(s).setCompany(company)
                    .setAdress(s).setCity(city)
                    .setPostcode(postcode).setPhoneMobile(phoneMobile));

        }
        return dataRegistrations;

    }
}
